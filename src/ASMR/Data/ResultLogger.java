package ASMR.Data;

public interface ResultLogger {
	
	//---------------------------------------------------------------------------
	//The following were additions made to make
	//the interface usable by the gui
	// - Nicholas Jones
	
	TestLogger tLog = new TestLogger(TestRetriever.proxyGetFilePath()); // instance of TestLogger subclass
	
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
		tLog.Log_Yes(ans);
	}
	
	/**
	 * records test result of no
	 * @param ans the correct answer
	 */
	public static void proxyLogNo(String ans) {
		tLog.Log_No(ans);
	}
	
	/**
	 * saves results out to file
	 * @param fpath the file path to save the results to
	 */
	public static void proxySaveResults(String fpath) {
		tLog.Save_Results(fpath);
	}
	//---------------------------------------------------------------------------

	
	/**
	 * record a test subject responding "yes"
	 * @param ans string containing correct response
	 */
	public abstract void Log_Yes(String ans);
	
	/**
	 * record a test subject responding "no"
	 * @param ans string containing correct response
	 */
	public abstract void Log_No(String ans);
	
	public abstract void Save_Results(String fpath);
}
