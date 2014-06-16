package org.tstraszewski.taxes.contract;

import org.tstraszewski.taxes.Utils;
import org.tstraszewski.taxes.report.Reportable;

public abstract class BaseContract implements Reportable {

	protected String contractName = "";
	
	private double podstawa = 0;
	
	protected double s_emerytalna = 9.76 / 100.0;
	protected double s_rentowa = 1.5 / 100.0;
	protected double u_chorobowe = 2.45 / 100.0;
	protected double zaliczkaNaPod = 18.0 / 100.0;
	protected double s_zdrow1 = 9.0 / 100.0;
	protected double s_zdrow2 = 7.75 / 100.0;
	protected double kwotaZmiejsz = 46.33;
//	protected double kosztyUzyskania = 111.25;
	
//	protected double kosztyUzyskania = 20.0 / 100.0;
	
	public void setPodstawa(double podstawa) {
		this.podstawa = podstawa;
	}
	
	public double getS_emerytalna() {
		return s_emerytalna * podstawa;
	}


	public double getS_rentowa() {
		return s_rentowa * podstawa;
	}


	public double getU_chorobowe() {
		return u_chorobowe * podstawa;
	}
	
	public abstract double getKosztyUzyskania();

	public double getPodstawa() {
		return podstawa;
	}

	public double getS_zdrow1() {
		return s_zdrow1 * getObliczonaPodstawa();
	}

	public double getS_zdrow2() {
		return s_zdrow2 * getObliczonaPodstawa();
	}

	public double getZaliczkaNaPod() {
		return (getPodstawaOpodatkowana0()*18) / 100;
	}

	public double getKwotaZmiejsz() {
		return kwotaZmiejsz;
	}

	public double getZaliczkaUS() {
		return getZaliczkaNaPod() - getS_zdrow2() - kwotaZmiejsz;
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
