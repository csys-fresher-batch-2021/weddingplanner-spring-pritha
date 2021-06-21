package in.pritha.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.pritha.exception.ValidationException;



public class PasswordValidator {
	public static boolean isvalidPassWord(String passWord) {
		// Regex to check valid password.
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

  
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
  
        // If the password is empty
        // return false
        if (passWord == null) {
            return false;
          
        }
        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(passWord);
  
        // Return if the password
        // matched the ReGex
        return m.matches();
	}
	public static boolean isMatchedPassword(String createPassword, String confirmPassword) throws ValidationException {
		boolean isEqual = false;
			if(createPassword.equals(confirmPassword)) {
			isEqual = true;
			}
			else {
				throw new ValidationException("password doesn't match");
			}
		
		
	return isEqual;
}


}
