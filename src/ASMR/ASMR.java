package ASMR;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import GUI.MainFrame;
import GUI.MainPanel;

/**
 * A class that implements the main ASMR window and starts the whole application
 * @author nicholas
 *
 */
public class ASMR implements UncaughtExceptionHandler, WindowListener {
	private static final int widthShrink = 20;
	private static final int heightShrink = 50;
	
	public static void main(String args[]) {
		new ASMR();
	}
	
	private ASMR() {
		Thread.setDefaultUncaughtExceptionHandler(this);

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
					mf.addWindowListener(ASMR.this);
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

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
