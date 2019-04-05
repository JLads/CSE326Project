package ASMR.Util;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;


/**
 * This class takes an array list of strings and writes them to a file.
 * The lines must not have new line characters
 * @author starf
 *
 */
public class CsvWriter {
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
