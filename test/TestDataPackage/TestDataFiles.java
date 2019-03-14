package TestDataPackage;

import ASMR.Data.*;
import ASMR.Util.Clip_Player;

public class TestDataFiles {

	
	public static void test_testRetriever(){
		TestRetriever Link = new TestList();
		
		/*
		 * We need to automatically append the directory path to 
		 * the file path when referencing the .wav and .csv files 
		 */
		int size = Link.BuildList("TestFiles/practice.csv");
		
		System.out.println("there are " + size + " tests queued.");
		
		for(String fp : Link.getSequence(2, 2)) {
			Clip_Player.playfile(fp);
		}
	}
	
	public static void test_ResultLogger() {
		ResultLogger RL = new TestLogger("dummyname.csv");
		RL.Log_No("no");
		RL.Log_Yes("yes");
		RL.Log_No("yes");
		RL.Log_Yes("no");
		//RL.printArray();
		RL.Save_Results("Logs/testoutput.csv");
		System.out.println("File saved");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test_ResultLogger();

	}

}
