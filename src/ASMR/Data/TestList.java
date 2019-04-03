package ASMR.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import ASMR.Util.CsvReader;


/**
 * This class implements the functions of the retriever interface.
 * It also serves as a location to store the actual list of test objects
 * @author Joseph
 *
 */
public class TestList implements TestRetriever {

	//The list of test objects
	private static ArrayList<Test> tests;
	
	//--------------------------------------
	//adding this here for ease of use
	//- Nicholas Jones
	private static String filepath = ""; //path to test file
	
	/**
	 * returns the path of the test file
	 * @return the path of the test file
	 */
	public String getFilepath() {
		return filepath;
	}
	//--------------------------------------
	
	/**
	 * Initializes the object list on instantiation
	 */
	public TestList() {
		tests = new ArrayList<Test>();
	}
	
	@Override
	public int BuildList(String fp) {
		//Put calls to utility parser here

		//--------------------------------------
		//this too
		//- Nicholas Jones
		filepath = fp;
		//--------------------------------------

		//MyPasing for debug purpose
		
		ArrayList<String> lines = CsvReader.readFile(fp);
		
		for(int i = 0; i < lines.size(); i+=4) {
			tests.add(new Test(lines.get(i), lines.get(i+1), lines.get(i+2)));
		}
		
		return tests.size();
	}

	@Override
	public ArrayList<String> getSequence(int testnum, int seqID) {
		switch(seqID) {
		case 1:
			return tests.get(testnum).listFirst();
		case 2:
			return tests.get(testnum).listSecond();
		default:
			return tests.get(testnum).listFirst();
		}
	}

	@Override
	public String getAnswer(int testnum) {
		return tests.get(testnum).getAnswer();
	}

	@Override
	public int getListSize() {
		return tests.size();
	}

}
