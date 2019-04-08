package ASMR.Data;

import java.util.ArrayList;

/**
 * This class contains attributes and methods pertaining to stimuli sequences
 * @author Joseph
 *
 */
public class Sequence {

	private ArrayList<String> clips;	//array list of file paths for each sound clip
	
	/**
	 * default constructor, initializes with empty list of file paths
	 */
	public Sequence() {
		clips = new ArrayList<String>();
	}
	
	/**
	 * Constructor that takes a comma separated string of file paths
	 * @param fileList list of file paths to parse
	 */
	public Sequence(String fileList) {
		clips = new ArrayList<String>();
		for(String filePath : fileList.split(",")) {
			clips.add(filePath);
		}
	}
	
	/**
	 * adds a new file path to the list of file paths
	 * @param fp the new file path
	 */
	public void InsertClip(String fp) {
		clips.add(fp);
	}
	
	/**
	 * gets a file path at a given index in the list
	 * @param index the index of the list to retrieve from
	 * @return a string file path for an audio file
	 */
	public String GetClip(int index) {
		return clips.get(index);
	}
	
	/**
	 * returns the list of file paths
	 * @return the list of file paths
	 */
	public ArrayList<String> get_all_clips(){
		return this.clips;
	}
	
	/**
	 * prints the contents of the list
	 */
	public void printArray() {
		int i;
		for(i=0; i < clips.size(); i++) {
			System.out.print(clips.get(i) + " ");
			
		}
		System.out.println();
	}
}
