package ASMR.Data;

import java.util.ArrayList;

/**
 * Facade for TestMaker class
 * Used by GUI to call test maker functions
 * @author Joseph
 *
 */
public interface CreateTestFiles {
	
	TestMaker tmake = new TestMaker(); //instance of TestMaker subclass instantiated at runtime
	
	/**
	 * Reset static Ivars
	 */
	public static void proxyClear() {
		tmake.clear();
	}
	
	/**
	 * Add a test object to the list of created tests
	 * @param dir directory path for the sequence files as a string
	 * @param seq1 array list of file name strings for first sequence
	 * @param seq2 array list of file name strings for second sequence
	 * @param ans boolean correct answer for test: true = "yes", false = "no"
	 */
	public static void proxyAddTest(String dir, ArrayList<String> seq1, ArrayList<String> seq2, boolean ans) {
		tmake.addTest(dir, seq1, seq2, ans);
	}
	
	/**
	 * formats test objects into strings for test file
	 * passes data to csv writer
	 * @param fname file path at which to save the test file
	 */
	public static void proxySaveTests(String fname) {
		tmake.saveTests(fname);
	}
	
}
