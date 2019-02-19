package TestGUI;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import GUI.MainFrame;
import GUI.MainPanel;

/**
 * A class for testing the primary GUI classes
 * @author nicholas
 *
 */
public class TestMainFrame {
		
	private static final int widthShrink = 400;
	private static final int heightShrink = 500;
	
	public static void main(String args[]) {
		new TestMainFrame();
	}
	
	private TestMainFrame() {
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		JFrame mf = new MainFrame("Test");
		
		MainPanel mp = new MainPanel();
		
		try {
			SwingUtilities.invokeAndWait(new Runnable() {

				@Override
				public void run() {
					mf.add(mp);
					mf.pack();
					
					GraphicsDevice gd = graphicsEnvironment.getDefaultScreenDevice();
					Rectangle loc = gd.getDefaultConfiguration().getBounds();
					mf.setSize(new Dimension(loc.width-widthShrink, loc.height-heightShrink));
					mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					mf.setIconImage(null);
					mf.setVisible(true);
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