package ASMR.Analysis;


/**
 * An interface for performing data analysis with R
 * @author Steven Anaya
 *
 */
public interface DataAnalysis {

	// Perform data analysis using R
	RAnalysis rAnalysis = new RAnalysis();
	
	/**
	 * Run analysis on a given data file, outputting to the specified analysis results file.
	 * @param dataFile The data file to analyze
	 * @param analysisResultsFile The file to output results to
	 */
	public static void proxyRunAnalysis(String dataFile, String analysisResultsFile) {
		rAnalysis.runAnalysis(dataFile, analysisResultsFile);
	}
}
