package TestAnalysis;

import ASMR.Analysis.RAnalysis;

/**
 * Test file for R data analysis methods.
 * @author Steven Anaya
 *
 */
public class TestAnalysis {

	public static void main(String[] args) {
		System.out.println(RAnalysis.getRScriptCommand());

		if (System.getProperty("os.name").toLowerCase().contains("win")) {
			RAnalysis.runRScript(System.getProperty("user.dir") + "\\test\\TestAnalysis\\test.r");
		} else {
			RAnalysis.runRScript(System.getProperty("user.dir") + "/test/TestAnalysis/test.r");
		}
	}

}
