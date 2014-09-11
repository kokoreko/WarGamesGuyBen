package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.GridLayout;

import javax.swing.JComboBox;

public class frmDestroyLauncher extends JFrame {
	private final Font font = new Font("Arial", Font.PLAIN, 16);
	
	private JPanel midPanel,upPanel,downPanel;
	private JButton btnLaunchMissile;
	private JPanel rightPanel, leftPanel;
	private JComboBox<Object> cmbChooseLauncher,cmbChoosedestroyer;
	private JLabel lblChooseLauncher,lblChooseCity;
	
	
	public frmDestroyLauncher() {
		setSize(new Dimension(420, 256));
		setTitle("Destory Launcher");
		
		upPanel = new JPanel();
		getContentPane().add(upPanel, BorderLayout.NORTH);
		
		midPanel = new JPanel();
		getContentPane().add(midPanel, BorderLayout.CENTER);
		midPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		
		leftPanel = new JPanel();
		midPanel.add(leftPanel);
		leftPanel.setLayout(new BorderLayout(0, 0));
		
		cmbChooseLauncher = new JComboBox<Object>();
		leftPanel.add(cmbChooseLauncher);
		
		lblChooseLauncher = new JLabel("Choose a Destroyer");
		lblChooseLauncher.setFont(font);
		leftPanel.add(lblChooseLauncher, BorderLayout.NORTH);
		
		rightPanel = new JPanel();
		midPanel.add(rightPanel);
		rightPanel.setLayout(new BorderLayout(0, 0));
		
		cmbChoosedestroyer = new JComboBox<Object>();
		rightPanel.add(cmbChoosedestroyer);
		
		lblChooseCity= new JLabel("Choose Launcher to destroy");
		lblChooseCity.setFont(font);
		rightPanel.add(lblChooseCity, BorderLayout.NORTH);
		
		downPanel = new JPanel();
		getContentPane().add(downPanel, BorderLayout.SOUTH);
		
		btnLaunchMissile = new JButton("Destroy!");
		btnLaunchMissile.setFont(font);
		downPanel.add(btnLaunchMissile);
		
		setVisible(true);
		setAlwaysOnTop(true);
		setResizable(false);
	}
}
