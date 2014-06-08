package org.tstraszewski.taxes.contract;

import org.tstraszewski.taxes.report.ContractVisitor;

public class CasualWorkContract extends BaseContract{

	public CasualWorkContract() {
		contractName = "UMOWA-ZLECENIE";
	}


	@Override
	public void accept(ContractVisitor cv) {
		cv.visit(this);
	}

}
