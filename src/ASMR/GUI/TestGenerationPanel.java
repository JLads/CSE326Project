package ASMR.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

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
	

	FileNameExtensionFilter wavFilter = new FileNameExtensionFilter("Wav FILE", "wav");
	
	ArrayList<JFileChooser> fileChoosers = new ArrayList<JFileChooser>();
	
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
	
	/**
	 * builds a sub panel for selecting directory paths
	 * @return a jpanel for selecting a directory
	 */
	private JPanel buildDirectorySelector() {
		JPanel dirSelectorPanel = new JPanel();
		
		dirSelectorPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.BOTH;
		
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		JTextArea text = new JTextArea(this.directory);
		text.setFont(this.labelFont);
		text.setEditable(false);
		
		JButton browse = new JButton("Browse");
		browse.setFont(this.buttonFont);
		browse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int retVal = chooser.showOpenDialog(TestGenerationPanel.this);
				if(retVal == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					directory = file.getPath();
					for(JFileChooser jfc : fileChoosers) {
						jfc.setCurrentDirectory(new File(directory));
					}
					text.setText(directory);
				}
			}
		});
		
		gbc.gridy=0;
		gbc.gridx=0;
		gbc.ipadx=100;
		dirSelectorPanel.add(text, gbc);
		
		gbc.gridy=0;
		gbc.gridx=1;
		gbc.ipadx=0;
		dirSelectorPanel.add(browse, gbc);
		
		return dirSelectorPanel;
	}
	
	/**
	 * builds a sub panel for selecting files in a directory
	 * @param seq the array list for a sequence
	 * @return a jpannel for selecting sequences
	 */
	private JPanel buildSequenceSelector(ArrayList<String> seq) {
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.BOTH;
		
		JLabel file1Label = new JLabel("File 1:");
		file1Label.setFont(this.labelFont);
		gbc.gridy=0;
		gbc.gridx=0;
		panel.add(file1Label, gbc);
		
		JFileChooser f1chooser = new JFileChooser();
		f1chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		f1chooser.setFileFilter(wavFilter);
		fileChoosers.add(f1chooser);
		
		JTextArea f1text = new JTextArea();
		f1text.setFont(this.labelFont);
		f1text.setEditable(false);
		
		JButton f1browse = new JButton("Browse");
		f1browse.setFont(this.buttonFont);
		f1browse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int retVal = f1chooser.showOpenDialog(TestGenerationPanel.this);
				if(retVal == JFileChooser.APPROVE_OPTION) {
					File file = f1chooser.getSelectedFile();
					seq.add(0, file.getPath());
					f1text.setText(seq.get(0));
				}
			}
		});
		
		gbc.gridy=1;
		gbc.gridx=0;
		gbc.ipadx=250;
		panel.add(f1text, gbc);
		gbc.gridy=1;
		gbc.gridx=1;
		gbc.ipadx=0;
		panel.add(f1browse, gbc);
		
		JLabel file2Label = new JLabel("File 2:");
		file2Label.setFont(this.labelFont);
		gbc.gridy=2;
		gbc.gridx=0;
		panel.add(file2Label, gbc);
		
		
		
		JLabel file3Label = new JLabel("File 3:");
		file3Label.setFont(this.labelFont);
		gbc.gridy=4;
		gbc.gridx=0;
		panel.add(file3Label, gbc);
		
		
		
		JLabel file4Label = new JLabel("File 4:");
		file4Label.setFont(this.labelFont);
		gbc.gridy=6;
		gbc.gridx=0;
		panel.add(file4Label, gbc);
		
		
		
		JLabel file5Label = new JLabel("File 5:");
		file5Label.setFont(this.labelFont);
		gbc.gridy=8;
		gbc.gridx=0;
		panel.add(file5Label, gbc);
		
		
		
		return panel;	
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
		
		//Sequence 1 selector
		JLabel seq1Label = new JLabel("Sequence 1");
		seq1Label.setFont(labelFont);
		gbc.gridy=2;
		gbc.gridx=0;
		this.add(seq1Label, gbc);
		
		gbc.gridy=3;
		gbc.gridx=0;
		this.add(this.buildSequenceSelector(this.seq1), gbc);
		
		//sequence 2 selector
		JLabel seq2Label = new JLabel("Sequence 2");
		seq2Label.setFont(labelFont);
		gbc.gridy=2;
		gbc.gridx=1;
		this.add(seq2Label, gbc);
		
		gbc.gridy=3;
		gbc.gridx=1;
		this.add(this.buildSequenceSelector(this.seq2), gbc);
		
	}

}
