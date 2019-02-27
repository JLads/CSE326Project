package ASMR.Data;
import ASMR.Util.*;
import java.io.File;


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
		// TODO Auto-generated method stub
		
		//working on class structure for test files
		//instantiateTest();
		
		//How to call audio file clip player code
		//takes file path as a string argument
		Clip_Player.playfile("FP");
		Clip_Player.playfile("FP");
	}
	

}

