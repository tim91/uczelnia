package org.tstraszewski.taxes.report;

import org.tstraszewski.taxes.contract.BaseContract;
import org.tstraszewski.taxes.report.writer.ReportWriter;

/**
 * Wzorzec template
 * @author TOMEK
 *
 */
public abstract class TaxReportTemplate implements ContractVisitor {

	protected BaseContract contract = null;
	protected ReportWriter reportWriter;
	
	public TaxReportTemplate(BaseContract c,ReportWriter rw){
		contract = c;
		reportWriter = rw;
	}
	
	public void setContract(BaseContract contract) {
		this.contract = contract;
	}

	public final void createReport(){
		generateHeader();
		generateMainPart();
		//tutaj moglibysmy miec wiecej metod
	}
	
	
	public void generateHeader(){
		System.out.println(this.contract.getContractName());
	}
	
	public abstract void generateMainPart();
}
