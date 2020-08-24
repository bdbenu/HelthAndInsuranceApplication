
package com.helth.insurance.util;
public class PwdUtils {
	
	public static final String ALPHA_NUMERIC_STRING="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
	
	public static String generateTempPwd(int count) {
		StringBuilder builder = new StringBuilder();
		while(count-- != 0) {
			int character =(int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

}
