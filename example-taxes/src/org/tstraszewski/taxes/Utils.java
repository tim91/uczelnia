package org.tstraszewski.taxes;

import java.text.DecimalFormat;

public class Utils {

	private static DecimalFormat twoPositionsFormatter = new DecimalFormat("#.00");
	private static DecimalFormat zeroPositionsFormatter = new DecimalFormat("#");
	
	public static String formatWithTwoPostions(double s){
		return twoPositionsFormatter.format(s);
	}
	
	public static String formatWithZeroPostions(double s){
		return zeroPositionsFormatter.format(s);
	}
	
}
