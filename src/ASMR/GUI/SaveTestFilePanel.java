package ASMR.GUI;

/**
 * a panel for saving a test file
 * @author nicholas
 *
 */
public class SaveTestFilePanel extends AbstractFileIOPanel{

	private static final long serialVersionUID = -8268443838121305561L;
	
	/**
	 * default constructor
	 */
	public SaveTestFilePanel() {
		this.panelLabel="Enter the file path for a Test file to save.";
		this.buildPanel();
	}

	@Override
	public void processFilepath(String fp) {
		// TODO call function for saving test file
		System.out.println(fp);
		new WIPWindow();
	}

}
