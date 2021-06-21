package in.pritha.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.pritha.constants.MessageConstants;
import in.pritha.exception.InvalidUserIdException;
import in.pritha.exception.ServiceException;
import in.pritha.message.Message;
import in.pritha.model.User;
import in.pritha.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/RegisterServlet")
	public ResponseEntity<?> register(User user) {
		logger.info("User Details: {}", user);
		try {
			if(userService.register(user)) {
				Message message = new Message();
				message.setInfoMessage("Succesfully Registered");
				return new ResponseEntity<>(message,HttpStatus.OK);
			}
			else {
				Message message = new Message();
				message.setErrorMessage("Invalid Details");
				return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
			}
		} catch (ServiceException e) {
			Message message = new Message();
			message.setErrorMessage("Invalid Details");
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	@PostMapping("/LoginServlet")
	public ResponseEntity<?>login(@RequestParam("userName")String userName,@RequestParam("passWord")String passWord) throws ServiceException {
		//1-set values to model
		User user = new User();
		user.setUserName(userName);
		user.setCreatePassWord(passWord);
		user.setRole(MessageConstants.ROLE);
		
		//user.setPassWord(passWord);
		//2-validate fields
		try {
				UserService.login(userName,passWord);
				/*
				 * Message message = new Message();
				 * message.setInfoMessage("Succesfully logged in");
				 */
				return new ResponseEntity<>(user,HttpStatus.OK);
			
		}
		catch(ServiceException e) {
				Message message = new Message();
				message.setErrorMessage("Username or password is incorrect");
				return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
			}
		
		}
	
	@PatchMapping("LogoutServlet")
	public boolean deleteEmployeeId(@RequestParam("userId") Integer userId) throws  InvalidUserIdException   {
		return userService.removeUser(userId);
	}	
		
	}

