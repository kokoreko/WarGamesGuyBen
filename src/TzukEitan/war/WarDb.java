package TzukEitan.war;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
			
			statment.executeUpdate(cmd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void launchEnemyMissile(String missileId, String launcherId,String destination,int damage,int flyTime){
		
		String cmd = "INSERT INTO enemy_missile (warId,id,whoLaunchedMeId,destination,flyTime,damage) VALUES "
				+ "								 ('"+warDbId+"','"+missileId+"','"+launcherId+"','"+destination+"','"+flyTime+"','"+damage+"')";
		try (Statement statment = connection.createStatement()){
			
			statment.executeUpdate(cmd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addDefenseLauncherDestructor(String id, String type) {
		String cmd = "INSERT INTO launcher_destructor (warId,id,type) VALUES "
				+ "								 ('"+warDbId+"','"+id+"','"+type+"')";
		try (Statement statment = connection.createStatement()){
			
			statment.executeUpdate(cmd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void finishWar() {
		
		String cmd = "UPDATE wars SET EndDate = '"+ LocalDateTime.now()+"' WHERE id="+warDbId;
		try (Statement statment = connection.createStatement()){
			
			statment.executeUpdate(cmd);
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public void interceptGivenLauncher(String destructorId, String launcherId) {
		
		String cmd = "UPDATE launcher_destructor SET toDestroyId = '"+ launcherId +"' WHERE id='"+destructorId+"' AND warId="+warDbId ;
		try (Statement statment = connection.createStatement()){
			
			statment.executeUpdate(cmd);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	public void defenseHitInterceptionMissile(String whoLaunchedMeId,
			String missileId, String enemyMissileId) {
		String cmd = "UPDATE enemy_missile SET beenHit=true , hitTime='"+LocalDateTime.now()+"'  WHERE id='"+enemyMissileId+"' AND warId="+warDbId;
		try (Statement statment = connection.createStatement()){
			
			statment.executeUpdate(cmd);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	public void defenseHitInterceptionLauncher(String whoLaunchedMeId,
			String enemyLauncherId) {
		String cmd = "UPDATE enemy_launcher SET beenHit=true , hitTime='"+LocalDateTime.now()+"' , hitBy='"+whoLaunchedMeId+"'  WHERE id='"+enemyLauncherId+"' AND warId="+warDbId;
		try (Statement statment = connection.createStatement()){
			
			statment.executeUpdate(cmd);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public static String getHistoryLog(LocalDateTime start, LocalDateTime end){
		StringBuilder ret = new StringBuilder();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			int DbId = 0;
			Connection connectionSt = DriverManager.getConnection(Constans.DB_URL, Constans.DB_USER, Constans.DB_PASWORD);


			String cmd = "SELECT id FROM wars WHERE StartDate >= '"+start+"' AND EndDate <= '"+end+"'";
			try (Statement statment = connectionSt.createStatement()){


				ResultSet rs = statment.executeQuery(cmd);
				while (rs.next()){
					DbId = rs.getInt("id");
					ret.append("********************* WAR #"+DbId+" *********************");
					ret.append('\n');					
					ret = getMissileHistoryByWarId(DbId,ret,connectionSt);
					ret = getEnemyLauncherHistoryByWarId(DbId,ret,connectionSt);
					ret = getLauncherDestructorHistoryByWarId(DbId,ret,connectionSt);
					ret.append('\n');
					ret.append('\n');
					ret.append('\n');
				}
				


			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e){}


		return ret.toString();

	}

	private static StringBuilder getMissileHistoryByWarId(int id,StringBuilder ret, Connection connection){

		String cmd = "SELECT * FROM enemy_missile WHERE warId="+id;
		try (Statement statment = connection.createStatement()){
			ResultSet rs = statment.executeQuery(cmd);
			while (rs.next()){
				ret.append("Missile: ");
				ret.append(rs.getString("id"));
				ret.append(" ");
				ret.append("Launched by: ");
				ret.append(rs.getString("whoLaunchedMeId"));
				ret.append(" ");
				ret.append("To : ");
				ret.append(rs.getString("destination"));
				ret.append(" ");
				ret.append("with damage by: ");
				ret.append(rs.getInt("damage"));

				ret.append("Flew for : ");
				ret.append(rs.getInt("flyTime"));
				ret.append(" ");
				if(rs.getBoolean("beenHit")){
					ret.append("was intercepted in ");
					ret.append(rs.getTimestamp("hitTime"));

				} else {
					ret.append("HIT HIS TAEGER!");
				}
				ret.append('\n');
			}
		} catch (Exception e) {

		}
		return ret;
	}
	private static StringBuilder getLauncherDestructorHistoryByWarId(int id,StringBuilder ret, Connection connection){

		String cmd = "SELECT * FROM launcher_destructor WHERE warId="+id;
		try (Statement statment = connection.createStatement()){
			ResultSet rs = statment.executeQuery(cmd);
			while (rs.next()){
				ret.append("Destructor: ");
				ret.append(rs.getString("id"));
				ret.append(" ");
				ret.append("type: ");
				ret.append(rs.getString("type"));
				ret.append(" ");
				ret.append("set to destroy : ");
				ret.append(rs.getString("toDestroyId"));

				ret.append('\n');
			}
		} catch (Exception e) {

		}
		return ret;
	}
	private static StringBuilder getEnemyLauncherHistoryByWarId(int id,StringBuilder ret, Connection connection){

		String cmd = "SELECT * FROM enemy_launcher WHERE warId="+id;
		try (Statement statment = connection.createStatement()){
			ResultSet rs = statment.executeQuery(cmd);
			while (rs.next()){
				ret.append("Enemy Launcher: ");
				ret.append(rs.getString("id"));
				ret.append(" ");
				if(rs.getBoolean("beenHit")){
					ret.append("was hit by : ");
					ret.append(rs.getString("hitBy"));
					ret.append(" ");
					ret.append("in : ");
					ret.append(rs.getTimestamp("HitTime"));
				} 
				ret.append('\n');
			}
		} catch (Exception e) {

		}
		return ret;
	}




}
