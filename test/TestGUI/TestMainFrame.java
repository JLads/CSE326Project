package TestGUI;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import GUI.MainFrame;

public class TestMainFrame {
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame mf = new MainFrame("Test");
				mf.setSize(400,500);
				mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mf.setVisible(true);
			}
			
		});
	}
}
