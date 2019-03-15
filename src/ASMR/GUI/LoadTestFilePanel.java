package ASMR.GUI;

import ASMR.Data.TestRetriever;

/**
 * A class for retrieving the filepath to a test file to load  
 * @author nicholas
 *
 */
public class LoadTestFilePanel extends AbstractFileIOPanel{
	
	private static final long serialVersionUID = -7660337987383230213L;
	
	/**
	 * default constructor
	 */
	public LoadTestFilePanel() {
		this.panelLabel = "Enter the file path for a Test file.";
		this.buildPanel();
	}

	@Override
	public void processFilepath(String fp) {
		/*
		TestRetriever tr = null;
		tr.BuildList(fp);
		*/
		System.out.println(fp);
		new WIPWindow();
	}
}
