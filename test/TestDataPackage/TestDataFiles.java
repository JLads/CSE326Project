package TestDataPackage;

import ASMR.Data.ResultLogger;
import ASMR.Data.TestRetriever;
import ASMR.Util.ClipPlayer;

/**
 * A test file for testing the TestRetrieval and TestLogger subsystem
 * @author nicholas, Joseph
 *
 */
public class TestDataFiles {
	
	/**
	 * play a specific file from an array of files
	 */
	public static void test_testRetriever(){
		
		int size = TestRetriever.proxyBuildList("TestFiles/practice.csv");
		
		System.out.println("there are " + size + " tests queued.");
		
		for(String fp : TestRetriever.proxyGetSequence(2, 2)) {
			ClipPlayer.playSoundFile(fp);
		}
	}
	
	/**
	 * Test the result logger logging functions
	 */
	public static void test_ResultLogger() {
		ResultLogger.proxySetFName("dummyname.csv");
		ResultLogger.proxyLogNo("no");
		ResultLogger.proxyLogYes("yes");
		ResultLogger.proxyLogYes("yes");
		ResultLogger.proxyLogNo("no");

		ResultLogger.proxySaveResults("Logs/testoutput.csv");
		System.out.println("File saved");
	}
	
	/**
	 * make sure point additions and subtractions log correctly
	 */
	public static void testPoints() {
		ResultLogger.proxyClear();
		ResultLogger.proxySetFName("TestDataFiles Sample");
		ResultLogger.proxyLogNo("no");
		System.out.println("points: " + ResultLogger.proxyGetPoints());
		ResultLogger.proxyLogNo("yes");
		System.out.println("points: " + ResultLogger.proxyGetPoints());
		ResultLogger.proxyLogYes("yes");
		System.out.println("points: " + ResultLogger.proxyGetPoints());
		ResultLogger.proxyLogYes("no");
		System.out.println("points: " + ResultLogger.proxyGetPoints());
		
		ResultLogger.proxySaveResults("Logs/testoutput.csv");
		
	}
	
	
	public static void main(String[] args) {
		testPoints();
	}
}
