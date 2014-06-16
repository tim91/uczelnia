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
		if(this.contract != null){
			generateHeader();
			generateMainPart();
			//tutaj moglibysmy miec wiecej metod
		}else{
			this.reportWriter.write("Nieznany typ umowy!");
		}
		
	}
	
	
	public void generateHeader(){
		this.reportWriter.write(this.contract.getContractName());
	}
	
	public abstract void generateMainPart();
}
