package com.bartoszwalter.students.taxes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TaxCalculator {
	
	public static double podstawa = 0;
	public static char umowa = ' ';
	// skĹ‚adki na ubezpieczenia spoĹ‚eczne
	public static double s_emerytalna = 0; // 9,76% podstawyy
	public static double s_rentowa = 0; // 1,5% podstawy
	public static double u_chorobowe = 0; // 2,45% podstawy
	// skĹ‚adki na ubezpieczenia zdrowotne
	public static double kosztyUzyskania = 111.25; 
	public static double s_zdrow1 = 0; // od podstawy wymiaru 9%
	public static double s_zdrow2 = 0; // od podstawy wymiaru 7,75 %
	public static double zaliczkaNaPod = 0; // zaliczka na podatek dochodowy 18%
	public static double kwotaZmiejsz = 46.33; // kwota zmienjszajÄ…ca podatek 46,33 PLN
	public static double zaliczkaUS = 0;
	public static double zaliczkaUS0 = 0;
	
	public static void reset(){
		podstawa = 0;
		umowa = ' ';
		s_emerytalna = 0;
		s_rentowa = 0;
		u_chorobowe = 0;
		kosztyUzyskania = 111.25;
		s_zdrow1 = 0;
		s_zdrow2 = 0;
		zaliczkaNaPod = 0;
		kwotaZmiejsz = 46.33;
		zaliczkaUS = 0;
		zaliczkaUS0 = 0;
	}
	
	public static void main(String[] args) {
		
		ArrayList<String> outPut = new ArrayList<String>();
		
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.print("Podaj kwotÄ™ dochodu: ");	
			podstawa = Double.parseDouble(br.readLine());
			
			System.out.print("Typ umowy: (P)raca, (Z)lecenie: ");
			umowa = br.readLine().charAt(0);
			
		} catch (Exception ex) {
			outPut.add("BĹ‚Ä™dna kwota");
			System.err.println(ex);
			return;
		}
		
		DecimalFormat df00 = new DecimalFormat("#.00");
		DecimalFormat df = new DecimalFormat("#");
		
		
		if (umowa == 'P') {
			outPut.add("UMOWA O PRACÄ�");
			outPut.add("Podstawa wymiaru skĹ‚adek " + podstawa);
			double oPodstawa = obliczonaPodstawa(podstawa);
			outPut.add("SkĹ‚adka na ubezpieczenie emerytalne "
					+ df00.format(s_emerytalna));
			outPut.add("SkĹ‚adka na ubezpieczenie rentowe    "
					+ df00.format(s_rentowa));
			outPut.add("SkĹ‚adka na ubezpieczenie chorobowe  "
					+ df00.format(u_chorobowe));
			outPut.add("Podstawa wymiaru skĹ‚adki na ubezpieczenie zdrowotne: "
							+ oPodstawa);
			obliczUbezpieczenia(oPodstawa);
			outPut.add("SkĹ‚adka na ubezpieczenie zdrowotne: 9% = "
					+ df00.format(s_zdrow1) + " 7,75% = " + df00.format(s_zdrow2));
			outPut.add( "Koszty uzyskania przychodu w staĹ‚ej wysokoĹ›ci "
					+ kosztyUzyskania);
			double podstawaOpodat = oPodstawa - kosztyUzyskania;
			double podstawaOpodat0 = Double
					.parseDouble(df.format(podstawaOpodat));
			outPut.add("Podstawa opodatkowania " + podstawaOpodat
					+ " zaokrÄ…glona " + df.format(podstawaOpodat0));
			obliczPodatek(podstawaOpodat0);
			outPut.add("Zaliczka na podatek dochodowy 18 % = "
					+ zaliczkaNaPod);
			outPut.add("Kwota wolna od podatku = " + kwotaZmiejsz);
			double podatekPotracony = zaliczkaNaPod - kwotaZmiejsz;
			outPut.add("Podatek potrÄ…cony = "
					+ df00.format(podatekPotracony));
			obliczZaliczke();
			zaliczkaUS0 = Double.parseDouble(df.format(zaliczkaUS));
			outPut.add("Zaliczka do urzÄ™du skarbowego = "
					+ df00.format(zaliczkaUS) + " po zaokrÄ…gleniu = "
					+ df.format(zaliczkaUS0));
			double wynagrodzenie = podstawa
					- ((s_emerytalna + s_rentowa + u_chorobowe) + s_zdrow1 + zaliczkaUS0);
			outPut.add("\n");
			outPut.add("Pracownik otrzyma wynagrodzenie netto w wysokoĹ›ci = "
							+ df00.format(wynagrodzenie));
		} else if (umowa == 'Z') {
			outPut.add("UMOWA-ZLECENIE");
			outPut.add("Podstawa wymiaru skĹ‚adek " + podstawa);
			double oPodstawa = obliczonaPodstawa(podstawa);
			outPut.add("SkĹ‚adka na ubezpieczenie emerytalne "
					+ df00.format(s_emerytalna));
			outPut.add("SkĹ‚adka na ubezpieczenie rentowe    "
					+ df00.format(s_rentowa));
			outPut.add("SkĹ‚adka na ubezpieczenie chorobowe  "
					+ df00.format(u_chorobowe));
			outPut.add("Podstawa wymiaru skĹ‚adki na ubezpieczenie zdrowotne: "
							+ oPodstawa);
			obliczUbezpieczenia(oPodstawa);
			outPut.add("SkĹ‚adka na ubezpieczenie zdrowotne: 9% = "
					+ df00.format(s_zdrow1) + " 7,75% = " + df00.format(s_zdrow2));
			//////////////////////////////////////////////////////
			kwotaZmiejsz = 0;
			kosztyUzyskania = (oPodstawa * 20) / 100;
			outPut.add("Koszty uzyskania przychodu (staĹ‚e) "
					+ kosztyUzyskania);
			double podstawaOpodat = oPodstawa - kosztyUzyskania;
			double podstawaOpodat0 = Double.parseDouble(df.format(podstawaOpodat));
			outPut.add("Podstawa opodatkowania " + podstawaOpodat
					+ " zaokrÄ…glona " + df.format(podstawaOpodat0));
			obliczPodatek(podstawaOpodat0);
			outPut.add("Zaliczka na podatek dochodowy 18 % = "
					+ zaliczkaNaPod);
			double podatekPotracony = zaliczkaNaPod;
			outPut.add("Podatek potrÄ…cony = "
					+ df00.format(podatekPotracony));
			obliczZaliczke();
			zaliczkaUS0 = Double.parseDouble(df.format(zaliczkaUS));
			outPut.add("Zaliczka do urzÄ™du skarbowego = "
					+ df00.format(zaliczkaUS) + " po zaokrÄ…gleniu = "
					+ df.format(zaliczkaUS0));
			double wynagrodzenie = podstawa
					- ((s_emerytalna + s_rentowa + u_chorobowe) + s_zdrow1 + zaliczkaUS0);
			outPut.add("\n");
			outPut.add("Pracownik otrzyma wynagrodzenie netto w wysokoĹ›ci = "
							+ df00.format(wynagrodzenie));
			
		} else {
			outPut.add("Nieznany typ umowy!");
		}
		
		for (String string : outPut) {
			System.out.println(string);
		}
	}

	
public static List<String> getArrayWithResults(double kwota,char typ){
		
	DecimalFormat df00 = new DecimalFormat("#.00");
	DecimalFormat df = new DecimalFormat("#");
	
	podstawa = kwota;
	umowa = typ;
	
	ArrayList<String> outPut = new ArrayList<String>();
	
	if (umowa == 'P') {
		outPut.add("UMOWA O PRACÄ�");
		outPut.add("Podstawa wymiaru skĹ‚adek " + podstawa);
		double oPodstawa = obliczonaPodstawa(podstawa);
		outPut.add("SkĹ‚adka na ubezpieczenie emerytalne "
				+ df00.format(s_emerytalna));
		outPut.add("SkĹ‚adka na ubezpieczenie rentowe    "
				+ df00.format(s_rentowa));
		outPut.add("SkĹ‚adka na ubezpieczenie chorobowe  "
				+ df00.format(u_chorobowe));
		outPut.add("Podstawa wymiaru skĹ‚adki na ubezpieczenie zdrowotne: "
						+ oPodstawa);
		obliczUbezpieczenia(oPodstawa);
		outPut.add("SkĹ‚adka na ubezpieczenie zdrowotne: 9% = "
				+ df00.format(s_zdrow1) + " 7,75% = " + df00.format(s_zdrow2));
		outPut.add( "Koszty uzyskania przychodu w staĹ‚ej wysokoĹ›ci "
				+ kosztyUzyskania);
		double podstawaOpodat = oPodstawa - kosztyUzyskania;
		double podstawaOpodat0 = Double
				.parseDouble(df.format(podstawaOpodat));
		outPut.add("Podstawa opodatkowania " + podstawaOpodat
				+ " zaokrÄ…glona " + df.format(podstawaOpodat0));
		obliczPodatek(podstawaOpodat0);
		outPut.add("Zaliczka na podatek dochodowy 18 % = "
				+ zaliczkaNaPod);
		outPut.add("Kwota wolna od podatku = " + kwotaZmiejsz);
		double podatekPotracony = zaliczkaNaPod - kwotaZmiejsz;
		outPut.add("Podatek potrÄ…cony = "
				+ df00.format(podatekPotracony));
		obliczZaliczke();
		zaliczkaUS0 = Double.parseDouble(df.format(zaliczkaUS));
		outPut.add("Zaliczka do urzÄ™du skarbowego = "
				+ df00.format(zaliczkaUS) + " po zaokrÄ…gleniu = "
				+ df.format(zaliczkaUS0));
		double wynagrodzenie = podstawa
				- ((s_emerytalna + s_rentowa + u_chorobowe) + s_zdrow1 + zaliczkaUS0);
		outPut.add("\n");
		outPut.add("Pracownik otrzyma wynagrodzenie netto w wysokoĹ›ci = "
						+ df00.format(wynagrodzenie));
	} else if (umowa == 'Z') {
		outPut.add("UMOWA-ZLECENIE");
		outPut.add("Podstawa wymiaru skĹ‚adek " + podstawa);
		double oPodstawa = obliczonaPodstawa(podstawa);
		outPut.add("SkĹ‚adka na ubezpieczenie emerytalne "
				+ df00.format(s_emerytalna));
		outPut.add("SkĹ‚adka na ubezpieczenie rentowe    "
				+ df00.format(s_rentowa));
		outPut.add("SkĹ‚adka na ubezpieczenie chorobowe  "
				+ df00.format(u_chorobowe));
		outPut.add("Podstawa wymiaru skĹ‚adki na ubezpieczenie zdrowotne: "
						+ oPodstawa);
		obliczUbezpieczenia(oPodstawa);
		outPut.add("SkĹ‚adka na ubezpieczenie zdrowotne: 9% = "
				+ df00.format(s_zdrow1) + " 7,75% = " + df00.format(s_zdrow2));
		kwotaZmiejsz = 0;
		kosztyUzyskania = (oPodstawa * 20) / 100;
		outPut.add("Koszty uzyskania przychodu (staĹ‚e) "
				+ kosztyUzyskania);
		double podstawaOpodat = oPodstawa - kosztyUzyskania;
		double podstawaOpodat0 = Double.parseDouble(df.format(podstawaOpodat));
		outPut.add("Podstawa opodatkowania " + podstawaOpodat
				+ " zaokrÄ…glona " + df.format(podstawaOpodat0));
		obliczPodatek(podstawaOpodat0);
		outPut.add("Zaliczka na podatek dochodowy 18 % = "
				+ zaliczkaNaPod);
		double podatekPotracony = zaliczkaNaPod;
		outPut.add("Podatek potrÄ…cony = "
				+ df00.format(podatekPotracony));
		obliczZaliczke();
		zaliczkaUS0 = Double.parseDouble(df.format(zaliczkaUS));
		outPut.add("Zaliczka do urzÄ™du skarbowego = "
				+ df00.format(zaliczkaUS) + " po zaokrÄ…gleniu = "
				+ df.format(zaliczkaUS0));
		double wynagrodzenie = podstawa
				- ((s_emerytalna + s_rentowa + u_chorobowe) + s_zdrow1 + zaliczkaUS0);
		outPut.add("\n");
		outPut.add("Pracownik otrzyma wynagrodzenie netto w wysokoĹ›ci = "
						+ df00.format(wynagrodzenie));
		
	} else {
		outPut.add("Nieznany typ umowy!");
	}
	reset();
	return outPut;
	}
	
	
	public static List<String> getArrayWithResultsUsingOriginalAlgorithm(double kwota,char typ){
		
		DecimalFormat df00 = new DecimalFormat("#.00");
		DecimalFormat df = new DecimalFormat("#");
		
		podstawa = kwota;
		umowa = typ;
		
		ArrayList<String> outPut = new ArrayList<String>();
		
		if (umowa == 'P') {
			outPut.add("UMOWA O PRACÄ�");
			outPut.add("Podstawa wymiaru skĹ‚adek " + podstawa);
			double oPodstawa = obliczonaPodstawa(podstawa);
			outPut.add("SkĹ‚adka na ubezpieczenie emerytalne "
					+ df00.format(s_emerytalna));
			outPut.add("SkĹ‚adka na ubezpieczenie rentowe    "
					+ df00.format(s_rentowa));
			outPut.add("SkĹ‚adka na ubezpieczenie chorobowe  "
					+ df00.format(u_chorobowe));
			outPut.add("Podstawa wymiaru skĹ‚adki na ubezpieczenie zdrowotne: "
							+ oPodstawa);
			obliczUbezpieczenia(oPodstawa);
			outPut.add("SkĹ‚adka na ubezpieczenie zdrowotne: 9% = "
					+ df00.format(s_zdrow1) + " 7,75% = " + df00.format(s_zdrow2));
			outPut.add( "Koszty uzyskania przychodu w staĹ‚ej wysokoĹ›ci "
					+ kosztyUzyskania);
			double podstawaOpodat = oPodstawa - kosztyUzyskania;
			double podstawaOpodat0 = Double
					.parseDouble(df.format(podstawaOpodat));
			outPut.add("Podstawa opodatkowania " + podstawaOpodat
					+ " zaokrÄ…glona " + df.format(podstawaOpodat0));
			obliczPodatek(podstawaOpodat0);
			outPut.add("Zaliczka na podatek dochodowy 18 % = "
					+ zaliczkaNaPod);
			outPut.add("Kwota wolna od podatku = " + kwotaZmiejsz);
			double podatekPotracony = zaliczkaNaPod - kwotaZmiejsz;
			outPut.add("Podatek potrÄ…cony = "
					+ df00.format(podatekPotracony));
			obliczZaliczke();
			zaliczkaUS0 = Double.parseDouble(df.format(zaliczkaUS));
			outPut.add("Zaliczka do urzÄ™du skarbowego = "
					+ df00.format(zaliczkaUS) + " po zaokrÄ…gleniu = "
					+ df.format(zaliczkaUS0));
			double wynagrodzenie = podstawa
					- ((s_emerytalna + s_rentowa + u_chorobowe) + s_zdrow1 + zaliczkaUS0);
			outPut.add("\n");
			outPut.add("Pracownik otrzyma wynagrodzenie netto w wysokoĹ›ci = "
							+ df00.format(wynagrodzenie));
		} else if (umowa == 'Z') {
			outPut.add("UMOWA-ZLECENIE");
			outPut.add("Podstawa wymiaru skĹ‚adek " + podstawa);
			double oPodstawa = obliczonaPodstawa(podstawa);
			outPut.add("SkĹ‚adka na ubezpieczenie emerytalne "
					+ df00.format(s_emerytalna));
			outPut.add("SkĹ‚adka na ubezpieczenie rentowe    "
					+ df00.format(s_rentowa));
			outPut.add("SkĹ‚adka na ubezpieczenie chorobowe  "
					+ df00.format(u_chorobowe));
			outPut.add("Podstawa wymiaru skĹ‚adki na ubezpieczenie zdrowotne: "
							+ oPodstawa);
			obliczUbezpieczenia(oPodstawa);
			outPut.add("SkĹ‚adka na ubezpieczenie zdrowotne: 9% = "
					+ df00.format(s_zdrow1) + " 7,75% = " + df00.format(s_zdrow2));
			kwotaZmiejsz = 0;
			kosztyUzyskania = (oPodstawa * 20) / 100;
			outPut.add("Koszty uzyskania przychodu (staĹ‚e) "
					+ kosztyUzyskania);
			double podstawaOpodat = oPodstawa - kosztyUzyskania;
			double podstawaOpodat0 = Double.parseDouble(df.format(podstawaOpodat));
			outPut.add("Podstawa opodatkowania " + podstawaOpodat
					+ " zaokrÄ…glona " + df.format(podstawaOpodat0));
			obliczPodatek(podstawaOpodat0);
			outPut.add("Zaliczka na podatek dochodowy 18 % = "
					+ zaliczkaNaPod);
			double podatekPotracony = zaliczkaNaPod;
			outPut.add("Podatek potrÄ…cony = "
					+ df00.format(podatekPotracony));
			obliczZaliczke();
			zaliczkaUS0 = Double.parseDouble(df.format(zaliczkaUS));
			outPut.add("Zaliczka do urzÄ™du skarbowego = "
					+ df00.format(zaliczkaUS) + " po zaokrÄ…gleniu = "
					+ df.format(zaliczkaUS0));
			double wynagrodzenie = podstawa
					- ((s_emerytalna + s_rentowa + u_chorobowe) + s_zdrow1 + zaliczkaUS0);
			outPut.add("\n");
			outPut.add("Pracownik otrzyma wynagrodzenie netto w wysokoĹ›ci = "
							+ df00.format(wynagrodzenie));
			
		} else {
			outPut.add("Nieznany typ umowy!");
		}
		reset();
		return outPut;
	}
	
	
	public static void obliczZaliczke() {
		zaliczkaUS = zaliczkaNaPod - s_zdrow2 - kwotaZmiejsz;
	}

	public static void obliczPodatek(double podstawa) {
		zaliczkaNaPod = (podstawa * 18) / 100;
	}

	public static double obliczonaPodstawa(double podstawa) {
		s_emerytalna = (podstawa * 9.76) / 100;
		s_rentowa = (podstawa * 1.5) / 100;
		u_chorobowe = (podstawa * 2.45) / 100;
		return (podstawa - s_emerytalna - s_rentowa - u_chorobowe);
	}

	public static void obliczUbezpieczenia(double podstawa) {
		s_zdrow1 = (podstawa * 9) / 100;
		s_zdrow2 = (podstawa * 7.75) / 100;
	}
}
