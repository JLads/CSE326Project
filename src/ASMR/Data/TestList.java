package ASMR.Data;

import java.util.ArrayList;
import ASMR.Util.CSVIO;

/**
 * This class implements the functions of the retriever interface.
 * It also serves as a location to store the actual list of test objects
 * @author Joseph
 *
 */
public class TestList {

	private static ArrayList<Test> tests;	//The list of test objects
	
	private static String filepath = "";	//path to test file
	
	/**
	 * Initializes the object list on instantiation
	 */
	public TestList() {
		this.Initialize();
	}
	
	/**
	 * Initialize the static ivars.
	 * Calling a second time resets ivars to blank state.
	 */
	public void Initialize() {
		tests = new ArrayList<Test>();
	}
	
	/**
	 * Reinitializes the static variables
	 */
	public void Clear() {
		this.Initialize();
	}
	
	/**
	 * builds the list of tests from the contents of the test file
	 * @param fp the path to the test file
	 * @return the size of the list of tests
	 */
	public int BuildList(String fp) {
		//Put calls to utility parser here

		filepath = fp;
		
		ArrayList<String> lines = CSVIO.readFile(fp);
		
		for(int i = 0; i < lines.size(); i+=5) {
			tests.add(new Test(lines.get(i), lines.get(i+1), lines.get(i+2), lines.get(i+3)));
		}
	
		return tests.size();
	}
	
	/**
	 * returns the path of the test file
	 * @return the path of the test file
	 */
	public String getFilepath() {
		return filepath;
	}

	/**
	 * returns a sequence from a test in the list of tests
	 * @param testnum the test in the list of tests
	 * @param seqID the sequence in the test to return
	 * @return a sequence from a test
	 */
	public ArrayList<String> getSequence(int testnum, int seqID) {
		switch(seqID) {
		case 1:
			return tests.get(testnum).listFirst();
		case 2:
			return tests.get(testnum).listSecond();
		default:
			return tests.get(testnum).listFirst();
		}
	}

	/**
	 * returns the correct answer for a test
	 * @param testnum the number of the test in the list of tests
	 * @return the correct answer for the test
	 */
	public String getAnswer(int testnum) {
		return tests.get(testnum).getAnswer();
	}
	
	/**
	 * returns the directory for a test
	 * @param testnum the number of the test in the list of tests
	 * @return the directory for a test
	 */
	public String getDir(int testnum) {
		return tests.get(testnum).getDir();
	}

	/**
	 * returns the size of the list of tests
	 * @return the size of the list of tests
	 */
	public int getListSize() {
		return tests.size();
	}
}
