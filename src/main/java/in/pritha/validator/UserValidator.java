package in.pritha.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.pritha.exception.ValidationException;
import in.pritha.service.UserService;

@Component
public class UserValidator {

	@Autowired
	private UserService userService;

	public boolean isExistingUser(String userName, String passWord) throws ValidationException {
		boolean loggedInUser = false;

		if (StringValidator.isValidString(userName) && PasswordValidator.isvalidPassWord(passWord)) {
			loggedInUser = true;

		}

		else {
			loggedInUser = false;
			throw new ValidationException("You're not an existing user!");

		}

		return loggedInUser;
	}

	public static boolean userNameValidator(String userName) throws ValidationException {
		boolean success = false;
		if (StringValidator.isValidString(userName)) {
			success = true;
		} else {
			throw new ValidationException("UserName is Incorrect");
		}
		return success;
	}

	public static boolean validateRegistrationDatas(String userName, Long mobileNumber, String createPassWord,
			String confirmPassWord) throws ValidationException {
		boolean success = true;
		if (!UserValidator.userNameValidator(userName)) {
			throw new ValidationException("UserName is Incorrect");
		}
		if (!UserValidator.mobileNumberValidator(mobileNumber)) {
			throw new ValidationException("Mobile number is Incorrect");
		}
		if (!UserValidator.createPassWordValidator(createPassWord)) {
			throw new ValidationException("Created PassWord is Incorrect");
		}
		if (!UserValidator.confirmPassWordValidator(createPassWord)) {
			throw new ValidationException("Created PassWord is Incorrect");
		}
		if (!UserValidator.passWordMatchedValidator(createPassWord, confirmPassWord)) {
			throw new ValidationException("Created and confirmed PassWord doesn't match");

		}
		return success;
	}

	private static boolean passWordMatchedValidator(String createPassWord, String confirmPassWord)
			throws ValidationException {

		try {
			if (PasswordValidator.isMatchedPassword(createPassWord, confirmPassWord)) {
				return true;
			}
		} catch (ValidationException e) {
			e.getMessage();
			e.printStackTrace();
			throw new ValidationException(e, "password doesn't match");
		}
		return false;

	}

	private static boolean confirmPassWordValidator(String confirmPassWord) throws ValidationException {
		boolean success = false;
		if (PasswordValidator.isvalidPassWord(confirmPassWord)) {
			success = true;
		} else {
			success = false;
			throw new ValidationException("Password is Incorrect");
		}
		return success;

	}

	private static boolean createPassWordValidator(String createPassWord) throws ValidationException {
		boolean success = false;
		if (PasswordValidator.isvalidPassWord(createPassWord)) {
			success = true;
		} else {
			success = false;
			throw new ValidationException("Password is Incorrect");
		}
		return success;

	}

	private static boolean mobileNumberValidator(Long mobileNumber) throws ValidationException {
		boolean success = false;
		if (MobileNumberValidator.isValidMobileNumber(mobileNumber)) {
			success = true;
		} else {
			success = false;
			throw new ValidationException("Mobile number is Incorrect");
		}
		return success;

	}

}
