package ASMR.Data;

import java.util.ArrayList;

/**
 * This is the test retrieval interface for the GUI.
 * @author Joseph
 *
 */
public interface TestRetriever {
	
	TestList tl = new TestList(); //an instance of the test list subclass
	
	/**
	 * builds the list of test objects
	 * @param fp path to test file
	 * @return length of list
	 */
	public static int proxyBuildList(String fp) {
		ResultLogger.proxySetFName(fp);
		return tl.BuildList(fp);
	}
	
	/**
	 * gets the file path to test file
	 * @return file path to test file
	 */
	public static String proxyGetFilePath() {
		return tl.getFilepath();
	}
	
	/**
	 * Set ivar values to defaults
	 */
	public static void proxyClear() {
		tl.Clear();
	}
	
	/**
	 * returns a sequence of audio files for a given test
	 * @param testnum the test for which to retrieve a sequence of
	 * @param seqID the sequence to be retrieved
	 * @return the sequence of audio files to be played in a test
	 */
	public static ArrayList<String> proxyGetSequence(int testnum, int seqID){
		return tl.getSequence(testnum, seqID);
	}
	
	/**
	 * returns the correct answer for a given test
	 * @param testnum the test for which to retrieve that correct answer
	 * @return string of yes or no
	 */
	public static String proxyGetAnswer(int testnum) {
		return tl.getAnswer(testnum);
	}
	
	/**
	 * gets the size of the list of tests
	 * @return the size of the list of tests
	 */
	public static int proxyGetListSize() {
		return tl.getListSize();
	}
}
