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
	
	
	@Override
	public void Save_Results(String fpath) {
		/**
		 * This function may be moved into utilities.
		 * Until then, this writes out the results csv files
		 */
		
		File out;
		FileWriter writer;
		
		try{
			out = new File(fpath);
			if(!out.exists()) {
				out.createNewFile();
			}
			writer = new FileWriter(out);
			
			writer.append(fname + System.getProperty("line.separator"));
			writer.append("PairNo,Correct,Response" + System.getProperty("line.separator"));
			
			for(int i = 0; i < response.size(); i++) {
				String s = String.format("%d,%s,%s", pairId.get(i), correct.get(i), response.get(i));
				writer.append(s);
				writer.append(System.getProperty("line.separator")); //new line for file
			}
			writer.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		
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
