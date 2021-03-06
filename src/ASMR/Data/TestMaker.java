package ASMR.Data;

import java.util.ArrayList;

import ASMR.Util.CSVIO;

/**
 * Takes user input from gui and converts it to a test.csv file
 * Builds one test at a time and stores them in an array list of tests.
 * The tests are written out by our UTIL file writer at the end.
 * @author Joseph
 *
 */
public class TestMaker {

	private static ArrayList<Test> tests;    //List of test objects created by user
	
	/**
	 * Default constructor
	 */
	public TestMaker() {
		this.initialize();
	}
	
	/**
	 * Initialize Ivars
	 */
	void initialize() {
		tests = new ArrayList<Test>();
	}
	
	/**
	 * clear out static Ivars
	 */
	public void clear() {
		this.initialize();
	}
	
	/**
	 * adds a test object to the list of tests being created
	 * @param dir directory path to audio files as string
	 * @param seq1 array list of first sequence's file name strings
	 * @param seq2 array list of second sequence's file name strings
	 * @param ans boolean correct answer: true = "yes", false = "no"
	 */
	public void addTest(String dir, ArrayList<String> seq1, ArrayList<String> seq2, boolean ans) {
		if (ans == true) {
			tests.add(new Test(dir, seq1, seq2, "yes"));
		} else {
			tests.add(new Test(dir, seq1, seq2, "no"));
		}
	}
	
	/**
	 * parses created tests into string format and 
	 * passes data to csv writer
	 * @param fname file path to save the test file at
	 */
	public void saveTests(String fname) {
		ArrayList<String> tmp = new ArrayList<String>();
		for (Test test:tests) {
			tmp.add(test.getDir());
			tmp.add(test.getFirst().toString());
			tmp.add(test.getSecond().toString());
			tmp.add(test.getAnswer());
			tmp.add("");
		}
		CSVIO.writeFile(tmp, fname);
	}
	
	/**
	 * returns the number of tests in the list
	 * @return the number of tests in the list
	 */
	public int getNumTests() {
		return tests.size();
	}
	
}
