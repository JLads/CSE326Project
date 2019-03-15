package ASMR.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * a class for handling the various panels used to get and use a filepath
 * @author nicholas
 *
 */
public abstract class AbstractFileIOPanel extends AbstractPanel{

	private static final long serialVersionUID = 7693661634501607860L;
	
	protected String panelLabel = ""; // the label for a file io panel
	
	private String filePath = ""; // path to file chosen by user
	
	/**
	 * determines how a panel will handle a filepath
	 * @param fp a filepath to a file
	 */
	public abstract void processFilepath(String fp);
	
	/**
	 * builds the contents of a panel
	 */
	@Override
	public void buildPanel() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.BOTH;
		
		//label
		JLabel label = new JLabel(this.panelLabel);
		label.setFont(new Font("Aerial", Font.PLAIN, 30));
		gbc.gridy = 0;
		gbc.gridx = 0;
		this.add(label, gbc);
		
		//file chooser
		JFileChooser chooser = new JFileChooser();
		
		//text area for file path
		JTextArea text = new JTextArea(this.filePath);
		text.setFont(new Font("Aerial", Font.PLAIN, 15));
		text.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {updateText();}
			@Override
			public void keyPressed(KeyEvent e) {updateText();}
			@Override
			public void keyReleased(KeyEvent e) {updateText();}
			
			public void updateText() {
				filePath = text.getText();
			}
		});
		
		//button for browsing files
		JButton browse = new JButton("Browse");
		browse.setFont(new Font("Aerial", Font.PLAIN, 20));
		browse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int retVal = chooser.showOpenDialog(AbstractFileIOPanel.this);
				if(retVal == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					filePath = file.getPath();
					text.setText(filePath);
				}
			}
		});
		
		gbc.gridy = 1;
		gbc.gridx = 0;
		this.add(text, gbc);
		gbc.gridy = 1;
		gbc.gridx = 1;
		this.add(browse, gbc);
		
		//continue button
		JButton button = new JButton("Continue");
		button.setFont(new Font("Aerial", Font.PLAIN, 20));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				processFilepath(filePath);
			}
		});
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(button, gbc);
	}

}
