package ASMR.Analysis;

import java.io.BufferedReader;

/**
 * An interface for performing data analysis with R
 * @author Steven Anaya
 *
 */
public interface DataAnalysis {

	// Perform data analysis using R
	RAnalysis rAnalysis = new RAnalysis();
	
	public static BufferedReader proxyRunScoreAnalysis(String dataFile) {
		return rAnalysis.runScoreScript(dataFile);
	}
}
