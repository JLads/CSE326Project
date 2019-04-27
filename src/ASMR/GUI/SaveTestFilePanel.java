package ASMR.GUI;

import javax.swing.filechooser.FileNameExtensionFilter;

import ASMR.Data.CreateTestFiles;

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

		this.chooser.setFileFilter(new FileNameExtensionFilter("CSV FILE", "csv"));
	}

	@Override
	public void processFilepath(String fp) {
		CreateTestFiles.proxySaveTests(fp);
		CreateTestFiles.proxyClear();
		AbstractPanel.getFrame().changePanel(new TestGenerationPanel());
	}

}
