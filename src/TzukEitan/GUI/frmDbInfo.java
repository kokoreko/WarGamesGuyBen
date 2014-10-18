package TzukEitan.GUI;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JFrame;

import TzukEitan.war.WarDb;

public class frmDbInfo extends JFrame {

	
	public frmDbInfo(LocalDateTime fromDate, LocalDateTime toDate) {
		System.out.println(WarDb.getHistoryLog(fromDate, toDate));
		setTitle("War Info By Date");
		setSize(420,420);
		setVisible(true);
	}

}
