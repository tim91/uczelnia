package org.tstraszewski.taxes.contract;

import org.tstraszewski.taxes.Utils;
import org.tstraszewski.taxes.report.Reportable;

public abstract class BaseContract implements Reportable {

	protected String contractName = "";
	
	private double podstawa = 0;
	
	private double s_emerytalna = (1 * 9.76) / 100;
	private double s_rentowa = (1 * 1.5) / 100;
	private double u_chorobowe = (1 * 2.45) / 100;
	
	private  double s_zdrow1 = (1 * 9) / 100;
	private  double s_zdrow2 = (1 * 7.75) / 100;
	
	private double kosztyUzyskania = (1*20)/100;
	
	public void setPodstawa(double podstawa) {
		this.podstawa = podstawa;
	}
	
	public double getS_emerytalna() {
		return s_emerytalna *= podstawa;
	}


	public double getS_rentowa() {
		return s_rentowa *= podstawa;
	}


	public double getU_chorobowe() {
		return u_chorobowe *= podstawa;
	}
	
	public double getKosztyUzyskania() {
		return getObliczonaPodstawa() * kosztyUzyskania;
	}

	public double getPodstawa() {
		return podstawa;
	}

	public double getS_zdrow1() {
		return s_zdrow1 *= podstawa;
	}

	public double getS_zdrow2() {
		return s_zdrow2 *= podstawa;
	}

	public double getZaliczkaNaPod() {
		return (getPodstawaOpodatkowana0() *18 ) /100;
	}

	public double getZaliczkaUS() {
		return getZaliczkaNaPod() - getS_zdrow2() - TaxConstatns.kwotaZmiejsz;
	}
	
	public double getZaliczkaUS0() {
		return Double.parseDouble(Utils.formatWithZeroPostions(getZaliczkaUS()));
	}

	public String getContractName() {
		return contractName;
	}

	public double getObliczonaPodstawa() {
		return getPodstawa() - getS_emerytalna() - getS_rentowa() - getU_chorobowe();
	}

	public double getPodstawaOpodatkowana() {
		return getObliczonaPodstawa() - getKosztyUzyskania();
	}
	
	public double getPodstawaOpodatkowana0() {
		return Double.parseDouble(Utils.formatWithZeroPostions(getPodstawaOpodatkowana()));
	}
	
	public double getWynagordzenie() {
		return getPodstawa() - ((getS_emerytalna()+getS_rentowa()+getU_chorobowe()) + getS_zdrow1() + getZaliczkaUS0());
	}

	public abstract double getPodatekPotracony();
}
