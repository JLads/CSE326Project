package TestGUI;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import ASMR.GUI.MainFrame;
import ASMR.GUI.MainPanel;

/**
 * A class to test the main panel of the gui
 * @author nicholas
 *
 */
public class TestMainPanel {
	
	private static final int widthShrink = 1000;
	private static final int heightShrink = 500;
	
	public static void main(String args[]) {
		new TestMainPanel();
	}
	
	private TestMainPanel() {
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		MainFrame frame = new MainFrame("Test");
		
		MainPanel mp = new MainPanel();
		
		try {
			SwingUtilities.invokeAndWait(new Runnable() {

				@Override
				public void run() {
					frame.add(mp);
					frame.pack();
					
					GraphicsDevice gd = graphicsEnvironment.getDefaultScreenDevice();
					Rectangle gdb = gd.getDefaultConfiguration().getBounds();
					frame.setSize(new Dimension(gdb.width-widthShrink, gdb.height-heightShrink));
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setIconImage(null);
					frame.setVisible(true);
				}
				
			});
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
