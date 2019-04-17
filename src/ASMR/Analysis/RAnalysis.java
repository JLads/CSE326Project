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

	/**
	 * Obtains and returns the Windows-specific file path of the Rscript executable
	 * @return The file path of the Rscript executable on Windows as a string
	 */
	private static String getWindowsRPath() throws FileNotFoundException {

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
	private static String getLinuxRPath() {
		return "/usr/bin";
	}

	/**
	 * Gets the platform-dependent file path of the "Rscript" executable
	 * @return The string representation of the Rscript file path
	 */
	private static String getRScriptCommand() {
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
	private static BufferedReader runRScript(String rScript) {

		Process rChild;
		BufferedReader rOutput = null;
		String rScriptCommand = null;

		try {
			rScriptCommand = getRScriptCommand();
			rChild = new ProcessBuilder(rScriptCommand, rScript).start();
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
}
