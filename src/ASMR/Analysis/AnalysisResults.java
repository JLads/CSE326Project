package ASMR.Analysis;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * A class for holding results generated by data analysis
 * @author Steven Anaya
 *
 */
public class AnalysisResults {

	private String dataFile;
	private String testFile;
	private int numberTests;
	private int finalScore;
	private double proportionCorrect;

	/**
	 * Initialize a new AnalysisReults object for the given data file
	 * @param dataFile The data file to be bound to this object
	 */
	public AnalysisResults(String dataFile) {
		this.dataFile = dataFile;
	}
	
	public void setTestFile(String testFile) {
		this.testFile = testFile;
	}
	
	public void setNumberTests(int numberTests) {
		this.numberTests = numberTests;
	}

	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}

	public void setProportionCorrect(double proportionCorrect) {
		this.proportionCorrect = proportionCorrect;
	}
	
	/**
	 * Write analysis results out to a file.
	 * @param resultsPath The analysis results file path
	 */
	public void writeAnalysisResults(String resultsPath) {
		File resultsFile = new File(resultsPath);
		
		if (resultsFile.exists()) {
			resultsFile.delete();
		}
		
		try {
			PrintWriter writer = new PrintWriter(resultsFile);
			writer.println("Test file: " + testFile);
			writer.println("Data File: " + dataFile);
			writer.println("Number of tests: " + numberTests);
			writer.println("Subject Final Score: " + finalScore);
			writer.println("Proportion Answers Correct: " + proportionCorrect);
			writer.close();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
