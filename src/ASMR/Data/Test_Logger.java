package ASMR.Data;

import java.util.HashMap;

/**
 * Class for logging tests
 * Before presenting tests, initiate a single object of this class
 * Class methods will be called by the gui action handlers
 * Links test number and subject response
 * 
 * @author Joseph Ladino
 *
 */

public class Test_Logger {

	private HashMap <String, Boolean> results = null;
	/**
	 * constructor to initiate the logger before tests are run
	 */
	public Test_Logger() {
		results = new HashMap<String, Boolean>();
	}
	/**
	 * record subject yes response
	 * @param test: object with test data
	 */
	public void Log_Yes(Test test) {
		String tmp = test.getAnswer();
		if(tmp.toLowerCase().compareTo("yes") == 0) {
			//boolean true is a correct answer
			results.put(test.getId(), true);
		} else {
			//boolean false is an incorrect answer
			results.put(test.getId(), false);
		}
		
	}
	/**
	 * record subject no response
	 * @param test: object with test data
	 */
	public void Log_No(Test test) {
		String tmp = test.getAnswer();
		if(tmp.toLowerCase().compareTo("no") == 0) {
			//boolean true is a correct answer
			results.put(test.getId(), true);
		} else {
			//boolean false is an incorrect answer
			results.put(test.getId(), false);
		}
	}
	
	public void SaveResults() {
		/*
		 * Get intended fpath
		 * create new csv file
		 * populate via hashmap.getkeys and getting values
		 */
	}
	
}
