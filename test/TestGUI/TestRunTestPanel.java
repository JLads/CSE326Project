package TestGUI;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import ASMR.GUI.AbstractPanel;
import ASMR.GUI.MainFrame;
import ASMR.GUI.RunTestPanel;

/**
 * a class that tests the primary testing panel RunTestPanel
 * @author nicholas
 *
 */
public class TestRunTestPanel {

	private static int widthShrink = 1000;
	private static int heightShrink = 500;
	
	public static void main(String args[]) {
		new TestRunTestPanel();
	}
	
	private TestRunTestPanel() {
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		try {
			SwingUtilities.invokeAndWait(new Runnable() {

				@Override
				public void run() {
					MainFrame frame = new MainFrame("Test");
					AbstractPanel.setFrame(frame);
					frame.changePanel(new RunTestPanel());
					
					GraphicsDevice gd = graphicsEnvironment.getDefaultScreenDevice();
					Rectangle gdb = gd.getDefaultConfiguration().getBounds();
					frame.setSize(new Dimension(gdb.width-widthShrink, gdb.height-heightShrink));
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setIconImage(null);
					frame.setVisible(true);
				}
				
			});
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
