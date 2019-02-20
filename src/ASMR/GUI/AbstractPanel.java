package ASMR.GUI;

import javax.swing.JPanel;

/**
 * an abstract class for gui panels
 * @author nicholas
 *
 */
public abstract class AbstractPanel extends JPanel{

	private static final long serialVersionUID = -7004980325115843710L;
	
	//an instance of the main frame for changing panels
	private static MainFrame frame;

	/**
	 * set the instance of the main frame
	 * @param newFrame the frame to set as main frame
	 */
	public static void setFrame(MainFrame newFrame) {
		frame = newFrame;
	}
	
	/**
	 * gets the instance of the main frame
	 * @return the main frame
	 */
	public static MainFrame getFrame() {
		return frame;
	}
	
	/**
	 * set up the contents of the panel
	 */
	public abstract void buildPanel();
}
