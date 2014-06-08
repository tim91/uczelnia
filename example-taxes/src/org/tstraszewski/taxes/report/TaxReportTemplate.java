package org.tstraszewski.taxes.report;

import org.tstraszewski.taxes.contract.BaseContract;

public abstract class TaxReportTemplate implements ContractVisitor {

	protected BaseContract contract = null;
	
	public TaxReportTemplate(BaseContract c){
		contract = c;
	}
	
	public void setContract(BaseContract contract) {
		this.contract = contract;
	}

	public final void createReport(){
		
//		outPut.add("UMOWA-ZLECENIE");
//		outPut.add("Podstawa wymiaru skĹ‚adek " + podstawa);
//		double oPodstawa = obliczonaPodstawa(podstawa);
//		outPut.add("SkĹ‚adka na ubezpieczenie emerytalne "
//				+ df00.format(s_emerytalna));
//		outPut.add("SkĹ‚adka na ubezpieczenie rentowe    "
//				+ df00.format(s_rentowa));
//		outPut.add("SkĹ‚adka na ubezpieczenie chorobowe  "
//				+ df00.format(u_chorobowe));
//		outPut.add("Podstawa wymiaru skĹ‚adki na ubezpieczenie zdrowotne: "
//						+ oPodstawa);
//		obliczUbezpieczenia(oPodstawa);
//		outPut.add("SkĹ‚adka na ubezpieczenie zdrowotne: 9% = ";
		generateHeader();
		generateMainPart();
	}
	
	
	public void generateHeader(){
		System.out.println(this.contract.getContractName());
	}
	
	public abstract void generateMainPart();
}
