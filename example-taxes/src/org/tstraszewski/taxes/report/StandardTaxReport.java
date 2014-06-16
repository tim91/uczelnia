package org.tstraszewski.taxes.report;

import org.tstraszewski.taxes.Utils;
import org.tstraszewski.taxes.contract.BaseContract;
import org.tstraszewski.taxes.contract.CasualWorkContract;
import org.tstraszewski.taxes.contract.EmploymentContract;
import org.tstraszewski.taxes.contract.TaxConstatns;
import org.tstraszewski.taxes.report.writer.ReportWriter;
import org.tstraszewski.taxes.report.writer.StandardConsoleOutputWriter;

public class StandardTaxReport extends TaxReportTemplate{

	public StandardTaxReport(BaseContract c,ReportWriter rw) {
		super(c,rw);
	}

	@Override
	public void visit(EmploymentContract ec) {
		//wykorzystuje ta metode bo ta czesc jest taka sama
		generateFirstPart(ec);
		
		reportWriter.write("Koszty uzyskania przychodu w staĹ‚ej wysokoĹ›ci " + ec.getKosztyUzyskania());
//		generateSecondPart(ec);
		reportWriter.write("Podstawa opodatkowania " + ec.getPodstawaOpodatkowana() + " zaokrÄ…glona " + Utils.formatWithZeroPostions(ec.getPodstawaOpodatkowana0()));
		reportWriter.write("Zaliczka na podatek dochodowy 18 % = " + ec.getZaliczkaNaPod());
		reportWriter.write("Kwota wolna od podatku = " + ec.getKwotaZmiejsz());
		reportWriter.write("Podatek potrÄ…cony = " + Utils.formatWithTwoPostions(ec.getPodatekPotracony()));
		reportWriter.write("Zaliczka do urzÄ™du skarbowego = " + Utils.formatWithTwoPostions(ec.getZaliczkaUS()) + 
				" po zaokrÄ…gleniu = " + Utils.formatWithZeroPostions(ec.getZaliczkaUS0()));
		reportWriter.write("\n");
		reportWriter.write("Pracownik otrzyma wynagrodzenie netto w wysokoĹ›ci = " + Utils.formatWithTwoPostions(ec.getWynagordzenie()));
	}
	
	@Override
	public void visit(CasualWorkContract cc) {
		//wykorzystuje ta metode bo ta czesc jest taka sama
		generateFirstPart(cc);
		//TODO dalsza czesc raportu dla umowy zlecenie
		reportWriter.write("Koszty uzyskania przychodu (staĹ‚e) " + cc.getKosztyUzyskania());
//		generateSecondPart(cc);
		reportWriter.write("Podstawa opodatkowania " + cc.getPodstawaOpodatkowana() + " zaokrÄ…glona " + Utils.formatWithZeroPostions(cc.getPodstawaOpodatkowana0()));
		reportWriter.write("Zaliczka na podatek dochodowy 18 % = " + cc.getZaliczkaNaPod());
		reportWriter.write("Podatek potrÄ…cony = " + Utils.formatWithTwoPostions(cc.getPodatekPotracony()));
		reportWriter.write("Zaliczka do urzÄ™du skarbowego = " + Utils.formatWithTwoPostions(cc.getZaliczkaUS()) + 
				" po zaokrÄ…gleniu = " + Utils.formatWithZeroPostions(cc.getZaliczkaUS0()));
		reportWriter.write("\n");
		reportWriter.write("Pracownik otrzyma wynagrodzenie netto w wysokoĹ›ci = " + Utils.formatWithTwoPostions(cc.getWynagordzenie()));
	}
	
	private void generateFirstPart(BaseContract ec){
		reportWriter.write("Podstawa wymiaru skĹ‚adek " + ec.getPodstawa());
		reportWriter.write("SkĹ‚adka na ubezpieczenie emerytalne " + Utils.formatWithTwoPostions(ec.getS_emerytalna()));
		reportWriter.write("SkĹ‚adka na ubezpieczenie rentowe    " + Utils.formatWithTwoPostions(ec.getS_rentowa()));
		reportWriter.write("SkĹ‚adka na ubezpieczenie chorobowe  " + Utils.formatWithTwoPostions(ec.getU_chorobowe()));
		reportWriter.write("Podstawa wymiaru skĹ‚adki na ubezpieczenie zdrowotne: " + ec.getObliczonaPodstawa());
		reportWriter.write("SkĹ‚adka na ubezpieczenie zdrowotne: 9% = " + Utils.formatWithTwoPostions(ec.getS_zdrow1()) + " 7,75% = " + 
				Utils.formatWithTwoPostions(ec.getS_zdrow2()));
	}
	
//	private void generateSecondPart(BaseContract ec){
//		reportWriter.write("Podstawa opodatkowania " + ec.getPodstawaOpodatkowana() + " zaokrÄ…glona " + Utils.formatWithZeroPostions(ec.getPodstawaOpodatkowana0()));
//		reportWriter.write("Zaliczka na podatek dochodowy 18 % = " + ec.getZaliczkaNaPod());
//		reportWriter.write("Kwota wolna od podatku = " + TaxConstatns.kwotaZmiejsz);
//		reportWriter.write("Podatek potrÄ…cony = " + Utils.formatWithTwoPostions(ec.getPodatekPotracony()));
//		reportWriter.write("Zaliczka do urzÄ™du skarbowego = " + Utils.formatWithTwoPostions(ec.getZaliczkaUS()) + 
//				" po zaokrÄ…gleniu = " + Utils.formatWithZeroPostions(ec.getZaliczkaUS0()));
//		reportWriter.write("\n");
//		reportWriter.write("Pracownik otrzyma wynagrodzenie netto w wysokoĹ›ci = " + Utils.formatWithTwoPostions(ec.getWynagordzenie()));
//	}

	

	@Override
	public void generateMainPart() {
		contract.accept(this);
	}
	
	
}
