package ASMR.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * implements the main window of ASMR
 * @author nicholas
 *
 */
public class MainFrame extends JFrame{
	
	public MainFrame(String title) {
		super(title);
	}
	
	/**
	 * change the panel of main frame
	 * @param panel the new panel
	 */
	public void changePanel(JPanel panel) {
		this.getContentPane().removeAll();
		this.add(panel);
		this.repaint();
	}
}
