package ASMR.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * This class implements the functions of the retriever interface.
 * It also serves as a location to store the actual list of test objects
 * @author Joseph
 *
 */
public class TestList implements TestRetriever {

	//The list of test objects
	private static ArrayList<Test> tests;
	
	/**
	 * Initializes the object list on instantiation
	 */
	public TestList() {
		tests = new ArrayList<Test>();
	}
	
	@Override
	public int BuildList(String fp) {
		//Put calls to utility parser here
		
		//MyPasing for debug purpose
		try {
			File tmp = new File(fp);
			Scanner sc = new Scanner(tmp);
			while(sc.hasNextLine()) {
				tests.add(new Test(sc.nextLine(), sc.nextLine(), sc.nextLine()));
				if(sc.hasNextLine()) {
					sc.nextLine();
				}
			}
			sc.close();
			
		} catch(Exception e) {
			e.printStackTrace();
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
