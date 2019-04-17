package ASMR.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * A helper class for retrieving the R installation path from the registry on a Windows system
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
			String line = null;
			while ((line = br.readLine()) != null) {
				int i = line.indexOf("InstallPath");
				if (i >= 0) {
					String s = line.substring(i + 11).trim();
					int j = s.indexOf("REG_SZ");
					if (j >= 0)
						s = s.substring(j + 6).trim();
					installPath = s;
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
