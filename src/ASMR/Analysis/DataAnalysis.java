package ASMR.Analysis;


/**
 * An interface for performing data analysis with R
 * @author Steven Anaya
 *
 */
public interface DataAnalysis {

	// Perform data analysis using R
	RAnalysis rAnalysis = new RAnalysis();
	
	public static AnalysisResults proxyRunAnalysis(String dataFile, String analysisResultsPath) {
		return rAnalysis.runAnalysis(dataFile, analysisResultsPath);
	}
}
