package x.stefan.screenplay.actions;

import java.util.Random;

public class helpFunctions {
	
	public static String generateRandomString(int stringLength) {
		  
	    int leftLimit = 97;
	    int rightLimit = 122; 
	    int targetStringLength = stringLength;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	 
	    return generatedString;
	}
	
	public static String generatePassword() {
	    final String specialChar = "!@#$%&*()_+-=[]?~";
	    
	    int specialCharSize = specialChar.length();
	    Random rd = new Random();
	    int iLength = 1;
	    StringBuilder sb = new StringBuilder(iLength);
	    for (int i = 0; i < iLength; i++) {
	        sb.append(specialChar.charAt(rd.nextInt(specialCharSize)));
	    }
	    String generatedCharString = sb.toString();
	    
	    String randomPassword = generateRandomString(5) + generateRandomString(2).toUpperCase() + generateRandomInteger(10,100) + generatedCharString;
	    
	    return randomPassword;
	}
	
	public static String generateRandomInteger(int min, int max) {

		Random randomGenerator = new Random(); 
		int randomInt = randomGenerator.nextInt((max - min) + 1) + min;  
	 
	    return Integer.toString(randomInt);
	}

}
