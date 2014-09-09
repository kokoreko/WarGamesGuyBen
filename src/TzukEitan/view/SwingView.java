package TzukEitan.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.BorderLayout;






import javax.swing.JButton;

import GUI.frmDestroyLauncher;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingView extends JFrame{
	private JPanel upPanel,pnLog,buttonsPanel,pnMap;
	private JScrollPane spMap;
	private JLabel mapLabel;
	private JButton btnAddMissileIntercepter, btnLaunchMissile,btnAddLauncherIntercepter
					,btnAddLauncher,btnInterceptLauncher,btnInterceptMissile,btnShowStatistics,btnEndWar;
	
	public SwingView(){
		setSize(getMaximumSize());
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
		lblLauncher.setIcon(new ImageIcon("C:\\users\\omri\\git\\WarGamesGuyBen\\src\\GUI\\launcher.png"));
		lblLauncher.setLocation(500, 500);
		pnMap.add(lblLauncher);
		
		
		mapLabel = new JLabel(new ImageIcon("C:\\users\\omri\\git\\WarGamesGuyBen\\src\\GUI\\Israel_relief_location_mapSmall.jpg"));           
		pnMap.add(mapLabel);
		spMap = new JScrollPane(pnMap);
		upPanel.add(spMap,BorderLayout.CENTER);
		buttonsPanel = new JPanel();
		buttonsPanel.setBackground(Color.LIGHT_GRAY);
		createButtons();
		addButtonsListener();
		getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
		buttonsPanel.setLayout(new GridLayout(2, 4, 2, 2));
		
		setVisible(true);
		
		
	}
	 
	private void addButtonsListener() {
		btnAddLauncherIntercepter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frmDestroyLauncher destroy = new frmDestroyLauncher();
				destroy.setAlwaysOnTop(true);
			}
		});
	}

	private void createButtons(){
		btnAddMissileIntercepter = new JButton("Add Munition to Intercept missile");
		buttonsPanel.add(btnAddMissileIntercepter);
		
		btnLaunchMissile = new JButton("Launch Missile");
		buttonsPanel.add(btnLaunchMissile);
		
		btnAddLauncherIntercepter = new JButton("Add Munition to Intercept launchers");
		buttonsPanel.add(btnAddLauncherIntercepter);
		
		btnAddLauncher = new JButton("Add launcher");
		buttonsPanel.add(btnAddLauncher);
		
		btnInterceptLauncher = new JButton("Intercept a launcher");
		buttonsPanel.add(btnInterceptLauncher);
		
		btnInterceptMissile = new JButton("Intercept a missile");
		buttonsPanel.add(btnInterceptMissile);
		
		btnShowStatistics = new JButton("Show statistics");
		buttonsPanel.add(btnShowStatistics);
		
		btnEndWar = new JButton("End the war");
		btnEndWar.setToolTipText("End the war and show statistics");
		buttonsPanel.add(btnEndWar);
	}
	
	
	
	
}
