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
 * class for displaying error messages to the user
 * @author nicholas
 *
 */
public class ErrorWindow {

	public ErrorWindow(String err) {
		JFrame frame = new JFrame("Error");
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);		
		
		//Error message
		JLabel label = new JLabel();
		label.setText(err);
		label.setFont(new Font("Aerial", Font.PLAIN, 20));
		gbc.gridy = 0;
		panel.add(label, gbc);
		
		//confirmation button
		JButton button = new JButton("Return");
		button.setFont(new Font("Aerial", Font.PLAIN, 20));
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
