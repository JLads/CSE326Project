package ASMR.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import ASMR.Data.CreateTestFiles;

/**
 * a panel for building test files
 * @author nicholas
 */
public class TestGenerationPanel extends AbstractPanel{

	private static final long serialVersionUID = -1308533711316270123L;

	private String directory;		//path to directory
	private ArrayList<String> seq1;	//array list of file names for sequence 1
	private ArrayList<String> seq2; //array list of file names for sequence 2
	private Boolean answer;			//correct answer for a test
	
	//fonts for labels and buttons
	private Font labelFont = new Font("Aerial", Font.PLAIN, 20);
	private Font buttonFont = new Font("Aerial", Font.PLAIN, 25);

	//file filter for wav file choosers
	private FileNameExtensionFilter wavFilter = new FileNameExtensionFilter("WAV FILE", "wav");
	
	//array list of file choosers, for updating with new directory paths
	private ArrayList<JFileChooser> fileChoosers = new ArrayList<JFileChooser>();
	
	//array list of file choosers, for updating with new directory paths
	private ArrayList<JTextArea> fileTextAreas = new ArrayList<JTextArea>();
	
	/**
	 * default constructor
	 */
	public TestGenerationPanel() {
		this.directory = System.getProperty("user.home");
		this.seq1 = new ArrayList<String>();
		this.seq2 = new ArrayList<String>();
		for(int i = 0; i < 5; i++) {
			seq1.add(null);
			seq2.add(null);
		}
		this.answer = Boolean.TRUE;
		CreateTestFiles.proxyClear();
		this.buildPanel();
	}
	
	/**
	 * builds a sub panel for selecting directory paths
	 * @return a jpanel for selecting a directory
	 */
	private JPanel buildDirectorySelector() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.BOTH;
		
		//label for directory selector
		JLabel label = new JLabel("WAV file directory:");
		label.setFont(this.labelFont);
		
		//file chooser for directory
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		//text area for directory
		JTextArea text = new JTextArea(this.directory);
		text.setFont(this.labelFont);
		text.setEditable(false);
		
		//browse button for directory
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
						jfc.setSelectedFile(null);
					}
					for(JTextArea jta : fileTextAreas) {
						jta.setText(null);
					}
					for(int i = 0; i < 5; i++) {
						seq1.set(i, null);
						seq2.set(i, null);
					}
					text.setText(directory);
				}
			}
		});
		
		gbc.gridy=0;
		gbc.gridx=0;
		gbc.ipadx=1200;
		panel.add(label, gbc);
		gbc.ipadx=0;
		
		gbc.gridy=1;
		gbc.gridx=0;
		panel.add(text, gbc);
		
		gbc.gridy=1;
		gbc.gridx=2;
		panel.add(browse, gbc);
		
		return panel;
	}
	
	/**
	 * builds a sub panel for selecting wav files in a directory
	 * @param seq the array list for a sequence
	 * @return a jpanel for selecting sequences
	 */
	private JPanel buildSequenceSelector(ArrayList<String> seq) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.BOTH;
		
		//file 1 selector
		JLabel file1Label = new JLabel("File 1:");
		file1Label.setFont(this.labelFont);
		gbc.gridy=0;
		gbc.gridx=0;
		gbc.ipadx=500;
		panel.add(file1Label, gbc);
		gbc.ipadx=0;
		
		JFileChooser f1chooser = new JFileChooser();
		f1chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		f1chooser.setFileFilter(this.wavFilter);
		this.fileChoosers.add(f1chooser);
		
		JTextArea f1text = new JTextArea();
		f1text.setFont(this.labelFont);
		f1text.setEditable(false);
		this.fileTextAreas.add(f1text);
		
		JButton f1browse = new JButton("Browse");
		f1browse.setFont(this.buttonFont);
		f1browse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int retVal = f1chooser.showOpenDialog(TestGenerationPanel.this);
				if(retVal == JFileChooser.APPROVE_OPTION) {
					File file = f1chooser.getSelectedFile();
					seq.set(0, file.getName());
					f1text.setText(seq.get(0));
				}
			}
		});
		
		gbc.gridy=1;
		gbc.gridx=0;
		panel.add(f1text, gbc);
		gbc.gridy=1;
		gbc.gridx=1;
		panel.add(f1browse, gbc);
		
		//file 2 selector
		JLabel file2Label = new JLabel("File 2:");
		file2Label.setFont(this.labelFont);
		gbc.gridy=2;
		gbc.gridx=0;
		panel.add(file2Label, gbc);
		
		JFileChooser f2chooser = new JFileChooser();
		f2chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		f2chooser.setFileFilter(this.wavFilter);
		this.fileChoosers.add(f2chooser);
		
		JTextArea f2text = new JTextArea();
		f2text.setFont(this.labelFont);
		f2text.setEditable(false);
		this.fileTextAreas.add(f2text);
		
		JButton f2browse = new JButton("Browse");
		f2browse.setFont(this.buttonFont);
		f2browse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int retVal = f2chooser.showOpenDialog(TestGenerationPanel.this);
				if(retVal == JFileChooser.APPROVE_OPTION) {
					File file = f2chooser.getSelectedFile();
					seq.set(1, file.getName());
					f2text.setText(seq.get(1));
				}
			}
		});
		
		gbc.gridy=3;
		gbc.gridx=0;
		panel.add(f2text, gbc);
		gbc.gridy=3;
		gbc.gridx=1;
		panel.add(f2browse, gbc);
		
		//file 3 selector
		JLabel file3Label = new JLabel("File 3:");
		file3Label.setFont(this.labelFont);
		gbc.gridy=4;
		gbc.gridx=0;
		panel.add(file3Label, gbc);
		
		JFileChooser f3chooser = new JFileChooser();
		f3chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		f3chooser.setFileFilter(this.wavFilter);
		this.fileChoosers.add(f3chooser);
		
		JTextArea f3text = new JTextArea();
		f3text.setFont(this.labelFont);
		f3text.setEditable(false);
		this.fileTextAreas.add(f3text);
		
		JButton f3browse = new JButton("Browse");
		f3browse.setFont(this.buttonFont);
		f3browse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int retVal = f3chooser.showOpenDialog(TestGenerationPanel.this);
				if(retVal == JFileChooser.APPROVE_OPTION) {
					File file = f3chooser.getSelectedFile();
					seq.set(2, file.getName());
					f3text.setText(seq.get(2));
				}
			}
		});
		
		gbc.gridy=5;
		gbc.gridx=0;
		panel.add(f3text, gbc);
		gbc.gridy=5;
		gbc.gridx=1;
		panel.add(f3browse, gbc);
		
		//file 4 selector
		JLabel file4Label = new JLabel("File 4:");
		file4Label.setFont(this.labelFont);
		gbc.gridy=6;
		gbc.gridx=0;
		panel.add(file4Label, gbc);
		
		JFileChooser f4chooser = new JFileChooser();
		f4chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		f4chooser.setFileFilter(this.wavFilter);
		this.fileChoosers.add(f4chooser);
		
		JTextArea f4text = new JTextArea();
		f4text.setFont(this.labelFont);
		f4text.setEditable(false);
		this.fileTextAreas.add(f4text);
		
		JButton f4browse = new JButton("Browse");
		f4browse.setFont(this.buttonFont);
		f4browse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int retVal = f4chooser.showOpenDialog(TestGenerationPanel.this);
				if(retVal == JFileChooser.APPROVE_OPTION) {
					File file = f4chooser.getSelectedFile();
					seq.set(3, file.getName());
					f4text.setText(seq.get(3));
				}
			}
		});
		
		gbc.gridy=7;
		gbc.gridx=0;
		panel.add(f4text, gbc);
		gbc.gridy=7;
		gbc.gridx=1;
		panel.add(f4browse, gbc);
		
		//file 5 selector
		JLabel file5Label = new JLabel("File 5:");
		file5Label.setFont(this.labelFont);
		gbc.gridy=8;
		gbc.gridx=0;
		panel.add(file5Label, gbc);
		
		JFileChooser f5chooser = new JFileChooser();
		f5chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		f5chooser.setFileFilter(this.wavFilter);
		this.fileChoosers.add(f5chooser);
		
		JTextArea f5text = new JTextArea();
		f5text.setFont(this.labelFont);
		f5text.setEditable(false);
		this.fileTextAreas.add(f5text);
		
		JButton f5browse = new JButton("Browse");
		f5browse.setFont(this.buttonFont);
		f5browse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int retVal = f5chooser.showOpenDialog(TestGenerationPanel.this);
				if(retVal == JFileChooser.APPROVE_OPTION) {
					File file = f5chooser.getSelectedFile();
					seq.set(4, file.getName());
					f5text.setText(seq.get(4));
				}
			}
		});
		
		gbc.gridy=9;
		gbc.gridx=0;
		panel.add(f5text, gbc);
		gbc.gridy=9;
		gbc.gridx=1;
		panel.add(f5browse, gbc);
		
		return panel;	
	}
	
	/**
	 * builds a sub panel for sequence selection
	 * @return jpanel for sequence selection
	 */
	private JPanel sequenceSelectors() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.BOTH;
		
		//Sequence 1 selector
		JLabel seq1Label = new JLabel("Sequence 1");
		seq1Label.setFont(this.labelFont);
		gbc.gridy=0;
		gbc.gridx=0;
		panel.add(seq1Label, gbc);
				
		gbc.gridy=1;
		gbc.gridx=0;
		panel.add(this.buildSequenceSelector(this.seq1), gbc);
				
		//sequence 2 selector
		JLabel seq2Label = new JLabel("Sequence 2");
		seq2Label.setFont(this.labelFont);
		gbc.gridy=0;
		gbc.gridx=1;
		panel.add(seq2Label, gbc);
				
		gbc.gridy=1;
		gbc.gridx=1;
		panel.add(this.buildSequenceSelector(this.seq2), gbc);
		return panel;
	}
	
	/**
	 * builds a sub panel for selecting the correct answer of a test
	 * @return a jpanel for selecting correct answer
	 */
	private JPanel answerSelector() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.BOTH;
		
		//label for correct answer check box
		JLabel label = new JLabel("Correct Answer:");
		label.setFont(this.labelFont);
		gbc.gridx=0;
		panel.add(label, gbc);
		
		//check box for correct answer 'yes'
		JCheckBox yesCheck = new JCheckBox("Yes");
		yesCheck.setFont(this.buttonFont);
		yesCheck.setSelected(this.answer);

		//check box for correct answer 'no'
		JCheckBox noCheck = new JCheckBox("No");
		noCheck.setFont(this.buttonFont);
		noCheck.setSelected(!this.answer);
		
		yesCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answer=yesCheck.isSelected();
				noCheck.setSelected(!answer);
			}
		});
		
		noCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answer = !noCheck.isSelected();
				yesCheck.setSelected(answer);
			}
		});
		
		gbc.gridx=1;
		panel.add(yesCheck, gbc);
		
		gbc.gridx=2;
		panel.add(noCheck, gbc);
		
		return panel;
	}
	
	/**
	 * checks the various inputs for test generation
	 * @return boolean true or false
	 */
	private boolean checkParams() {
		//check files in sequence 1
		for (String s : this.seq1) {
			if(s==null) {
				new ErrorWindow("All files must be selected");
				return false;
			}
			if(s.contains(",")) {
				new ErrorWindow("File name can not contain commas: "+s);
				return false;
			}
		}
		
		//check files in sequence 2
		for (String s : this.seq2) {
			if(s==null) {
				new ErrorWindow("All files must be selected");
				return false;
			}
			if(s.contains(",")) {
				new ErrorWindow("File name can not contain commas: "+s);
				return false;
			}
		}
		
		//check directory
		if(this.directory.contains(",")) {
			new ErrorWindow("Directory path can not contain commas: "+this.directory);
		}
		
		//check that files in sequence 1 and 2 are in directory
		File dir = new File(this.directory);
		for (String s : this.seq1) {
			if(!Arrays.asList(dir.list()).contains(s)) {
				new ErrorWindow("Wav file was not found in directory: "+s+"; "+this.directory);
				return false;
			}
		}
		for (String s : this.seq2) {
			if(!Arrays.asList(dir.list()).contains(s)) {
				new ErrorWindow("Wav file was not found in directory: "+s+"; "+this.directory);
				return false;
			}
		}
		
		//all inputs are valid
		return true;
	}
	
	/**
	 * a print method for testing
	 */
	public void printParams() {
		System.out.println(this.directory);
		System.out.println(this.seq1.toString());
		System.out.println(this.seq2.toString());
		System.out.println(this.answer.toString());
	}
	
	/**
	 * builds a sub panel for generating a test from input
	 * @return
	 */
	private JPanel addTestPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.BOTH;
		
		//label for showing number of tests
		JLabel numTests = new JLabel("Number of generated Tests: "+CreateTestFiles.proxyGetNumTests());
		numTests.setFont(this.labelFont);
		
		//button for generating a test from input
		JButton addTest = new JButton("Add Test");
		addTest.setFont(this.buttonFont);
		addTest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkParams()) {
					//printParams();
					CreateTestFiles.proxyAddTest(directory, seq1, seq2, answer);
					numTests.setText("Number of generated Tests: "+CreateTestFiles.proxyGetNumTests());
					for(JFileChooser jfc : fileChoosers) {
						jfc.setCurrentDirectory(new File(directory));
						jfc.setSelectedFile(null);
					}
					for(JTextArea jta : fileTextAreas) {
						jta.setText(null);
					}
					for(int i = 0; i < 5; i++) {
						seq1.set(i, null);
						seq2.set(i, null);
					}
				}
			}
		});
		
		gbc.gridx=0;
		panel.add(addTest, gbc);
		
		gbc.gridx=1;
		panel.add(numTests, gbc);
		
		return panel;
	}
	
	/**
	 * builds a sub panel for the menu buttons
	 * @return jpanel for menu buttons
	 */
	private JPanel menuButtonPanel() {
		JPanel panel = new JPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.BOTH;
		
		//save file button
		JButton saveFileButton = new JButton("Save Tests");
		saveFileButton.setFont(this.buttonFont);
		saveFileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(CreateTestFiles.proxyGetNumTests()==0) {
					new ErrorWindow("Not tests have been generated");
				}else {
					AbstractPanel.getFrame().changePanel(new SaveTestFilePanel());
				}
			}
		});
		
		//return to main panel
		JButton returnButton = new JButton("Return");
		returnButton.setFont(this.buttonFont);
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CreateTestFiles.proxyClear();
				AbstractPanel.getFrame().changePanel(new MainPanel());
			}
		});
		
		gbc.gridx=0;
		panel.add(saveFileButton, gbc);
		
		gbc.gridx=1;
		panel.add(returnButton, gbc);
		
		return panel;
	}
	
	@Override
	public void buildPanel() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.BOTH;
		
		//directory selection field
		gbc.gridy=0;
		this.add(this.buildDirectorySelector(), gbc);
		
		//sequence selection fields
		gbc.gridy=1;
		this.add(this.sequenceSelectors(), gbc);
		
		//answer selection field
		gbc.gridy=2;
		this.add(this.answerSelector(), gbc);
		
		//add test and test count field
		gbc.gridy=3;
		this.add(this.addTestPanel(), gbc);
		
		//save and return field
		gbc.gridy=4;
		this.add(this.menuButtonPanel(), gbc);
	}

}
