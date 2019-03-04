package ASMR.Data;

import java.io.File;
import java.util.ArrayList;

public class Test_List {
	private ArrayList<Test> tests;
	
	public Test_List(ArrayList<String> fp) {
		tests = new ArrayList<Test>();
		try {
			for(String path : fp) {
				File tmp = new File(path);
				Test trial = new Test(tmp);
				tests.add(trial);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Sequence getSequence(int index, int id) {
		if(id == 2) {
			return tests.get(index).getSecond();
		} else {
			return tests.get(index).getFirst();
		}
	}
	
	public String getName(int index) {
		return tests.get(index).getId();
	}
	
	public String getAns(int index) {
		return tests.get(index).getAnswer();
	}
	
	public int getLength() {
		return tests.size();
	}
}
