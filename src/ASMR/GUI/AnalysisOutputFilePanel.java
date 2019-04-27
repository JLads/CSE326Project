package ASMR.GUI;

import ASMR.Analysis.DataAnalysis;

/**
 * a panel for retrieving the file path to save the results of data analysis to
 * @author nicholas
 *
 */
public class AnalysisOutputFilePanel extends AbstractFileIOPanel {

	private static final long serialVersionUID = 1390475044114575346L;
	
	private String resultsFile;	//the results file to load for data analysis
	
	public AnalysisOutputFilePanel(String fp) {
		/* 
		 * generally, panels are not supposed to pass data to each other through constructors, 
		 * but we make a special case here
		 */
		this.resultsFile=fp;
		this.panelLabel="Enter a file path to save results of analysis to.";
		this.buildPanel();
	}

	@Override
	public void processFilepath(String fp) {
		DataAnalysis.proxyRunAnalysis(this.resultsFile, fp);
		AbstractPanel.getFrame().changePanel(new MainPanel());
	}

}
