package ASMR.Analysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ASMR.Util.RegistryStreamEater;

/**
 * A class for analyzing test results in R
 * @author Steven Anaya
 *
 */
public class RAnalysis {

	private final String scriptPath;
	private final String scoreScriptPath;
	
	public RAnalysis() {

		scriptPath = String.join(File.separator, System.getProperty("user.dir"),
				"src", "ASMR", "Analysis", "RScripts");
		scoreScriptPath = String.join(File.separator, scriptPath, "score.r");
	}

	/**
	 * Obtains and returns the Windows-specific file path of the Rscript executable
	 * @return The file path of the Rscript executable on Windows as a string
	 */
	private String getWindowsRPath() throws FileNotFoundException {

		String windowsRPath = null;

		try {
			Process rp = Runtime.getRuntime().exec("reg query HKLM\\Software\\R-core\\R");
			RegistryStreamEater regEater = new RegistryStreamEater(rp.getInputStream());
			rp.waitFor();
			regEater.join();
			windowsRPath = regEater.getInstallPath();
		} catch (Exception rge) {
			throw new RuntimeException("Unable to access Windows registry");
		}

		if (windowsRPath == null) {
			throw new FileNotFoundException("Unable to find file path to R executable");
		}	
		return windowsRPath;
	}

	/**
	 * Returns the Linux-specific file path of the Rscript executable
	 * @return The file path of the Rscript executable on Linux as a string
	 */
	private String getLinuxRPath() {

		return "/usr/bin";
	}

	/**
	 * Gets the platform-dependent file path of the "Rscript" executable
	 * @return The string representation of the Rscript file path
	 */
	private String getRScriptCommand() {

		String OSName = System.getProperty("os.name").toLowerCase();
		String rCommand = null;

		if (OSName.contains("windows")) {
			try {
				rCommand = getWindowsRPath() + "\\bin\\Rscript.exe";
			}
			catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			}
		} else if (OSName.contains("linux")) {
			rCommand = getLinuxRPath() + "/Rscript";
		} else {
			throw new RuntimeException("Unsupported Operating System: " + OSName);
		}
		return rCommand;
	}

	/**
	 * Runs an arbitrary R script
	 * @param rScript Absolute path of the R script to run
	 * @return The output of the R script as a BufferedOutput object
	 */
	private BufferedReader runRScript(String rScript, String dataFile) {

		Process rChild;
		BufferedReader rOutput = null;
		String rScriptCommand = null;

		try {
			rScriptCommand = getRScriptCommand();
			rChild = new ProcessBuilder(rScriptCommand, rScript, dataFile).start();
			int exitCode = rChild.waitFor();

			if (exitCode == 0) {
				// Normal termination
		    	rOutput = new BufferedReader(new InputStreamReader(rChild.getInputStream()));
			} else {
				// Terminated with error
		    	throw new IllegalArgumentException("Broken or non-existent R script: " + rScript);
			}
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
			throw new IllegalArgumentException("Unable to execute command: " + rScriptCommand);
		}
		catch (InterruptedException ie) {
			System.err.println("Critical error: " + ie.getMessage());
		}
		return rOutput;
	}
	
	private void assignResults(BufferedReader results, AnalysisResults resultsContainer) {
		
		try {
			for (String line = results.readLine(); results != null; line = results.readLine()) {
				String[] resultPair = line.split(":");
				String label = resultPair[0];
				String value = resultPair[1];

				switch (label) {
				case "ProportionCorrect":
					resultsContainer.setProportionCorrect(new Double(value));
					break;
				case "FinalScore":
					resultsContainer.setFinalScore(new Integer(value));
					break;
				default:
					throw new IllegalArgumentException("Invalid or unimplemented statistic: " + label);
				}
			}
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	/**
	 * Run an R script to compute the number of correct answers divided by the number of total answers
	 * as well as tracking the score differential between tests
	 *  
	 * @param dataFile The path to the data file to analyze
	 * @return A BufferedReader object containing the R script's output
	 */
	private void runScoreScript(String dataFile, AnalysisResults analysisResults) {
		
		BufferedReader scoreResults = null;

		try {
			scoreResults = runRScript(scoreScriptPath, dataFile);
		}
		catch (IllegalArgumentException iae) {
			System.err.println(iae.getMessage());
		}
		
		assignResults(scoreResults, analysisResults);
	}
	
	public AnalysisResults runAnalysis(String dataFile) {
		
		AnalysisResults analysisResults = new AnalysisResults();
		
		runScoreScript(dataFile, analysisResults);
		
		return analysisResults;
	}
}
