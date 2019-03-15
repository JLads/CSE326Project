package ASMR.Data;

import java.util.ArrayList;


/**
 * This is the test retrieval interface for the GUI.
 * The gui can call "TestRetriever tmp = new TestList();" to gain
 * access to the test objects and stimuli sequences.
 * @author Joseph
 *
 */
public interface TestRetriever {
	
	//---------------------------------------------------------------------------
	//The following were additions made to make
	//the interface usable by the gui
	// - Nicholas Jones
	
	TestList tl = new TestList(); //an instance of the test list subclass
	
	/**
	 * builds the list of test objects
	 * @param fp path to test file
	 * @return length of list
	 */
	public static int proxyBuildList(String fp) {
		return tl.BuildList(fp);
	}
	
	public static String proxyGetFilePath() {
		return tl.getFilepath();
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
	//----------------------------------------------------------------------------

	/**
	 * Builds the list of test objects and reports the number of tests
	 * in queue
	 * @param fp path to the data source csv file
	 * @return the number of test objects in the list
	 */
	public abstract int BuildList(String fp);
	
	/**
	 * returns a specific sequence from a specific test
	 * @param testnum index of desired test object
	 * @param i takes 1 or 2: the sequence to return
	 * @return array list of file paths for each audio file in a sequence
	 */
	public abstract ArrayList<String> getSequence(int testnum, int i);
	
	/**
	 * gets the correct response string from a specified test object
	 * @param testnum index of desired test object
	 * @return correct response as a String
	 */
	public abstract String getAnswer(int testnum);
	
	
	/**
	 * Gets the size of the list of test objects
	 * @return the size of the object list
	 */
	public abstract int getListSize();
}
