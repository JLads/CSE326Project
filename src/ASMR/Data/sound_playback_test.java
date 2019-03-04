package ASMR.Data;
import ASMR.Util.*;

import java.io.File;
import java.util.ArrayList;


public class sound_playback_test {
	
	public static void instantiateTest() {
		try{
			File practiceTest = new File("practice.csv");
			
			Test trial = new Test(practiceTest);
			
			trial.getFirst().printArray();
			System.out.println();
			trial.getSecond().printArray();
			System.out.println();
			System.out.println(trial.getAnswer());
			System.out.println();
			System.out.println(trial.getId());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		
		
		ArrayList<String> practice = new ArrayList<String>();
		practice.add("practice.csv");
		practice.add("practice.csv");
		practice.add("practice.csv");
		
		Test_Data_Interface trial = new Test_Data_Interface();
		System.out.println(Test_Data_Interface.retrieve_tests(practice));
		
		Test_Data_Interface.play_sequence(0, 1);
	}
	

}

