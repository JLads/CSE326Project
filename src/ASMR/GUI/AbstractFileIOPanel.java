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
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * an abstract class for handling the various panels used to get a filepath
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
	 * a method for checking that a file path meets requirements
	 * @param f file to check
	 * @return path of f or null if error with f
	 */
	private String checkFilePath(String fp) {
		//most of this is here due to the ability of a user to manually input a path rather than use the file browser
		if((this instanceof LoadTestFilePanel)||(this instanceof LoadResultsFilePanel)) {
			if(fp.length()==0) {
				new ErrorWindow("File path can't be empty");
				return null;
			}
			File f = new File(fp);
			if(!f.isFile()) {
				new ErrorWindow("Given path is not a file: "+fp);
				return null;
			}
			if(!f.exists()) {
				new ErrorWindow("File does not exist: "+fp);
				return null;
			}
			if(!fp.contains(".csv")) {
				new ErrorWindow("File must be a CSV: "+fp);
				return null;
			}
		}else {
			if(!fp.contains(".csv")) {
				fp=fp+".csv";
			}
		}
		return fp;
	}
	
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
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV FILE", "csv");
		chooser.setFileFilter(filter);
		
		//text area for file path
		JTextArea text = new JTextArea(this.filePath);
		text.setEditable(false);
		text.setFont(new Font("Aerial", Font.PLAIN, 15));
		text.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {updateText();}
			@Override
			public void keyPressed(KeyEvent e) {updateText();}
			@Override
			public void keyReleased(KeyEvent e) {updateText();}
			
			public void updateText() {
				filePath = text.getText().trim();
				text.setText(filePath);
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
				String fp = checkFilePath(filePath);
				if(fp!=null) {
					processFilepath(fp);
				}
			}
		});
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(button, gbc);
	}

}
