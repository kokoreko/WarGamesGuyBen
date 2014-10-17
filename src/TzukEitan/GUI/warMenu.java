package TzukEitan.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import TzukEitan.utils.Utils;
import TzukEitan.view.SwingView;



public class warMenu extends JMenuBar {
	
	private SwingView mainFrame;
	
	public warMenu(SwingView mainFrame){
		this.mainFrame = mainFrame;
		
		JMenu fileMenu = new JMenu("file");
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Utils.closeApplication(mainFrame);
			}
		});
		fileMenu.add(exitMenuItem);
		this.add(fileMenu);
		
	}
}
