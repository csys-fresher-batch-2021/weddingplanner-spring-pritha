package in.pritha.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileNumberValidator {
	public static boolean isValidMobileNumber(Long mobileNumber) {
		 // The given argument to compile() method
	    // is regular expression. With the help of
	    // regular expression we can validate mobile
	    // number.
	    // 1) Then contains 7 or 8 or 9.
	    // 2) Then contains 10 digits
	    Pattern p = Pattern.compile("(0|91)?[7-9][0-9]{9}");
	 
	    // Pattern class contains matcher() method
	    // to find matching between given number
	    // and regular expression
	    String mobileNumberStr = Long.toString(mobileNumber);
	    Matcher m = p.matcher(mobileNumberStr);
	    return (m.find() && m.group().equals(mobileNumberStr));
		
	}

}
