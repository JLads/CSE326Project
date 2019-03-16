package ASMR.Data;
import ASMR.Util.*;

import java.io.File;
import java.util.ArrayList;

/**
 * This is a testing file for making sure code works.
 * It will not be present in the final deliverable
 * @author Joseph
 *
 */
public class sound_playback_test {
	
	
	public static void main(String[] args) {
		
		TestRetriever Link = new TestList();
		
		/*
		 * We need to automatically append the directory path to 
		 * the file path when referencing the .wav and .csv files 
		 */
		int size = Link.BuildList("TestFiles/practice.csv");
		
		System.out.println("there are " + size + " tests queued.");
		
		for(String fp : Link.getSequence(2, 2)) {
			ClipPlayer.playSoundFile(fp);
		}
		//How to call audio file clip player code
		//takes file path as a string argument
		ClipPlayer.playSoundFile("FP");
		ClipPlayer.playSoundFile("FP");
	}
	

}
