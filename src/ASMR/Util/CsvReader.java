package ASMR.Util;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * This class reads a csv file and returns its lines stored as an array list.
 * @author starf
 *
 */
public class CsvReader {
	public static ArrayList<String> readFile(String filepath){	

 		ArrayList<String> lines = new ArrayList<String>();	
		File file = null;	
		Scanner sc = null;	

 		try {	
 			//open file path
			file = new File(filepath);	
			
			//get scanner
			sc = new Scanner(file);	
			
			//add each line to the array list of lines
			while(sc.hasNextLine()) {	
				lines.add(sc.nextLine());	
			}	
		} catch(Exception e) {	
			e.printStackTrace();	
		}	
		return lines;	

 	}
}
