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
