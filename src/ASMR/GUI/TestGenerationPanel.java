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

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

import ASMR.Data.CreateTestFiles;

public class TestGenerationPanel extends AbstractPanel{

	private static final long serialVersionUID = -1308533711316270123L;

	private String directory;
	private ArrayList<String> seq1;
	private ArrayList<String> seq2;
	private Boolean answer;
	
	public TestGenerationPanel() {
		this.initialize();
		CreateTestFiles.proxyClear();
		this.buildPanel();
	}
	
	public void initialize() {
		this.directory = null;
		this.seq1 = new ArrayList<String>();
		this.seq2 = new ArrayList<String>();
		this.answer = Boolean.TRUE;
	}
	
	@Override
	public void buildPanel() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		
		Font buttonFont = new Font("Aerial", Font.PLAIN, 40);
		
		//directory selector
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		JTextArea dirText = new JTextArea(this.directory);
		dirText.setFont(new Font("Aerial", Font.PLAIN, 15));
		dirText.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {updateText();}
			@Override
			public void keyPressed(KeyEvent e) {updateText();}
			@Override
			public void keyReleased(KeyEvent e) {updateText();}
			
			public void updateText() {
				directory = dirText.getText().trim();
				dirText.setText(directory);
			}
		});
		
		JButton dirBrowse = new JButton("Browse");
		dirBrowse.setFont(new Font("Aerial", Font.PLAIN, 20));
		dirBrowse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int retVal = chooser.showOpenDialog(TestGenerationPanel.this);
				if(retVal == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					directory = file.getPath();
					dirText.setText(directory);
				}
			}
		});
		
		gbc.gridy=0;
		gbc.gridx=1;
		gbc.weightx=3;
		this.add(dirText, gbc);
		gbc.weightx=1;
		
		gbc.gridy=0;
		gbc.gridx=4;
		this.add(dirBrowse, gbc);
		
		//seq1 selectors
		
		//seq2 selectors
		
		//correct answer selector
		
		//add to list button
		
		//test number tracker
		
		//save test
		
		//return
		JButton returnButton = new JButton("Return");
		returnButton.setFont(buttonFont);
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractPanel.getFrame().changePanel(new MainPanel());
			}
		});
		gbc.gridx=4;
		gbc.gridy=9;
		this.add(returnButton, gbc);
	}

}
