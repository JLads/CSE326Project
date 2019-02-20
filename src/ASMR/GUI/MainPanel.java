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
 * A class that implements the main menu panel for the ASMR software
 * @author nicholas
 *
 */
public class MainPanel extends JPanel {

	private static final long serialVersionUID = 583870735382218103L;

	public MainPanel() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		
		//title
		JLabel label = new JLabel("ASMR");
		label.setFont(new Font("Aerial", Font.PLAIN, 40));
		gbc.gridx = 2;
		gbc.gridy = 0;
		this.add(label, gbc);
		
		//make components fill their grid
		gbc.fill = GridBagConstraints.BOTH;
		
		//button for running tests
		JButton button1 = new JButton("Run Test");
		button1.setFont(new Font("Aerial", Font.PLAIN, 40));
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO implement run test panel
				new WIPWindow();
			}
		});
		gbc.gridx = 2;
		gbc.gridy = 1;
		this.add(button1, gbc);
		
		//button for creating sequences
		JButton button2 = new JButton("Create Sequence");
		button2.setFont(new Font("Aerial", Font.PLAIN, 40));
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO implement sequence creation panel
				new WIPWindow();
			}
		});
		gbc.gridx = 2;
		gbc.gridy = 2;
		this.add(button2, gbc);
		
		//button for analyzing result data
		JButton button3 = new JButton("Analyze Results");
		button3.setFont(new Font("Aerial", Font.PLAIN, 40));
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO implement data analysis panel
				new WIPWindow();
			}
		});
		gbc.gridx = 2;
		gbc.gridy = 3;
		this.add(button3, gbc);
	}
}
