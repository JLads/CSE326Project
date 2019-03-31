package ASMR.GUI;

/**
 * a panel for loading a results file
 * @author nicholas
 *
 */
public class LoadResultsFilePanel extends AbstractFileIOPanel{

	private static final long serialVersionUID = 2822555162484286453L;
	
	/**
	 * default constructor
	 */
	public LoadResultsFilePanel() {
		this.panelLabel="Enter the file path for a Results file to load.";
		this.buildPanel();
	}

	@Override
	public void processFilepath(String fp) {
		// TODO call function for loading results file
		System.out.println(fp);
		new WIPWindow();
	}
	
}
