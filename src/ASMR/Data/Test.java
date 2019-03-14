package ASMR.Data;


import java.util.ArrayList;


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

	
	public Test(String _seqA, String _seqB, String _answer) {
		this.answer = _answer;
		this.first = new Sequence(_seqA);
		this.second = new Sequence(_seqB);
		
		System.out.print("a: ");
		first.printArray();
		System.out.print("b: ");
		second.printArray();
		System.out.println(answer);
		System.out.println();
	}
	
	public ArrayList<String> listFirst(){
		return first.get_all_clips();
	}
	public ArrayList<String> listSecond(){
		return second.get_all_clips();
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
