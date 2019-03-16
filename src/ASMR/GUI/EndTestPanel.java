package ASMR.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * A class that implements the post-test panel
 * @author nicholas
 *
 */
public class EndTestPanel extends AbstractPanel {

	private static final long serialVersionUID = -5602972876983195916L;
	
	/**
	 * default constructor
	 */
	public EndTestPanel() {
		buildPanel();
	}
	
	/**
	 * creates the contents of the panel
	 */
	@Override
	public void buildPanel() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,10,10,10);
		gbc.fill = GridBagConstraints.BOTH;
		
		//message to user
		JLabel label1 = new JLabel("Test Complete!");
		label1.setFont(new Font("Aerial", Font.PLAIN, 20));
		gbc.gridx=0;
		gbc.gridy=0;
		this.add(label1, gbc);
		
		JLabel label2 = new JLabel("Please inform the individual running the test.");
		label2.setFont(new Font("Aerial", Font.PLAIN, 20));
		gbc.gridx=0;
		gbc.gridy=1;
		this.add(label2, gbc);
		
		//continue button
		JButton button = new JButton("Continue");
		button.setFont(new Font("Aerial", Font.PLAIN, 40));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractPanel.getFrame().changePanel(new SaveResultsFilePanel());
			}
		});
		gbc.gridx=0;
		gbc.gridy=2;
		this.add(button, gbc);
	}
}
