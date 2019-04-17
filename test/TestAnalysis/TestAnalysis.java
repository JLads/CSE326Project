package TestAnalysis;

import java.io.BufferedReader;
import java.io.IOException;

import ASMR.Analysis.RAnalysis;

/**
 * Test file for R data analysis methods.
 * @author Steven Anaya
 *
 */
public class TestAnalysis {

	public static void main(String[] args) {
		System.out.println(RAnalysis.getRScriptCommand());
		BufferedReader br;
		String s;

		if (System.getProperty("os.name").toLowerCase().contains("win")) {
			br = RAnalysis.runRScript(System.getProperty("user.dir") + "\\test\\TestAnalysis\\sampleRcode201702.r");
		} else {
			br = RAnalysis.runRScript(System.getProperty("user.dir") + "/test/TestAnalysis/sampleRcode201702.r");
		}
		
		try {
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
