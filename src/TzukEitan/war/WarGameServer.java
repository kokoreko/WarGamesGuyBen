package TzukEitan.war;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import TzukEitan.missiles.RemoteMissile;


public class WarGameServer extends Thread{
	private static boolean IsRunning=false;
	private Socket socket = null;
	private ServerSocket server;
	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;

	private WarControl warControl;

	public WarGameServer(WarControl warControl ){

		this.warControl = warControl;
		try {
			server = new ServerSocket(7000);
			System.out.println(new Date() + " --> Server waits for client...");
			socket = server.accept(); // blocking
			System.out.println(new Date() + " --> Client connected from "
					+ socket.getInetAddress() + ":" + socket.getPort());
			socket.setSoTimeout(30000);
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			inputStream  = new ObjectInputStream(socket.getInputStream());

			outputStream.writeObject("Welcome to server!");
			System.out.println("*** Sent welcome message to client");

			IsRunning=true;
			start();
		} catch (Exception e) {
			System.out.println(e);
		} 

	}
	
	private boolean addLauncher(){
		if (warControl.addEnemyLauncherUI() != null)
			return true;
		return false;
	}
	
	private ArrayList<String> getLaunchers(){
		return new ArrayList<String>(warControl.showAllLaunchersUI());
		
	}
	
	private ArrayList<String> getDestenations(){
		return (ArrayList<String>) Arrays.asList(warControl.getAllWarDestinationsUI());
	}
	
	public void run(){
		
		String action=null;
		do {
			try {
				action = (String)inputStream.readObject();
			} catch (ClassNotFoundException | IOException e) {

			}
			if(action!=null){
				System.out.println("*** got action "+action);
				switch (action) {
				case "getCitys":

					try {
						outputStream.writeObject(getDestenations().clone());
						System.out.println("*** sended citys");
					} catch (Exception e) {
						// TODO Auto-generated catch block

					}
					break;
				case "getLauncher":

					try {
						outputStream.writeObject(getLaunchers().clone());
						System.out.println("*** sended launchers");
					} catch (Exception e) {


					}
					break;
				case "addMissile":
					try {
						RemoteMissile m = (RemoteMissile)inputStream.readObject();
						warControl.addEnemyMissileUI(m.getWhoLaunchedMeId(), m.getDestination(), m.getFlyTime(), m.getFlyTime());
						System.out.println("*** got missile to " + m.getDestination());
						outputStream.writeObject(new ServerStatus(ServerStatus.STATUS.Accepted));
					} catch (ClassNotFoundException | IOException e) {
						try {
							outputStream.writeObject(new ServerStatus(ServerStatus.STATUS.Deniend));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					break;
				case "addLauncher":
					try {
						System.out.println("*** got add launcher action");
						if(addLauncher()){
							outputStream.writeObject(new ServerStatus(ServerStatus.STATUS.Accepted));
						} else{
							outputStream.writeObject(new ServerStatus(ServerStatus.STATUS.Deniend));
						}
					} catch (IOException e) {
						try {
							outputStream.writeObject(new ServerStatus(ServerStatus.STATUS.Deniend));
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					break;
				default:

					break;
				}
			}
			action=null;
		} while (IsRunning);

		try {
			socket.close();
			server.close();
			System.out
			.println("Sever is closing after client is disconnected");
		} catch (IOException e) { }

//		try {
//			wait();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
