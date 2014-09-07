package TzukEitan.view;

import java.util.List;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import TzukEitan.listeners.WarEventUIListener;



import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.BorderLayout;



import javax.swing.JButton;

import java.awt.Color;
import java.awt.image.BufferedImage;


import javax.swing.JList;

import com.sun.prism.Image;

public class SwingView extends JFrame{
	private List<WarEventUIListener> allListeners;
	private JPanel upPanel;
	private JPanel pnLog;
	private JLabel lblLogTitle;
	private JPanel buttonsPanel;
	private JScrollPane spLogList;
	private JScrollPane spMap;
	private JPanel pnMap;
	private BufferedImage map;
	private JLabel mapLabel;
	public SwingView(){
		getContentPane().setLayout(new BorderLayout(0, 0));
		pnMap= new JPanel();
		upPanel = new JPanel();
		getContentPane().add(upPanel, BorderLayout.CENTER);
		upPanel.setLayout(new BorderLayout(0, 0));
		
		pnLog = new JPanel();
		pnLog.setBackground(Color.LIGHT_GRAY);
		upPanel.add(pnLog, BorderLayout.EAST);
		pnLog.setLayout(new BorderLayout(20, 20));
		
		JLabel lblLogTitle = new JLabel("War log updates");
		pnLog.add(lblLogTitle, BorderLayout.NORTH);
		
		JLabel lblLauncher = new JLabel("");
		lblLauncher.setIcon(new ImageIcon("D:\\Kosta\\git\\WarGamesGuyBen\\src\\GUI\\launcher.png"));
		lblLauncher.setLocation(500, 500);
		pnMap.add(lblLauncher);
		
		
		mapLabel = new JLabel(new ImageIcon("D:\\Kosta\\git\\WarGamesGuyBen\\src\\GUI\\Israel_relief_location_mapSmall.jpg"));           
		pnMap.add(mapLabel);
		spMap = new JScrollPane(pnMap);
		upPanel.add(spMap,BorderLayout.CENTER);
		buttonsPanel = new JPanel();
		buttonsPanel.setBackground(Color.LIGHT_GRAY);
		createButtons();
		getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
		buttonsPanel.setLayout(new GridLayout(2, 4, 2, 2));
		
		setVisible(true);
		
		
	}
	
	private void createButtons(){
		JButton btnAddMissileIntercepter = new JButton("Add Munition to Intercept missile");
		buttonsPanel.add(btnAddMissileIntercepter);
		
		JButton btnLaunchMissile = new JButton("Launch Missile");
		buttonsPanel.add(btnLaunchMissile);
		
		JButton btnAddLauncherIntercepter = new JButton("Add Munition to Intercept launchers");
		buttonsPanel.add(btnAddLauncherIntercepter);
		
		JButton btnAddLauncher = new JButton("Add launcher");
		buttonsPanel.add(btnAddLauncher);
		
		JButton btnInterceptLauncher = new JButton("Intercept a launcher");
		buttonsPanel.add(btnInterceptLauncher);
		
		JButton btnInterceptMissile = new JButton("Intercept a missile");
		buttonsPanel.add(btnInterceptMissile);
		
		JButton btnShowStatistics = new JButton("Show statistics");
		buttonsPanel.add(btnShowStatistics);
		
		JButton btnEndWar = new JButton("End the war");
		btnEndWar.setToolTipText("End the war and show statistics");
		buttonsPanel.add(btnEndWar);
	}
	
	
	
	
}
