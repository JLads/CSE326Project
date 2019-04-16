package ASMR.GUI;

import ASMR.Data.CreateTestFiles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

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
		
		//directory selector
		
		//seq1 selectors
		
		//seq2 selectors
		
		//correct answer selector
		
		//add to list button
		
		//test number tracker
		
		//save test
		
		//return
	}

}
