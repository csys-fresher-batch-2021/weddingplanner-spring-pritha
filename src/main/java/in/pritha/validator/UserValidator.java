package in.pritha.validator;



import in.pritha.exception.ValidationException;


public class UserValidator {
	
	public static boolean isExistingUser(String userName , String passWord) throws ValidationException {
		boolean isValidUser=true;
		if(StringValidator.isValidString(userName) && PasswordValidator.isvalidPassWord(passWord)){
			
			isValidUser=true;
			
			
			}else {
				isValidUser=false;
				throw new ValidationException("userName or password is incorrect");
				
			}
		
		return isValidUser;
}

	public static boolean userNameValidator(String userName) throws ValidationException {
		boolean success = false;
		if(StringValidator.isValidString(userName)) {
			success = true;
		}
		else {
			throw new ValidationException("UserName is Incorrect");
		}
		return success;
	}

	public static boolean validateRegistrationDatas(String userName, Long mobileNumber, String createPassWord,
			String confirmPassWord) throws ValidationException {
		boolean success = true;
		if(!UserValidator.userNameValidator(userName)) {
			throw new ValidationException("UserName is Incorrect");
		}
		if(!UserValidator.mobileNumberValidator(mobileNumber)) {
			throw new ValidationException("Mobile number is Incorrect");
		}
		if(!UserValidator.createPassWordValidator(createPassWord)) {
			throw new ValidationException("Created PassWord is Incorrect");
		}
		if(!UserValidator.confirmPassWordValidator(createPassWord)) {
			throw new ValidationException("Created PassWord is Incorrect");
		}
		if(!UserValidator.passWordMatchedValidator(createPassWord,confirmPassWord)) {
			throw new ValidationException("Created and confirmed PassWord doesn't match");	
			
		}
		return success;
	}

	private static boolean passWordMatchedValidator(String createPassWord, String confirmPassWord) throws ValidationException {
		
			try {
				if(PasswordValidator.isMatchedPassword(createPassWord, confirmPassWord)) {
					return true;
				}
			} catch (ValidationException e) {
				e.getMessage();
				e.printStackTrace();
				throw new ValidationException(e,"password doesn't match");
			}
			return false;				
		
	}

	private static boolean confirmPassWordValidator(String confirmPassWord) throws ValidationException {
		boolean success = false;
		if(PasswordValidator.isvalidPassWord(confirmPassWord)) {
			success = true;
		}
		else {
			success = false;
			throw new ValidationException("Password is Incorrect");
		}
		return success;
		
	}

	private static boolean createPassWordValidator(String createPassWord) throws ValidationException {
		boolean success = false;
		if(PasswordValidator.isvalidPassWord(createPassWord)) {
			success = true;
		}else {
			success = false;
			throw new ValidationException("Password is Incorrect");
		}
		return success;
		
		
	}
	private static boolean mobileNumberValidator(Long mobileNumber) throws ValidationException {
		boolean success = false;
		if(MobileNumberValidator.isValidMobileNumber(mobileNumber)) {
			success = true;
		}
		else {
			success = false;
			throw new ValidationException("Mobile number is Incorrect");
		}
		return success;
		
	}

	
	
	
}
