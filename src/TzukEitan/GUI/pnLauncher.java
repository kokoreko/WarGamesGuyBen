package TzukEitan.GUI;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import sun.net.www.content.image.jpeg;
import net.miginfocom.swing.MigLayout;
import TzukEitan.utils.Utils;

public class pnLauncher extends JPanel {

	private JLabel lblLauncher;
	private JScrollPane jspLauncherInfo;
	private JTextArea jtaLauncherInfo;
	private String[] stat= {"Hidden","Visabale"};
	public pnLauncher(String LauncherId,boolean isHidden) {
		int i=1;
		initLabelAndIcon(LauncherId);
		setLayout(new MigLayout("", "[124px]", "[75px][75px]"));
		add(lblLauncher, "cell 0 0,grow");
		if(isHidden) i = 0;
		jtaLauncherInfo = new JTextArea("Lancher is: " + stat[i]);
		jtaLauncherInfo.setFont(Utils.PANEL_FONT);
		jspLauncherInfo = new JScrollPane(jtaLauncherInfo);
		add(jspLauncherInfo, "cell 0 1,grow");

		setPreferredSize(new Dimension(100, 146));
		setVisible(true);

	}

	private void initLabelAndIcon(String LauncherId) {

		lblLauncher = new JLabel();
		lblLauncher.setText(LauncherId);
		lblLauncher.setIcon(Utils.getImageIcon(Utils.LAUNCHER_IMAGE));
		lblLauncher.setHorizontalAlignment(SwingConstants.CENTER);
		lblLauncher.setBorder(BorderFactory.createEtchedBorder());
		lblLauncher.setVerticalTextPosition(SwingConstants.TOP);
		lblLauncher.setHorizontalTextPosition(JLabel.CENTER);
		lblLauncher.setPreferredSize(new Dimension(70, 80));
	}

	public void setHiden(boolean isHidden) {
		int i=1;
		if(isHidden) i = 0 ;
		jtaLauncherInfo = new JTextArea("Lancher is: " + stat[i]);
		repaint();
		validate();
	}
}
