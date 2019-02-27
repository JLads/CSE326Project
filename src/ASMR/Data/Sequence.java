package ASMR.Data;

import java.util.ArrayList;

/**
 * This class contains attributes and methods pertaining to stimuli sequences
 * @author Joseph
 *
 */
public class Sequence {

	private ArrayList<String> clips; //array list of file paths for each sound clip
	public Sequence() {
		clips = new ArrayList<String>();
	}
	
	public void InsertClip(String fp) {
		clips.add(fp); //add passed in file path to the sound clip list
	}
	public String GetClip(int index) {
		return clips.get(index);
	}
	public void printArray() {
		int i;
		for(i=0; i < clips.size(); i++) {
			System.out.print(clips.get(i) + " ");
			
		}
		System.out.println();
	}
	
}
