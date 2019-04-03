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
			file = new File(filepath);	
			sc = new Scanner(file);	
			while(sc.hasNextLine()) {	
				lines.add(sc.nextLine());	
			}	
		} catch(Exception e) {	
			e.printStackTrace();	
		}	
		return lines;	

 	}
}
