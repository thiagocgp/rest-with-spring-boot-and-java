package com.thiagopereira.api.util;

public class Numbers {
	
	public static Double convertToDouble(String strNumber) {

		if(strNumber == null) return 0D;
		
		strNumber = strNumber.replaceAll(",", ".");
		
		if(isNumeric(strNumber)) {
			return Double.parseDouble(strNumber);
		}
		
		return 0D;
	}

	public static boolean isNumeric(String strNumber) {
		
		if(strNumber == null) return false;
		
		strNumber = strNumber.replaceAll(",", ".");
		
		return strNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
