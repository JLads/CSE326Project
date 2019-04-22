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
	
	private static enum responseType{
		correctSame, correctDiff, wrongSame, wrongDiff
	}
	
	private static ArrayList<String> response = null;		//list of user responses
	private static ArrayList<String> correct = null;		//list of correct answers
	private static ArrayList<Integer> pairId = null;		//list of test numbers
	private static ArrayList<Integer> pointTotal = null;	//list of total score after each test
	private static int pairNum = 0;							//current test number
	private static int points = 0;							//test subject score
	private static String fname;							//test file path
	
	/**
	 * Initiates constructor
	 * stores name of the test file being used
	 */
	public TestLogger(String _fname) {
		this.Initialize(_fname);
	}
	
	/**
	 * Initializes all of the ivars.
	 * Calling this a second time will reset the ivars to blank states.
	 * @param _fname
	 */
	public void Initialize(String _fname) {
		fname = _fname;
		response = new ArrayList<String>();
		correct = new ArrayList<String>();
		pairId = new ArrayList<Integer>();
		pointTotal = new ArrayList<Integer>();
		points = 0;
	}
	
	/**
	 * Calls initialize to reset the static ivars to blank states
	 * This prevents future settings of the statics from being appended to
	 */
	public void Clear() {
		this.Initialize(null);
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
	 * If subject response is correct add 10 points
	 * If subject response is wrong, subtract 5 points
	 * @param ans string containing correct response
	 */
	public void logYes(String ans) {
		responseType type;
		pairNum++;
		response.add("yes");
		correct.add(ans);
		pairId.add(pairNum);
		if(ans.contentEquals("yes")) {
			//correct same
			type = responseType.correctSame;
			logPoints(type);
		} else {
			//incorrect different
			type = responseType.wrongDiff;
			logPoints(type);
		}
		pointTotal.add(points);
	}
	
	/**
	 * record a test subject responding "no"
	 * If subject response is correct add 10 points
	 * If subject response is wrong, subtract 5 points
	 * @param ans string containing correct response
	 */
	public void logNo(String ans) {
		responseType type;
		pairNum++;
		response.add("no");
		correct.add(ans);
		pairId.add(pairNum);
		if(ans.contentEquals("no")) {
			//Correct different
			type = responseType.correctDiff;
			logPoints(type);
		} else {
			//incorrect same
			type = responseType.wrongSame;
			logPoints(type);
		}
		pointTotal.add(points);
	}
	
	
	/**
	 * Logs point values based on user response and correct answers
	 * Multiple different point value lists are possible.
	 * They are defined as arrays called pointTable[]. Comment in the one to be active
	 * @param type Response:correct pair defined as an enumerated type.
	 */
	private void logPoints(responseType type) {
		/*
		 * ALERT
		 * add new arrays here for different point scales. Name them the same and comment in only one.
		 * ALERT
		 * point set arrays format as follows
		 * {correct same value, correct diff value, incorrect same value, incorrect diff value}
		 */
		//int[] pointTable = {10, 10, -5, -5};			//Baseline point table
		int[] pointTable = {10, 8, -8, -6};			//Incentivize fewer false detection of differences
		//int[] pointTable = {8, 10, -6, -8};			//Bias towards detecting differences
		
		
		if(type == responseType.correctSame) {
			//correct id of same sequences
			points += pointTable[0];
			
		} else if(type == responseType.correctDiff) {
			//correct id of different sequences
			points += pointTable[1];
			
		} else if(type == responseType.wrongSame) {
			//wrong id of same sequences
			points += pointTable[2];
			
		} else if(type == responseType.wrongDiff) {
			//wrong id of different sequences
			points += pointTable[3];
			
		}
		
	}
	
	/**
	 * gets points for subject
	 * @return points earned as an int
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * save the recorded results to a results file
	 * @param fpath file path to save results to
	 */
	public void saveResults(String fpath) {
		ArrayList<String> lines = new ArrayList<String>();
		
		lines.add(fname);
		lines.add("Test#,Correct,Subject,Points");
		
		for(int i = 0; i < response.size(); i++) {
			String s = String.format("%d,%s,%s,%d", pairId.get(i), correct.get(i), response.get(i), pointTotal.get(i));
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
