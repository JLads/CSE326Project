package ASMR.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * implements the main window of ASMR
 * @author nicholas
 *
 */
public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1781446663380266615L;
		
	public MainFrame(String title) {
		super(title);
	}
	
	public MainFrame(String title, JPanel newPanel) {
		super(title);
		changePanel(newPanel);
	}
	
	/**
	 * set the panel of main frame
	 * @param panel the new panel
	 */
	public void changePanel(JPanel newPanel) {
		this.getContentPane().removeAll();
		this.getContentPane().add(newPanel);
		this.validate();
		this.repaint();
	}
}
