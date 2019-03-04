package ASMR.Data;


import java.util.ArrayList;

import ASMR.Util.Clip_Player;

/**
 * Interface class for UI to access data
 * Main for entire program will need to instantiate this class to store the 
 * pointer to the list of tests to present.
 * @author Joseph
 *
 */
public class Test_Data_Interface {
	private static Test_List list;
	
	public Test_Data_Interface() {}
	
	/**
	 * Takes list of file paths to test.csv files and creates a list
	 * of the tests for the GUI to access
	 * @param fp list of file paths to the files containing test information
	 * @return the number of tests for the GUI to present
	 */
	public static int retrieve_tests(ArrayList<String> fp) {
		//instantiate the list of tests
		list = new Test_List(fp);
		
		//return the number of tests being performed
		return list.getLength();
	}
	
	/**
	 * Plays sequence[id] from test[index]
	 * test[index] is the current position in the array of test pairs
	 * sequence[id] determines which of two sequences in a pair is played
	 * @param index: position in array of test pairs
	 * @param id: determinant for which sequence in the pair is played.
	 */
	public static void play_sequence(int index, int id) {
		Sequence tmp = list.getSequence(index, id);
		
		for(String path : tmp.get_all_clips()) {
			//Update this call to newer clip player.
			Clip_Player.playfile(path);
		}
	}
	
}
