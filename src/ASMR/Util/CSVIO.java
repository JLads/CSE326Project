package ASMR.Util;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVIO {
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
	
	public static void writeFile(ArrayList<String> lines, String filepath) {	
		File file;	
		FileWriter writer;	

 		try {	
 			//open file
			file = new File(filepath);	
			if(!file.exists()) {	
				//create file if it doesn't exist
				file.createNewFile();	
			}	

			//create write for the file
 			writer = new FileWriter(file);	

 			//write out lines from arraylist passed in
 			for(String line : lines) {	
				writer.append(line);	
				writer.append(System.getProperty("line.separator"));	
			}	

 			writer.close();	
		} catch (Exception e) {	
			e.printStackTrace();	
		}	
	}
}
