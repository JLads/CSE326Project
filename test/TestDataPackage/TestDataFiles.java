package TestDataPackage;

import ASMR.Data.ResultLogger;
import ASMR.Data.TestRetriever;
import ASMR.Util.ClipPlayer;

/**
 * A test file for testing the TestRetrieval and TestLogger subsystem
 * @author nicholas
 *
 */
public class TestDataFiles {
	
	public static void test_testRetriever(){
		
		/*
		 * We need to automatically append the directory path to 
		 * the file path when referencing the .wav and .csv files 
		 */
		int size = TestRetriever.proxyBuildList("TestFiles/practice.csv");
		
		System.out.println("there are " + size + " tests queued.");
		
		for(String fp : TestRetriever.proxyGetSequence(2, 2)) {
			ClipPlayer.playSoundFile(fp);
		}
	}
	
	public static void test_ResultLogger() {
		ResultLogger.proxySetFName("dummyname.csv");
		ResultLogger.proxyLogNo("no");
		ResultLogger.proxyLogYes("yes");
		ResultLogger.proxyLogYes("yes");
		ResultLogger.proxyLogNo("no");

		ResultLogger.proxySaveResults("Logs/testoutput.csv");
		System.out.println("File saved");
	}
	
	
	public static void main(String[] args) {
		test_ResultLogger();
	}
}
