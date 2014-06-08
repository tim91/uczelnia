package org.tstraszewski.taxes.report;

import org.tstraszewski.taxes.contract.BaseContract;
import org.tstraszewski.taxes.contract.CasualWorkContract;
import org.tstraszewski.taxes.contract.EmploymentContract;

public class ConsoleOutputTaxReport extends TaxReportTemplate{

	public ConsoleOutputTaxReport(BaseContract c) {
		super(c);
	}

	@Override
	public void visit(EmploymentContract ec) {
	}

	@Override
	public void visit(CasualWorkContract cc) {
		// TODO Auto-generated method stub
	}

	@Override
	public void generateMainPart() {
		// TODO Auto-generated method stub
		
	}
}
