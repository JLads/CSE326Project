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
		JLabel label1 = new JLabel("Directions for the test:");
		label1.setFont(new Font("Aerial", Font.PLAIN, 20));
		gbc.gridx=0;
		gbc.gridy=0;
		this.add(label1, gbc);
		
		JLabel label2 = new JLabel("Press the 'Play Audio' button to play two sequences of audio clips.");
		label2.setFont(new Font("Aerial", Font.PLAIN, 20));
		gbc.gridx=0;
		gbc.gridy=1;
		this.add(label2, gbc);
		
		JLabel label3 = new JLabel("Press the 'Yes' or 'No' button if you believe the sequences are similar.");
		label3.setFont(new Font("Aerial", Font.PLAIN, 20));
		gbc.gridx=0;
		gbc.gridy=2;
		this.add(label3, gbc);
		
		JLabel label4 = new JLabel("Press the button below to start the test.");
		label4.setFont(new Font("Aerial", Font.PLAIN, 20));
		gbc.gridx=0;
		gbc.gridy=3;
		this.add(label4, gbc);
		
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
		gbc.gridy=4;
		this.add(button, gbc);
	}

}
