package org.tstraszewski.taxes.report;

import org.tstraszewski.taxes.contract.CasualWorkContract;
import org.tstraszewski.taxes.contract.EmploymentContract;

public interface ContractVisitor {

	public void visit(EmploymentContract ec);
	public void visit(CasualWorkContract cc);
}
