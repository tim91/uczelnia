package org.tstraszewski.taxes.contract;

import org.tstraszewski.taxes.report.ContractVisitor;

public class EmploymentContract extends BaseContract{

	protected double kosztyUzyskania = 111.25;
	
	public EmploymentContract() {
		contractName = "UMOWA O PRACÄ�";
	}

	
	@Override
	public void accept(ContractVisitor cv) {
		cv.visit(this);
	}

	
	@Override
	public double getKosztyUzyskania() {
		return kosztyUzyskania;
	}

	@Override
	public double getPodatekPotracony() {
		// TODO Auto-generated method stub
		return getZaliczkaNaPod() - kwotaZmiejsz;
	}

}
