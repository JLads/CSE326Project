package TestAnalysis;

import java.io.BufferedReader;
import java.io.IOException;

import ASMR.Analysis.DataAnalysis;

public class TestRScripts {

	public static void main(String[] args) throws IOException {
		
		String basePath = System.getProperty("user.dir");
		BufferedReader scoreResult = DataAnalysis.proxyRunScoreAnalysis(basePath + "/TestFiles/results.csv");
		
		for (String s = scoreResult.readLine(); s != null; s = scoreResult.readLine()) {
			System.out.println(s);
		}
	}
}
