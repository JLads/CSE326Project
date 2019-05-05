package ASMR.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * A helper class for retrieving the R installation path from the registry on a Windows system
 * Registry output parsing code adopted from https://github.com/yannrichet/rsession/blob/master/src/main/java/org/math/R/StartRserve.java
 * @author Steven Anaya
 *
 */
public class RegistryStreamEater extends Thread {

	private InputStream is;
	private String installPath;

	/**
	 * Constructor for the RegistryStreamEater
	 * @param is The input stream for the registry request subprocess
	 */
	public RegistryStreamEater(InputStream is) {

		this.is = is;
		start();
	}

	/**
	 * Retrieve the R installation path on a Windows system
	 * @return The file path of the user's R installation
	 */
	public String getInstallPath() {

		return installPath;
	}

	/**
	 * Run the Registry Stream Eater as a thread
	 */
	public void run() {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			for (String regLine = br.readLine(); regLine != null; regLine = br.readLine()) {
				int installIndex = regLine.indexOf("InstallPath");
				if (installIndex >= 0) {
					String pathString = regLine.substring(installIndex + 11).trim();
					int regIndex = pathString.indexOf("REG_SZ");
					if (regIndex >= 0)
						installPath = pathString.substring(regIndex + 6).trim();
					else
						installPath = pathString;
				}
			}
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
