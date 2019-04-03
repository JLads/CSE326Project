package ASMR.Util;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * This class will take an array list of strings and write out a csv file
 * @author starf
 *
 */
public class CsvWriter {
	public static void writeFile(ArrayList<String> lines, String filepath) {
		File file;
		FileWriter writer;
		
		try {
			file = new File(filepath);
			if(!file.exists()) {
				file.createNewFile();
			}
			
			writer = new FileWriter(file);
			
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
