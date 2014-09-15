package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JComboBox;

public class frmInterceptMissile extends JFrame {
	private final Font font = new Font("Arial", Font.PLAIN, 16);
	
	private JPanel mainPanel,downPanel;
	private JButton btnInterceptMissile;
	private JPanel panel;
	private JLabel lblChooseAMissile;
	private JPanel panel_1;
	private JComboBox cmbChooseMissile;
	
	public frmInterceptMissile() {
		setTitle("Intercept a Missile");
		
		mainPanel = new JPanel();
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		mainPanel.add(panel, BorderLayout.NORTH);
		
		lblChooseAMissile = new JLabel("Choose A Missile to Intercept");
		lblChooseAMissile.setFont(font);
		panel.add(lblChooseAMissile);
		
		panel_1 = new JPanel();
		mainPanel.add(panel_1, BorderLayout.CENTER);
		
		cmbChooseMissile = new JComboBox();
		panel_1.add(cmbChooseMissile);
		
		downPanel = new JPanel();
		getContentPane().add(downPanel, BorderLayout.SOUTH);
		
		btnInterceptMissile = new JButton("Intercept!");
		btnInterceptMissile.setFont(font);
		downPanel.add(btnInterceptMissile);
		
		setVisible(true);
		setAlwaysOnTop(true);
		setSize(new Dimension(360, 160));
	}

}
