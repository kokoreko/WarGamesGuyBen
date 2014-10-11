package TzukEitan.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.border.CompoundBorder;

public class frmShowStats extends JFrame {
	private JPanel mainPanel;
	private DefaultTableModel tableModel;
	private JTable tblStats;
	private JScrollPane jsmStats;
	public frmShowStats() {
		setVisible(true);
		
		setTitle("Statistics");
		
		mainPanel = new JPanel();
		mainPanel.setSize(800, 160);
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new String[] { "Num of launch missiles"
				,"Num of intercept missiles"
				,"Num of hit target missiles"
				,"Num of launchers destroyed"
				,"Total damage"});
		
		tblStats = new JTable(tableModel);
		jsmStats = new JScrollPane(tblStats);
		jsmStats.setEnabled(false);
		jsmStats.setPreferredSize(mainPanel.getSize());
		mainPanel.add(jsmStats);
		setResizable(false);
		setSize(800,160);
		getContentPane().add(mainPanel, BorderLayout.CENTER);
	}
	public void addStats(long[] statisticsToArray) {
		tableModel.addRow(new Object[] {statisticsToArray[0], statisticsToArray[1],statisticsToArray[2],statisticsToArray[3],statisticsToArray[4]});
		
	}

}
