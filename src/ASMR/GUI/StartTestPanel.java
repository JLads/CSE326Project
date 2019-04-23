package ASMR.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 * a class the implements the pre-test panel that instructs the user on what to do
 * @author nicholas
 *
 */
public class StartTestPanel extends AbstractPanel{

	private static final long serialVersionUID = -8425211744286408102L;

	/**
	 * default constructor
	 */
	public StartTestPanel() {
		buildPanel();
	}
	
	/**
	 * builds the contents of the panel
	 */
	@Override
	public void buildPanel() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,10,10,10);
		gbc.fill = GridBagConstraints.BOTH;
		
		//set up message to test subject
		JTextArea text = new JTextArea();
		text.setEditable(false);
		text.setBackground(this.getBackground());
		text.setFont(new Font("Aerial", Font.PLAIN, 20));
		text.setText("Directions for the test:\n"
				+ "Press the 'Play Audio' button to play two sequences of audio clips,\n"
				+ "Press the 'Yes' or 'No' button if you believe the sequences are the same.\n"
				+ "points will be rewarded for correct answers.\n"
				+ "points will be deducted for incorrect answers.\n"
				+ "When you are ready, press the button below to start the test.");
		gbc.gridx=0;
		gbc.gridy=0;
		this.add(text, gbc);
		
		//button to start the test
		JButton button = new JButton("Start Test");
		button.setFont(new Font("Aerial", Font.PLAIN, 40));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractPanel.getFrame().changePanel(new RunTestPanel());
			}
		});
		gbc.gridx=0;
		gbc.gridy=1;
		this.add(button, gbc);
	}

}
