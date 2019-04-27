package ASMR.Analysis;


/**
 * An interface for performing data analysis with R
 * @author Steven Anaya
 *
 */
public interface DataAnalysis {

	// Perform data analysis using R
	RAnalysis rAnalysis = new RAnalysis();
	
	public static void proxyRunAnalysis(String dataFile, String analysisResultsPath) {
		rAnalysis.runAnalysis(dataFile, analysisResultsPath);
	}
}
