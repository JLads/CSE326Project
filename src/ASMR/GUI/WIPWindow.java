package ASMR.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * A class that generates a window that indicates a feature is work in progress
 * @author nicholas
 *
 */
public class WIPWindow {

	public WIPWindow() {
		JFrame frame = new JFrame("Work In Progress");
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);		
		
		//WIP message
		JLabel label = new JLabel();
		label.setText("This feature is currently unavailable...");
		label.setFont(new Font("Aerial", Font.PLAIN, 20));
		gbc.gridy = 0;
		panel.add(label, gbc);
		
		//confurmation button
		JButton button = new JButton("Return");
		button.setFont(new Font("Return", Font.PLAIN, 20));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {frame.dispose();}
		});
		gbc.gridy = 1;
		panel.add(button, gbc);
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				frame.add(panel);
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});
	}
}
