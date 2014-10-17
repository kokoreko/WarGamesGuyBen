package TzukEitan.war;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import TzukEitan.listeners.WarEventListener;
import TzukEitan.utils.Constans;


public class WarDb {
	private List<WarEventListener> allListeners;
	private Connection connection = null;
	private int warDbId;
	public WarDb() {
		allListeners = new LinkedList<WarEventListener>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			connection = DriverManager.getConnection(Constans.DB_URL, Constans.DB_USER, Constans.DB_PASWORD);

			System.out.println("Database connection established");
			LocalDateTime timePoint = LocalDateTime.now();
			String cmd = "INSERT INTO wars (StartDate) VALUES ('"+timePoint+"')";
			String cmd2 = "SELECT id FROM wars ORDER BY id DESC";
			try (Statement statment = connection.createStatement()){
				
				statment.executeUpdate(cmd);
				ResultSet rs = statment.executeQuery(cmd2);
				rs.next();
				warDbId =rs.getInt("id");
				System.out.println("War id Index is : " + warDbId);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public void registerListeners(WarEventListener listener) {
		allListeners.add(listener);
	}
	
	/**
	 * Close working connection
	 */
	public void closeConnection(){
		if (connection != null){
			try{
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}



	public void addEnemyLauncher(String launcherId, boolean isHidden) {
	
		String cmd = "INSERT INTO enemy_launcher (warId,id,isHidden) VALUES ('"+warDbId+"','"+launcherId+"',"+(isHidden ? true:false)+")";
		try (Statement statment = connection.createStatement()){
			
			int numOfAffectedRows = statment.executeUpdate(cmd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void launchEnemyMissile(String missileId, String launcherId,String destination,int damage,int flyTime){
		
		String cmd = "INSERT INTO enemy_missile (warId,id,whoLaunchedMeId,destination,flyTime,damage) VALUES "
				+ "								 ('"+warDbId+"','"+missileId+"','"+launcherId+"','"+destination+"','"+flyTime+"','"+damage+"')";
		try (Statement statment = connection.createStatement()){
			
			int numOfAffectedRows = statment.executeUpdate(cmd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
