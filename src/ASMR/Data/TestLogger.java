package ASMR.Data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
 *@todo: Create interface for this class so UI does not directly access this.
 */

public class TestLogger implements ResultLogger{

	
	private static ArrayList<String> response = null;
	private static ArrayList<String> correct = null;
	private static ArrayList<Integer> pairId = null;
	private static int pairNum = 0;
	private static String fname;
	
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
	

	@Override
	public void Log_Yes(String ans) {
		pairNum++;
		response.add("yes");
		correct.add(ans);
		pairId.add(pairNum);
		
	}
	@Override
	public void Log_No(String ans) {
		pairNum++;
		response.add("no");
		correct.add(ans);
		pairId.add(pairNum);
	}
	
	public void printArray() {
		System.out.println("Test file: " + fname);
		for(int i = 0; i < pairId.size(); i++) {
			String msg = String.format("Pair %3d: ", pairId.get(i));
			msg += String.format("User Response: %-3s, ", response.get(i));
			msg += String.format("Correct Response: %-3s", correct.get(i));
			System.out.println(msg);
		}
	}
	
	
	//Rework how to write to a csv file
	/*
	public void SaveResults(String fpath) {
		/*
		 * Get intended fpath
		 * create new csv file
		 * populate via hashmap.getkeys and getting values
		 *
		
		//Creates a file 
		File file = new File(fpath); 
		FileWriter writer;
		
		try {
			//Used to iterate through HashMap
			Iterator<Entry<String, String>> it = results.entrySet().iterator();
			Map.Entry<String, String> pair;
			
			writer = new FileWriter(file);
			
			//CSV file header
			writer.append("\n");
			
			//Loops through HashMap until it's empty
			writer.append("Test File Name, Correct Answer\n");
			while(it.hasNext()) {
				
				pair = (Map.Entry<String, String>) it.next();
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
	*/

	

}
