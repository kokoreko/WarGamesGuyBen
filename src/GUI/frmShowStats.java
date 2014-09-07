package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;

public class frmShowStats extends JFrame {
	private JPanel mainPanel;
	private DefaultTableModel tableModel;
	private JTable tblStats;
	private JScrollPane jsmStats;
	public frmShowStats() {
		
		setTitle("Statistics");
		setResizable(false);
		
		mainPanel = new JPanel();
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new String[] { "Num of launch missiles"
				,"Num of intercept missiles"
				,"Num of hit target missiles"
				,"Num of launchers destroyed"
				,"Total damage"});
		tblStats = new JTable(tableModel);
		jsmStats = new JScrollPane(tblStats);
		jsmStats.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		mainPanel.add(jsmStats);
		getContentPane().add(mainPanel, BorderLayout.CENTER);
	}

}
