package org.tstraszewski.taxes.report;

public interface Reportable {
	
	public void accept(ContractVisitor cv);

}
