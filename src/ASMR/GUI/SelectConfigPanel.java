package ASMR.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;

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
		
		//title
		JLabel label = new JLabel("TEST");
		label.setFont(new Font("Aerial", Font.PLAIN, 40));
		gbc.gridx = 2;
		gbc.gridy = 0;
		this.add(label, gbc);
		
	}

}
