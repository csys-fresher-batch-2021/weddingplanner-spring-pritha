package in.pritha.service;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pritha.constants.MessageConstants;
import in.pritha.dao.UserDAO;
import in.pritha.dto.UserDTO;
import in.pritha.exception.InvalidUserIdException;
import in.pritha.exception.ServiceException;
import in.pritha.exception.ValidationException;
import in.pritha.model.User;
import in.pritha.repository.UserRepository;
import in.pritha.validator.UserValidator;

@Service
public class UserService {
	
	/**
	 * This metho used to register user.
	 * if user not existed already, it will let the user to register
	 * Or else it throw exception
	 * it calls the dao to add the new user details
	 * @param user
	 * @return true if registered
	 * @throws ServiceException
	 */
	@Autowired
	private  UserDAO userDAO;
	
	@Autowired
	private UserRepository userRepository;
	
	public boolean register(User user) throws ServiceException {
		boolean validUser = false;
		// validate it
		try {
			if (UserValidator.validateRegistrationDatas(user.getUserName(), user.getMobileNumber(), 
					user.getCreatePassWord(), user.getConfirmPassWord())){
				validUser = true;
				
				
				 UserDTO userdto =new
				 UserDTO(user.getUserName(),user.getCreatePassWord(),user.getMobileNumber(),
						 LocalDate.now(),MessageConstants.ACTIVE,MessageConstants.ROLE);
				 
				  System.out.println("user DTO"+ userdto); 
				   
				  userDAO.save(userdto);
				  
				  System.out.println("inserted finished in dao");
					 
				}
			 else {
				 throw new ServiceException("Given Registration Details are invalid");
			}
		}catch(ValidationException e) {
			e.getMessage();
			throw new ServiceException(e,"Given Registration Details are invalid");
			
		}
		return validUser;
	}

	
	public static boolean login(String userName, String passWord) throws ServiceException {
		boolean validUser = false;
		try {
			if(UserValidator.isExistingUser(userName,passWord)) {
				validUser= true;
			}else {
				throw new ServiceException("can't login for this username or password");
			}
		} catch (ValidationException e ) {
			e.printStackTrace();
			throw new ServiceException("can't login for this username or password");
			
		}
		return validUser;
	}


	public boolean removeUser(Integer userId) throws InvalidUserIdException {
		if(userId==1) {
			return true;
		}else {
			throw new InvalidUserIdException("Invalid user id");
		}
		
	}

}
