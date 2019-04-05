package com.revature.util;

public class Utils {
	
	public static Integer parseInt(String str) {
		
		try {
			return Integer.parseInt(str);
		}
		catch (NumberFormatException exception) {
			return null;
		}
	}
	
	public static Short parseShort(String str) {
		
		try {
			return Short.parseShort(str);
		}
		catch (NumberFormatException exception) {
			return null;
		}
	}
}
