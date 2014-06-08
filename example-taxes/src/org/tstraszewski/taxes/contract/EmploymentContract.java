package org.tstraszewski.taxes.contract;

import org.tstraszewski.taxes.report.ContractVisitor;

public class EmploymentContract extends BaseContract{

	public EmploymentContract() {
		contractName = "UMOWA O PRACÄ�";
	}

	
	@Override
	public void accept(ContractVisitor cv) {
		cv.visit(this);
	}

}
