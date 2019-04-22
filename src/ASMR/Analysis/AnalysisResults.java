package ASMR.Analysis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AnalysisResults {

	private String dataFile;
	private int finalScore;
	private double proportionCorrect;

	public AnalysisResults(String dataFile) {
		this.dataFile = dataFile;
	}

	public String getDataFile() {
		return dataFile;
	}

	public double getProportionCorrect() {
		return proportionCorrect;
	}

	public void setProportionCorrect(double proportionCorrect) {
		this.proportionCorrect = proportionCorrect;
	}

	public int getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}
	
	public void writeAnalysisResults(String resultsPath) {
		File resultsFile = new File(resultsPath);
		
		if (resultsFile.exists()) {
			resultsFile.delete();
		}
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(resultsFile));
			String nl = System.getProperty("line.separator");
			writer.append("Data File: " + dataFile + nl);
			writer.append("Subject Final Score: " + finalScore + nl);
			writer.append("Proportion Answers Correct: " + proportionCorrect + nl);
			writer.close();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
