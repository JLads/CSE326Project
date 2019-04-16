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
	private String dir;			//directory path for files in this test
	private String id; 			//name of csv holding test information
	private String answer; 		//correct answer string from test.csv
	private Sequence first; 	//first sequence in test pair
	private Sequence second;	//second sequence in test pair

	/**
	 * default constructor
	 * Separates comma separated lines into individual file names
	 * @param _seqA the first sequence of the test
	 * @param _seqB the second sequence of the test
	 * @param _answer the correct answer for the test
	 */
	public Test(String _dir, String _seqA, String _seqB, String _answer) {
		this.answer = _answer;
		this.dir = _dir;
		this.first = new Sequence();
		this.second = new Sequence();
		for(String filePath : _seqA.split(",")) {
			first.InsertClip(filePath);
		}
		for(String filePath : _seqB.split(",")) {
			second.InsertClip(filePath);
		}
	}
	
	/**
	 * constructor that uses array lists of clip files instead of
	 * comma separated lines
	 * @param seqA first sequence of the test as an array list of strings
	 * @param seqB second sequence of the test as an array list of strings
	 * @param ans correct response for the test
	 */
	public Test(String _dir, ArrayList<String> seqA, ArrayList<String> seqB, String ans) {
		this.answer = ans;
		this.dir = _dir;
		this.first = new Sequence();
		this.second = new Sequence();
		for (String fp:seqA) {
			first.InsertClip(fp);
		}
		for (String fp:seqB) {
			second.InsertClip(fp);
		}
	}
	
	/**
	 * prints the contents of the test to the terminal
	 */
	public void printTest() {
		System.out.print("a: ");
		first.printArray();
		System.out.print("b: ");
		second.printArray();
		System.out.println(answer);
		System.out.println();
	}
	
	/**
	 * returns an Array List of file names of audio files in the first sequence
	 * @return an Array List of file names of audio files in the first sequence
	 */
	public ArrayList<String> listFirst(){
		return first.get_all_clips();
	}
	
	/**
	 * returns an Array List of file names of audio files in the second sequence
	 * @return an Array List of file names of audio files in the second sequence
	 */
	public ArrayList<String> listSecond(){
		return second.get_all_clips();
	}
	
	/**
	 * returns name of this test
	 * @return name of this test
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * returns the correct answer for this test
	 * @return the correct answer for this test
	 */
	public String getAnswer() {
		return this.answer;
	}
	
	/**
	 * returns the first sequence of the test
	 * @return the first sequence of the test
	 */
	public Sequence getFirst() {
		return this.first;
	}
	
	/**
	 * returns the second sequence of the test
	 * @return the second sequence of the test
	 */
	public Sequence getSecond() {
		return this.second;
	}
	
	/**
	 * Returns the directory path for the files in test
	 * @return directory path as a string
	 */
	public String getDir() {
		return this.dir;
	}
}
