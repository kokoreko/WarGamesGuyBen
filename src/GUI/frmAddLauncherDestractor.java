package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import TzukEitan.listeners.WarEventUIListener;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmAddLauncherDestractor extends JFrame {
	private final Font font = new Font("Arial", Font.PLAIN, 16);
	private JPanel upPanel,midPanel,downPanel;
	private JLabel topLabel;
	private JRadioButton rbPlane,rbShip;
	private JButton btnAddLauncherDestractor;
	private ButtonGroup radioBtn;
	private String type=null;
	private Object lock;
	public frmAddLauncherDestractor(Object lock) {
		this.lock = lock;
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		upPanel = new JPanel();
		getContentPane().add(upPanel, BorderLayout.NORTH);
		
		topLabel = new JLabel("Choose the type of launcher destractor:");
		topLabel.setFont(font);
		upPanel.add(topLabel);
		
		midPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) midPanel.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(100);
		getContentPane().add(midPanel, BorderLayout.CENTER);
		
		downPanel = new JPanel();
		getContentPane().add(downPanel, BorderLayout.SOUTH);
		
		radioBtn = new ButtonGroup();
		downPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 15));
		
		rbPlane = new JRadioButton("Plane");
		rbPlane.setActionCommand("plane");
		rbPlane.setEnabled(true);
		rbPlane.setFont(font);
		radioBtn.add(rbPlane);
		midPanel.add(rbPlane);
		
		rbShip = new JRadioButton("Ship");
		rbShip.setActionCommand("ship");
		rbShip.setFont(font);
		radioBtn.add(rbShip);
		midPanel.add(rbShip);
		
		btnAddLauncherDestractor = new JButton("Add");
		btnAddLauncherDestractor.setFont(font);
		downPanel.add(btnAddLauncherDestractor);

		setSize(335,225);
		setVisible(true);
		setTitle("Add Launcher Destractor");
		setResizable(false);
		
		btnAddLauncherDestractor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				type = radioBtn.getSelection().getActionCommand();

				setEnabled(false);
				setVisible(false);
				this.notify();
			}
		});
	}

	public String getChoise() {
		return type;
	}

}
