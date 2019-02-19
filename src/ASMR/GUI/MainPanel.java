package ASMR.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A class that implements the top level panel for the ASMR software
 * @author nicholas
 *
 */
public class MainPanel extends JPanel {
	public MainPanel() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		
		JLabel label = new JLabel("ASMR");
		label.setFont(new Font("Aerial", Font.PLAIN, 40));
		gbc.gridx = 2;
		gbc.gridy = 0;
		this.add(label, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		
		JButton button1 = new JButton("Run Test");
		button1.setFont(new Font("Aerial", Font.PLAIN, 40));
		gbc.gridx = 2;
		gbc.gridy = 1;
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new WIPWindow();
			}
			
		});
		this.add(button1, gbc);
		
		JButton button2 = new JButton("Create Sequence");
		button2.setFont(new Font("Aerial", Font.PLAIN, 40));
		gbc.gridx = 2;
		gbc.gridy = 2;
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new WIPWindow();
			}
			
		});
		this.add(button2, gbc);
		
		JButton button3 = new JButton("Analyze Results");
		button3.setFont(new Font("Aerial", Font.PLAIN, 40));
		gbc.gridx = 2;
		gbc.gridy = 3;
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new WIPWindow();
			}
			
		});
		this.add(button3, gbc);
	}
}
