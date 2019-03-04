package ASMR.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class will hold two objects of Sequence which are test sequences
 * A and B. It will also hold the String of "yes" or "no" for response comparison.
 * 
 * Test.csv files are formatted as follows
 * Sequence A
 * Sequence B
 * yes or no
 * 
 * @author Joseph Ladino
 *
 */



public class Test {
	
	private String id; //name of csv holding test information
	private String answer; //correct answer string from test.csv
	private Sequence first; //first sequence in test pair
	private Sequence second; //second sequence in test pair

	
	public Test(File file) { //takes file object and populates the test object
		try {
			Scanner sc = new Scanner(file);
			this.first = new Sequence();
			this.second = new Sequence();
			for(String fp : sc.nextLine().split(",")) {
				this.first.InsertClip(fp);
			}
			for(String fp : sc.nextLine().split(",")) {
				this.second.InsertClip(fp);
			}
			this.answer = sc.nextLine();
			//split into sequence lines and solution line
			//make two sequences from sequence lines
			
			sc.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		this.id = file.getName();
	}
	
	
	public String getId() {
		return this.id;
	}
	public String getAnswer() {
		return this.answer;
	}
	public Sequence getFirst() {
		return this.first;
	}
	public Sequence getSecond() {
		return this.second;
	}


}
