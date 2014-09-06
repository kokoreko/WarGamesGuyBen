package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.Font;

public class frmDestroyLauncher extends JFrame {
	public frmDestroyLauncher() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Destroy Lancher");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("Choose destnation:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_1);
		
		JList list = new JList();
		panel_1.add(list);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.EAST);
		
		JLabel lblNewLabel_2 = new JLabel("Choose launcher");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_2);
		
		JList list_1 = new JList();
		panel_2.add(list_1);
	}
	
}
