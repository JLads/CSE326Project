package ASMR.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * a class for implementing the panel for selecting test config method
 * @author nicholas
 *
 */
public class SelectConfigPanel extends AbstractPanel{

	private static final long serialVersionUID = 3023418730573609694L;
	
	public SelectConfigPanel() {
		buildPanel();
	}

	/**
	 * sets the contents of the panel
	 */
	@Override
	public void buildPanel() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.BOTH;
		
		//button for loading a sequence from a file
		JButton button1 = new JButton("Load Sequence");
		button1.setFont(new Font("Aerial", Font.PLAIN, 40));
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new WIPWindow();
			}
		});
		gbc.gridx = 2;
		gbc.gridy = 0;
		this.add(button1, gbc);
		
		//button for configuring auto generation
		JButton button2 = new JButton("Configured Generation");
		button2.setFont(new Font("Aerial", Font.PLAIN, 40));
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new WIPWindow();
			}			
		});
		gbc.gridx = 2;
		gbc.gridy = 1;
		this.add(button2, gbc);
		
		//button for random generation
		JButton button3 = new JButton("Random Generation");
		button3.setFont(new Font("Aerial", Font.PLAIN, 40));
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new WIPWindow();
			}
		});
		gbc.gridx = 2;
		gbc.gridy = 2;
		this.add(button3, gbc);
		
		//button for returning to main panel
		JButton button4 = new JButton("Return");
		button4.setFont(new Font("Aerial", Font.PLAIN, 40));
		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractPanel.getFrame().changePanel(new MainPanel());
			}
		});
		gbc.gridx = 2;
		gbc.gridy = 3;
		this.add(button4, gbc);
	}

}
