package TzukEitan.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import TzukEitan.GUI.frmAddLauncherDestractor;
import TzukEitan.GUI.frmDestroyLauncher;
import TzukEitan.GUI.frmInterceptMissile;
import TzukEitan.GUI.frmLaunchMissile;
import TzukEitan.GUI.frmShowStats;
import TzukEitan.GUI.pnMissile;
import TzukEitan.listeners.WarEventUIListener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.awt.Dimension;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;
/**
 * 
 * @author Omri Glam
 *
 */
public class SwingView extends JFrame{
	private JPanel upPanel,panLog,buttonsPanel,panCenter,panMissile,panLauncher,panMap,panMissileIntercepter,panLauncherDestractor,missilePanel,test ;
	private JLabel mapLabel,lblLogTitle,lblLaunchers,lblMIssiles,lblMap,lblMissileIntercepter,lblLauncherDestractor;
	private JButton btnAddMissileIntercepter, btnLaunchMissile,btnAddLauncherIntercepter
					,btnAddLauncher,btnInterceptLauncher,btnInterceptMissile,btnShowStatistics,btnEndWar;
	private List<WarEventUIListener> allListeners;
	private List<JFrame> allFrames;
	private JTextArea textArea;
	private JScrollPane spMissiles,spLauncherDestroyer,spMissileIntercepter,spLaunchers;
	


	/**
	 * Constructor of to the war Main Frame
	 */
	public SwingView(){
		allFrames = new LinkedList<JFrame>();
		setSize(new Dimension(1210, 768));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		setLayoutAndStyle();
		createButtons();
		addButtonsListener();
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		allListeners = new LinkedList<WarEventUIListener>();
	}
	 
	private void setLayoutAndStyle() {
		upPanel = new JPanel();
		getContentPane().add(upPanel, BorderLayout.CENTER);
		upPanel.setLayout(new BorderLayout(0, 0));
		
		panLog = new JPanel();
		panLog.setBackground(Color.LIGHT_GRAY);
		upPanel.add(panLog, BorderLayout.EAST);
		panLog.setLayout(new BorderLayout(20, 20));
		
		lblLogTitle = new JLabel("War log updates");
		panLog.add(lblLogTitle, BorderLayout.NORTH);
		
		textArea = new JTextArea();
		panLog.add(textArea, BorderLayout.CENTER);
		panCenter= new JPanel();
		upPanel.add(panCenter, BorderLayout.CENTER);
		panCenter.setLayout(new GridLayout(0, 5, 0, 0));
		
		panLauncher = new JPanel();
		panCenter.add(panLauncher);
		panLauncher.setLayout(new BorderLayout(0, 0));
		
		lblLaunchers = new JLabel("Enemy Launchers");
		lblLaunchers.setHorizontalAlignment(SwingConstants.CENTER);
		panLauncher.add(lblLaunchers, BorderLayout.NORTH);
		
		spLaunchers = new JScrollPane();
		panLauncher.add(spLaunchers);
		
		panMissile = new JPanel();
		panCenter.add(panMissile);
		panMissile.setLayout(new BorderLayout(0, 0));

		test = new JPanel();
//		spMissiles = new JScrollPane(test);
//		panMissile.add(spMissiles);
		
		panMissile.add(test);
		
		lblMIssiles = new JLabel("In Air Missiles");
		lblMIssiles.setHorizontalAlignment(SwingConstants.CENTER);
		panMissile.add(lblMIssiles, BorderLayout.NORTH);
		
		panMap = new JPanel();
		panCenter.add(panMap);
		panMap.setLayout(new BorderLayout(0, 0));
		
		lblMap = new JLabel("Israel Map");
		lblMap.setHorizontalAlignment(SwingConstants.CENTER);
		panMap.add(lblMap, BorderLayout.NORTH);
		
		
		mapLabel = new JLabel(new ImageIcon(getClass().getResource("/TzukEitan/images/Israel_relief_location_mapSmall.jpg")));
		panMap.add(mapLabel);
		
		panMissileIntercepter = new JPanel();
		panCenter.add(panMissileIntercepter);
		panMissileIntercepter.setLayout(new BorderLayout(0, 0));
		
		lblMissileIntercepter = new JLabel("Missile Intercepters");
		lblMissileIntercepter.setHorizontalAlignment(SwingConstants.CENTER);
		panMissileIntercepter.add(lblMissileIntercepter, BorderLayout.NORTH);
		
		spMissileIntercepter = new JScrollPane();
		panMissileIntercepter.add(spMissileIntercepter);
		
		panLauncherDestractor = new JPanel();
		panCenter.add(panLauncherDestractor);
		panLauncherDestractor.setLayout(new BorderLayout(0, 0));
		
		lblLauncherDestractor = new JLabel("Launcher Destractors");
		lblLauncherDestractor.setHorizontalAlignment(SwingConstants.CENTER);
		panLauncherDestractor.add(lblLauncherDestractor, BorderLayout.NORTH);
		
		spLauncherDestroyer = new JScrollPane();
		panLauncherDestractor.add(spLauncherDestroyer);
		buttonsPanel = new JPanel();
		buttonsPanel.setBackground(Color.LIGHT_GRAY);
		
		getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
		buttonsPanel.setLayout(new GridLayout(2, 4, 2, 2));
	}
	
	//Create Buttons Action Listeners
	private void addButtonsListener() {
		btnEndWar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				endWar();
			}
		});
		btnAddMissileIntercepter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fireAddIronDome();
			}
		});
		btnAddLauncher.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			fireAddLauncher();
			}
		});
		
		btnAddLauncherIntercepter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fireAddLauncherIntercepter();
			}
		});
		btnInterceptLauncher.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fireDestroyLauncher();
			}
		});
		btnShowStatistics.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fireShowStats();
			}
		});
		btnLaunchMissile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fireLaunchMissile();
			}
		});
		
		btnInterceptMissile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fireInterceptMissile();
			}
		});
	}
		
	//Button Choice handlers
	protected void fireDestroyLauncher() {
		frmDestroyLauncher DestroyLauncher = new frmDestroyLauncher(allListeners);
		if(DestroyLauncher.getStat() == false){
			JOptionPane.showMessageDialog(this, "All Launchers Are Hidden or Destroyed");
		}
	}
	protected void fireAddLauncher() {
		for (WarEventUIListener l : allListeners)
			l.addEnemyLauncherUI();
	}
	
	protected void fireLaunchMissile() {
		frmLaunchMissile launchMissile = new frmLaunchMissile(allListeners);
		if(launchMissile.getStat() == false){
			JOptionPane.showMessageDialog(this, "All Launchers was Distroyed");
		}
		
	}

	protected void fireInterceptMissile() {
		frmInterceptMissile interceptMissile = new frmInterceptMissile(allListeners);
		if(interceptMissile.getStat() == false){
			JOptionPane.showMessageDialog(this, "No Missiles to intercept");		
		}
	}
	
	protected void fireAddIronDome() {
		for (WarEventUIListener l : allListeners)
			l.addIronDomeUI();
	}

	protected void fireAddLauncherIntercepter() {
		frmAddLauncherDestractor LDF = new frmAddLauncherDestractor(allListeners);
	}

	protected void fireShowStats() {
		for (WarEventUIListener l : allListeners)
			l.showStatisticsUI();
	}

	private void endWar() {
		for (WarEventUIListener l : allListeners)
			l.showStatisticsUI();
		
	}
	
	
	public void registerListeners(WarEventUIListener listener) {
		allListeners.add(listener);
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

	public void showDefenseLaunchMissile(String myMunitionsId,
			String missileId, String enemyMissileId) {
		
		
	}

	public void showStatistics(long[] statisticsToArray) {
		frmShowStats statsFrm = new frmShowStats();
		statsFrm.addStats(statisticsToArray);
		
	}

	public void showEnemyLaunchMissile(String myMunitionsId, String missileId,
			String destination, int damage) {
		missilePanel = new pnMissile(myMunitionsId,missileId,destination,damage);
		test.add(missilePanel);
		
		repaint();
		validate();
		
	}
	
	
	
	
}
