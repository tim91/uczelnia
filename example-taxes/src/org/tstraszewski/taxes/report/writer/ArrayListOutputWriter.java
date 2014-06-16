package org.tstraszewski.taxes.report.writer;

import java.util.ArrayList;
import java.util.List;

public class ArrayListOutputWriter implements ReportWriter {

	private List<String> outPut = new ArrayList<String>();
	
	@Override
	public void write(String s) {
		
		outPut.add(s);
	}
	
	public List<String> getResult(){
		return this.outPut;
	}

}
