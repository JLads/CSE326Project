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

import ASMR.GUI.MainFrame;
import ASMR.GUI.MainPanel;

/**
 * A class that implements the main window of the ASMR software
 * @author nicholas
 *
 */
public class ASMR implements UncaughtExceptionHandler, WindowListener {
	
	//the amount to subtract from the default window dimensions
	private static final int widthShrink = 1000;
	private static final int heightShrink = 500;
	
	public static void main(String args[]) {new ASMR();}
	
	private ASMR() {
		Thread.setDefaultUncaughtExceptionHandler(this);

		//establish graphics environment and establish window
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		try {
			SwingUtilities.invokeAndWait(new Runnable() {

				@Override
				public void run() {
					//initialize window
					MainFrame frame = new MainFrame("ASMR");
					frame.add(new MainPanel(frame));
					frame.pack();
					
					//configure window
					GraphicsDevice gd = graphicsEnvironment.getDefaultScreenDevice();
					Rectangle gdb = gd.getDefaultConfiguration().getBounds();
					frame.setSize(new Dimension(gdb.width-widthShrink, gdb.height-heightShrink));
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.addWindowListener(ASMR.this);
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
