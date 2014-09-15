package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.JLabel;

public class frmLaunchMissile extends JFrame {
	private final Font font = new Font("Arial", Font.PLAIN, 16);
	
	private JPanel midPanel,upPanel,downPanel;
	private JButton btnLaunchMissile;
	private JPanel rightPanel, leftPanel;
	private JComboBox cmbChooseLauncher,cmbChooseCity;
	private JLabel lblChooseLauncher,lblChooseCity;
	
	
	public frmLaunchMissile() {
		setSize(new Dimension(420, 256));
		setTitle("Launce a missile");
		
		upPanel = new JPanel();
		getContentPane().add(upPanel, BorderLayout.NORTH);
		
		midPanel = new JPanel();
		getContentPane().add(midPanel, BorderLayout.CENTER);
		midPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
		
		leftPanel = new JPanel();
		midPanel.add(leftPanel);
		leftPanel.setLayout(new BorderLayout(0, 0));
		
		cmbChooseLauncher = new JComboBox();
		leftPanel.add(cmbChooseLauncher);
		
		lblChooseLauncher = new JLabel("Choose a Launcher");
		lblChooseLauncher.setFont(font);
		leftPanel.add(lblChooseLauncher, BorderLayout.NORTH);
		
		rightPanel = new JPanel();
		midPanel.add(rightPanel);
		rightPanel.setLayout(new BorderLayout(0, 0));
		
		cmbChooseCity = new JComboBox();
		rightPanel.add(cmbChooseCity);
		
		lblChooseCity= new JLabel("Choose a city to strike");
		lblChooseCity.setFont(font);
		rightPanel.add(lblChooseCity, BorderLayout.NORTH);
		
		downPanel = new JPanel();
		getContentPane().add(downPanel, BorderLayout.SOUTH);
		
		btnLaunchMissile = new JButton("Launch!");
		btnLaunchMissile.setFont(font);
		downPanel.add(btnLaunchMissile);
		
		setVisible(true);
		setAlwaysOnTop(true);
		setResizable(false);
	}
	
}
