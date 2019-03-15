package ASMR.GUI;

import ASMR.Data.TestRetriever;

/**
 * A panel for retrieving the filepath to a test file to load  
 * @author nicholas
 *
 */
public class LoadTestFilePanel extends AbstractFileIOPanel{
	
	private static final long serialVersionUID = -7660337987383230213L;
	
	/**
	 * default constructor
	 */
	public LoadTestFilePanel() {
		this.panelLabel = "Enter the file path for a Test file to load.";
		this.buildPanel();
	}

	@Override
	public void processFilepath(String fp) {
		TestRetriever.proxyBuildList(fp);
		//TODO connect to another panel
		new WIPWindow();
	}
}
