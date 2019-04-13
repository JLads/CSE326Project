package ASMR.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

import ASMR.Data.ResultLogger;

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
		JTextArea text = new JTextArea();
		text.setEditable(false);
		text.setBackground(this.getBackground());
		text.setFont(new Font("Aerial", Font.PLAIN, 20));
		text.setText("Test Complete!\n"
				+ "Please inform the test administrator.\n"
				+ "Total points: " + ResultLogger.proxyGetPoints());
		gbc.gridy=0;
		gbc.gridx=0;
		this.add(text, gbc);
		
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
		gbc.gridy=1;
		this.add(button, gbc);
	}
}
