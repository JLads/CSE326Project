package ASMR.Data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

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
	
	public void SaveResults(String fpath) {
		/*
		 * Get intended fpath
		 * create new csv file
		 * populate via hashmap.getkeys and getting values
		 */
		
		//Creates a file 
		File file = new File(fpath); 
		FileWriter writer;
		
		try {
			//Used to iterate through HashMap
			Iterator<Entry<String, Boolean>> it = results.entrySet().iterator();
			Map.Entry<String, Boolean> pair;
			
			writer = new FileWriter(file);
			
			//CSV file header
			writer.append("\n");
			
			//Loops through HashMap until it's empty
			writer.append("Test File Name, Correct Answer\n");
			while(it.hasNext()) {
				
				pair = (Map.Entry<String, Boolean>) it.next();
				writer.append(pair.getKey() + ", ");
				
				if(pair.getValue() == true) {
					//answer is correct
					writer.append("1\n"); 
				} else {
					//answer is incorrect
					writer.append("0\n");
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
