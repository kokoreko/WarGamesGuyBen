package TzukEitan.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import GUI.frmAddLauncherDestractor;
import GUI.frmDestroyLauncher;
import GUI.frmInterceptMissile;
import GUI.frmLaunchMissile;
import GUI.frmShowStats;
import TzukEitan.listeners.WarEventUIListener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
/**
 * 
 * @author Omri Glam
 *
 */
public class SwingView extends JFrame{
	private JPanel upPanel,pnLog,buttonsPanel,pnMap;
	private JScrollPane spMap;
	private JLabel mapLabel,lblLogTitle, lblLauncher;
	private JButton btnAddMissileIntercepter, btnLaunchMissile,btnAddLauncherIntercepter
					,btnAddLauncher,btnInterceptLauncher,btnInterceptMissile,btnShowStatistics,btnEndWar;
	private List<WarEventUIListener> allListeners;
	private List<JFrame> allFrames;
	
	/**
	 * Constructor of to the war Main Frame
	 */
	public SwingView(){
		allFrames = new LinkedList<JFrame>();
		setSize(getMaximumSize());
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		setLayoutAndStyle();
		createButtons();
		addButtonsListener();
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		allListeners = new LinkedList<WarEventUIListener>();
	}
	 
	private void setLayoutAndStyle() {
		pnMap= new JPanel();
		upPanel = new JPanel();
		getContentPane().add(upPanel, BorderLayout.CENTER);
		upPanel.setLayout(new BorderLayout(0, 0));
		
		pnLog = new JPanel();
		pnLog.setBackground(Color.LIGHT_GRAY);
		upPanel.add(pnLog, BorderLayout.EAST);
		pnLog.setLayout(new BorderLayout(20, 20));
		
		lblLogTitle = new JLabel("War log updates");
		pnLog.add(lblLogTitle, BorderLayout.NORTH);
		
		lblLauncher = new JLabel();
		lblLauncher.setIcon(new ImageIcon(getClass().getResource("/images/launcher.png")));
		
		lblLauncher.setLocation(500, 500);
		pnMap.add(lblLauncher);
		
		
		mapLabel = new JLabel(new ImageIcon(getClass().getResource("/images/Israel_relief_location_mapSmall.jpg")));           
		pnMap.add(mapLabel);
		spMap = new JScrollPane(pnMap);
		upPanel.add(spMap,BorderLayout.CENTER);
		buttonsPanel = new JPanel();
		buttonsPanel.setBackground(Color.LIGHT_GRAY);
		
		getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
		buttonsPanel.setLayout(new GridLayout(2, 4, 2, 2));
	}

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
				// TODO Create a new IronDoom (No Frame needed)
			}
		});
		btnAddLauncher.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Add a new Launcher (No Frame needed)
			}
		});
		
		btnAddLauncherIntercepter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frmAddLauncherDestractor addIntercepter = new frmAddLauncherDestractor();
			}
		});
		btnInterceptLauncher.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmDestroyLauncher intercpterDestroy = new frmDestroyLauncher();
			}
		});
		btnShowStatistics.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmShowStats stats = new frmShowStats();
			}
		});
		btnLaunchMissile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmLaunchMissile launchMissile = new frmLaunchMissile();
			}
		});
		
		btnInterceptMissile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmInterceptMissile interceptMissile = new frmInterceptMissile();
			}
		});
		
		
	}
	public void registerListeners(WarEventUIListener listener) {
		allListeners.add(listener);
	}
	
	private void endWar() {
		frmShowStats stats = new frmShowStats();
		
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
