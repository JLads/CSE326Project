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
 * This is a class for displaying the results of the data analysis
 * currently only states that the results were saved to the directory of the results file
 * @author nicholas
 *
 */
public class DataAnalysisPanel extends AbstractPanel{
	
	private static final long serialVersionUID = 7833848100528782264L;

	public DataAnalysisPanel() {
		this.buildPanel();
	}
	
	@Override
	public void buildPanel() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,10,10,10);
		gbc.fill = GridBagConstraints.BOTH;
		
		//TODO actually display the results of data analysis
		
		JTextArea text = new JTextArea();
		text.setBackground(this.getBackground());
		text.setFont(new Font("Aerial", Font.PLAIN, 20));
		text.setEditable(false);
		text.setText("Results of data analysis will be placed in the same directory as the given results file.");
		gbc.gridy=0;
		this.add(text, gbc);
		
		JButton returnButton = new JButton("Return");
		returnButton.setFont(new Font("Aerial", Font.PLAIN, 20));
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					AbstractPanel.getFrame().changePanel(new MainPanel());
			}
		});
		gbc.gridy=1;
		this.add(returnButton, gbc);
	}

}
