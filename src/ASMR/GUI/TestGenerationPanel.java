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
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import ASMR.Data.CreateTestFiles;

public class TestGenerationPanel extends AbstractPanel{

	private static final long serialVersionUID = -1308533711316270123L;

	private String directory;
	private ArrayList<String> seq1;
	private ArrayList<String> seq2;
	private Boolean answer;
	
	Font labelFont = new Font("Aerial", Font.PLAIN, 15);
	Font buttonFont = new Font("Aerial", Font.PLAIN, 20);
	
	public TestGenerationPanel() {
		this.initialize();
		CreateTestFiles.proxyClear();
		this.buildPanel();
	}
	
	public void initialize() {
		this.directory = System.getProperty("user.home");
		this.seq1 = new ArrayList<String>(5);
		this.seq2 = new ArrayList<String>(5);
		this.answer = Boolean.TRUE;
	}
	
	private JPanel buildDirectorySelector() {
		JPanel dirSelectorPanel = new JPanel();
		
		dirSelectorPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.BOTH;
		
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("WAV FILE", "wav");
		chooser.setFileFilter(filter);
		
		JTextArea text = new JTextArea(this.directory);
		text.setFont(this.labelFont);
		text.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {updateText();}
			@Override
			public void keyPressed(KeyEvent e) {updateText();}
			@Override
			public void keyReleased(KeyEvent e) {updateText();}
			
			public void updateText() {
				directory = text.getText().trim();
				text.setText(directory);
			}
		});
		
		//button for browsing files
		JButton browse = new JButton("Browse");
		browse.setFont(this.buttonFont);
		browse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int retVal = chooser.showOpenDialog(TestGenerationPanel.this);
				if(retVal == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					directory = file.getPath();
					text.setText(directory);
				}
			}
		});
		
		gbc.gridy=0;
		gbc.gridx=0;
		dirSelectorPanel.add(text, gbc);
		
		gbc.gridy=0;
		gbc.gridx=1;
		dirSelectorPanel.add(browse, gbc);
		
		return dirSelectorPanel;
	}
	
	@Override
	public void buildPanel() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.BOTH;
		
		//directory selector
		JLabel dirLabel = new JLabel("Directory:");
		dirLabel.setFont(labelFont);
		
		gbc.gridy=0;
		gbc.gridx=0;
		this.add(dirLabel, gbc);
		
		gbc.gridy=1;
		gbc.gridx=0;
		this.add(this.buildDirectorySelector(), gbc);
		
	}

}
