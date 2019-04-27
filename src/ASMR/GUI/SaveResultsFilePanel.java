package ASMR.GUI;

import javax.swing.filechooser.FileNameExtensionFilter;

import ASMR.Data.ResultLogger;
import ASMR.Data.TestRetriever;

/**
 * a panel for saving results out to file
 * @author nicholas
 *
 */
public class SaveResultsFilePanel extends AbstractFileIOPanel {

	private static final long serialVersionUID = 4837701024627209117L;
	
	/**
	 * default constructor
	 */
	public SaveResultsFilePanel() {
		this.panelLabel = "Enter the file path for a Results file to save.";
		this.buildPanel();

		this.chooser.setFileFilter(new FileNameExtensionFilter("CSV FILE", "csv"));
	}

	@Override
	public void processFilepath(String fp) {
		ResultLogger.proxySaveResults(fp);
		ResultLogger.proxyClear();
		TestRetriever.proxyClear();
		
		
		AbstractPanel.getFrame().changePanel(new MainPanel());
	}

}
