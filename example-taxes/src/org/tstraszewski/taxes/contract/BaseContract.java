package org.tstraszewski.taxes.contract;

import org.tstraszewski.taxes.report.Reportable;

public abstract class BaseContract implements Reportable {

	protected String contractName = "";
	
	private double podstawa = 0;
	
	private double s_emerytalna = (1 * 9.76) / 100;
	private double s_rentowa = (1 * 1.5) / 100;
	private double u_chorobowe = (1 * 2.45) / 100;
	
	private  double s_zdrow1 = 0; // od podstawy wymiaru 9%
	private  double s_zdrow2 = 0; // od podstawy wymiaru 7,75 %
	private  double zaliczkaNaPod = 0; // zaliczka na podatek dochodowy 18%
	private  double zaliczkaUS = 0;
	private  double zaliczkaUS0 = 0;
	
	public void setPodstawa(double podstawa) {
		this.podstawa = podstawa;
		init(this.podstawa);
	}

	private void init(double p){
		s_emerytalna *= podstawa;
		s_rentowa *= podstawa;
		u_chorobowe *= podstawa;
	}
	
	public double getS_emerytalna() {
		return s_emerytalna;
	}


	public double getS_rentowa() {
		return s_rentowa;
	}


	public double getU_chorobowe() {
		return u_chorobowe;
	}

	
	
	public double getPodstawa() {
		return podstawa;
	}

	public double getS_zdrow1() {
		return s_zdrow1;
	}

	public double getS_zdrow2() {
		return s_zdrow2;
	}

	public double getZaliczkaNaPod() {
		return zaliczkaNaPod;
	}

	public double getZaliczkaUS() {
		return zaliczkaUS;
	}

	public double getZaliczkaUS0() {
		return zaliczkaUS0;
	}

	public String getContractName() {
		return contractName;
	}
}
