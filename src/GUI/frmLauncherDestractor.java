package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class frmLauncherDestractor extends JFrame {
	public frmLauncherDestractor() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Choose the type of launcher destractor:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		ButtonGroup radioBtn = new ButtonGroup();
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 15));
		
		JRadioButton rbPlane = new JRadioButton("Plane");
		rbPlane.setEnabled(true);
		rbPlane.setFont(new Font("Arial", Font.PLAIN, 16));
		radioBtn.add(rbPlane);
		panel_1.add(rbPlane);
		
		JRadioButton rbShip = new JRadioButton("Ship");
		rbShip.setFont(new Font("Arial", Font.PLAIN, 16));
		radioBtn.add(rbShip);
		panel_1.add(rbShip);
		
		JButton btnAddLauncherDestractor = new JButton("Add");
		btnAddLauncherDestractor.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_2.add(btnAddLauncherDestractor);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}

}
