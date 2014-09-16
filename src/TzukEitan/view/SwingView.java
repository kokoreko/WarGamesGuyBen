package TzukEitan.view;

import GUI.frmMain;

public class SwingView extends Thread {
	

	private frmMain main;
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void run() {
			main = new frmMain();
			
	}
    
}
