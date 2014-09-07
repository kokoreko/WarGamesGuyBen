package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.GridLayout;

public class frmDestroyLauncher extends JFrame {
	private final Font font = new Font("Arial", Font.PLAIN, 16);
	private JLabel title,leftLabel,rightLabel;
	private JButton btnDestroyLauncher;
	private JPanel upPanel,downPanel,rightPanel,leftPanel,destPanel,launcherPanel,midPanel;
	private JScrollPane scpDestnation,scpLauncher;
	
	public frmDestroyLauncher() {
		
		upPanel = new JPanel();
		getContentPane().add(upPanel, BorderLayout.NORTH);
		
		title = new JLabel("Destroy Lancher");
		title.setFont(font);
		upPanel.add(title);
		
		leftPanel = new JPanel();
		destPanel = new JPanel();
		scpDestnation = new JScrollPane(destPanel);
		leftPanel.setLayout(new BorderLayout(0, 0));
		leftLabel = new JLabel("Choose destnation: ");
		leftLabel.setFont(font);
		leftPanel.add(leftLabel, BorderLayout.NORTH);
		leftPanel.add(scpDestnation,BorderLayout.CENTER);
		
		rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout(0, 0));
		
		launcherPanel = new JPanel();
		scpLauncher = new JScrollPane(launcherPanel);
		rightPanel.setLayout(new BorderLayout(0, 0));
		rightLabel = new JLabel("Choose launcher: ");
		rightLabel.setFont(font);
		rightPanel.add(rightLabel, BorderLayout.NORTH);
		rightPanel.add(scpLauncher,BorderLayout.CENTER);
		
		midPanel = new JPanel();
		midPanel.setLayout(new GridLayout(0, 2, 0, 0));
		midPanel.add(leftPanel);
		midPanel.add(rightPanel);
		getContentPane().add(midPanel,BorderLayout.CENTER);
		
		downPanel = new JPanel();
		getContentPane().add(downPanel, BorderLayout.SOUTH);
		
		btnDestroyLauncher = new JButton("Destroy!");
		btnDestroyLauncher.setFont(font);
		downPanel.add(btnDestroyLauncher);
		
		setTitle("Destroy Launcher");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
