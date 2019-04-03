package ASMR.Util;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class takes a file name and returns its lines in an array list of strings
 * Does NOT account for any lines of header information
 * @author Joseph
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
