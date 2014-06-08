package org.tstraszewski.taxes.report.writer;

public class StandardConsoleOutputWriter implements ReportWriter {

	@Override
	public void write(String s) {
		System.out.println(s);
	}

}
