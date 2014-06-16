package org.tstraszewski.taxes;

import java.io.IOException;

import org.tstraszewski.taxes.contract.BaseContract;
import org.tstraszewski.taxes.contract.ContractFactory;
import org.tstraszewski.taxes.contract.ContractFactoryImpl;
import org.tstraszewski.taxes.report.StandardTaxReport;
import org.tstraszewski.taxes.report.writer.StandardConsoleOutputWriter;

public class MainTaxes {

	public static void main(String[] args) {
		UserDataGetter udg = new UserDataGetterImpl();
		try {
			double pod = udg.getPodstawa();
			char u = udg.getUmowa();
			
			ContractFactory cf = new ContractFactoryImpl();
			BaseContract bc = cf.createContract(u);
			bc.setPodstawa(pod);
			StandardTaxReport str = new StandardTaxReport(bc, new StandardConsoleOutputWriter());
			str.createReport();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
