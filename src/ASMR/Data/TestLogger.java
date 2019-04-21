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
		pairNum++;
		response.add("yes");
		correct.add(ans);
		pairId.add(pairNum);
		if(ans.contentEquals("yes")) {
			logPoints(3);
		} else {
			logPoints(2);
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
		pairNum++;
		response.add("no");
		correct.add(ans);
		pairId.add(pairNum);
		if(ans.contentEquals("yes")) {
			logPoints(1);
		} else {
			logPoints(4);
		}
		pointTotal.add(points);
	}
	
	
	/**
	 * Logs point values based on user response and correct answers
	 * @param type Error identifier as an Integer
	 */
	private void logPoints(int type) {
		switch(type) {
		case 1: //Incorrect Answer
			//Subject No, Actually Yes
			points -= 5;
			break;
		case 2: //Incorrect Answer
			//Subject Yes, Actually No
			points -= 5;
			break;
		case 3: //Correct Answer
			//Subject Yes, Actually Yes
			points += 10;
			break;
		case 4: //Correct Answer
			//Subject No, Actually No
			points += 10;
		default:
			System.out.println("Error: Invalid Point Option");
			break;
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
