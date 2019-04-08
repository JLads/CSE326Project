package ASMR.Data;

import java.util.ArrayList;
import ASMR.Util.CSVIO;

/**
 * Class for logging tests
 * Before presenting tests, initiate a single object of this class
 * Class methods will be called by the gui action handlers
 * Links test number and subject response
 * 
 * @author Joseph Ladino
 * @author Ty Darnell
 *
 */
public class TestLogger{
	
	private static ArrayList<String> response = null;	//list of user responses
	private static ArrayList<String> correct = null;	//list of correct answers
	private static ArrayList<Integer> pairId = null;	//list of test numbers
	private static int pairNum = 0;						//current test number
	private static String fname;						//test file path
	
	/**
	 * Initiates constructor
	 * stores name of the test file being used
	 */
	public TestLogger(String _fname) {
		fname = _fname;
		response = new ArrayList<String>();
		correct = new ArrayList<String>();
		pairId = new ArrayList<Integer>();
	}
	
	/**
	 * set the value of the file name for the test file
	 * @param filename file name of test file
	 */
	public void setFName(String filename) {
		fname=filename;
	}
	
	/**
	 * record a test subject responding "yes"
	 * @param ans string containing correct response
	 */
	public void logYes(String ans) {
		pairNum++;
		response.add("yes");
		correct.add(ans);
		pairId.add(pairNum);
	}
	
	/**
	 * record a test subject responding "no"
	 * @param ans string containing correct response
	 */
	public void logNo(String ans) {
		pairNum++;
		response.add("no");
		correct.add(ans);
		pairId.add(pairNum);
	}
	
	/**
	 * save the recorded results to a results file
	 * @param fpath file path to save results to
	 */
	public void saveResults(String fpath) {
		ArrayList<String> lines = new ArrayList<String>();
		
		lines.add(fname);
		lines.add("Test#,Correct,Subject");
		
		for(int i = 0; i < response.size(); i++) {
			String s = String.format("%d,%s,%s", pairId.get(i), correct.get(i), response.get(i));
			lines.add(s);
		}
		
		CSVIO.writeFile(lines, fpath);
	}
	
	/**
	 * Testing function for debugging
	 * prints out the values in each array list
	 */
	public void printArray() {
		System.out.println("Test file: " + fname);
		for(int i = 0; i < pairId.size(); i++) {
			String msg = String.format("Pair %3d: ", pairId.get(i));
			msg += String.format("User Response: %-3s, ", response.get(i));
			msg += String.format("Correct Response: %-3s", correct.get(i));
			System.out.println(msg);
		}
	}
}
