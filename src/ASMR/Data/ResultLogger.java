package ASMR.Data;

/**
 * an interface for the gui to access the test logger subsystem
 * @author nicholas
 *
 */
public interface ResultLogger {
	
	TestLogger tLog = new TestLogger(TestRetriever.proxyGetFilePath());	//instance of TestLogger subclass
	
	/**
	 * sets the file name of the test file
	 * @param fp
	 */
	public static void proxySetFName(String fp) {
		tLog.setFName(fp);
	}
	
	/**
	 * records test result of yes
	 * @param ans the correct answer
	 */
	public static void proxyLogYes(String ans) {
		tLog.logYes(ans);
	}
	
	/**
	 * records test result of no
	 * @param ans the correct answer
	 */
	public static void proxyLogNo(String ans) {
		tLog.logNo(ans);
	}
	
	/**
	 * saves results out to file
	 * @param fpath the file path to save the results to
	 */
	public static void proxySaveResults(String fpath) {
		tLog.saveResults(fpath);
	}
}
