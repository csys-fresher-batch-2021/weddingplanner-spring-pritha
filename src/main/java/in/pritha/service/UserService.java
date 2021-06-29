package in.pritha.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import in.pritha.constants.MessageConstants;
import in.pritha.dao.UserDAO;
import in.pritha.dto.UserDTO;
import in.pritha.exception.DBException;
import in.pritha.exception.InvalidUserIdException;
import in.pritha.exception.ServiceException;
import in.pritha.exception.ValidationException;
import in.pritha.model.User;
import in.pritha.repository.UserRepository;
import in.pritha.validator.UserValidator;

@Service
public class UserService {

	/**
	 * This metho used to register user. if user not existed already, it will let
	 * the user to register Or else it throw exception it calls the dao to add the
	 * new user details
	 * 
	 * @param user
	 * @return true if registered
	 * @throws ServiceException
	 */
	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private UserRepository userRepository;

	public boolean register(User user) throws ServiceException {
		boolean validUser = false;
		// validate it
		try {
			if (UserValidator.validateRegistrationDatas(user.getUserName(), user.getMobileNumber(),
					user.getCreatePassWord(), user.getConfirmPassWord())) {
				validUser = true;

				UserDTO userdto = new UserDTO(user.getUserName().toUpperCase(), user.getCreatePassWord(),
						user.getMobileNumber(), LocalDate.now(), MessageConstants.ACTIVE, MessageConstants.ROLE);

				System.out.println("user DTO" + userdto);

				userDAO.save(userdto);

				System.out.println("inserted finished in dao");

			} else {
				throw new ServiceException("Given Registration Details are invalid");
			}
		} catch (ValidationException | DataAccessException e) {
			e.getMessage();
			throw new ServiceException(e, "Given Registration Details are invalid");

		}
		return validUser;
	}

	public boolean login(String userName, String passWord) throws ServiceException {
		boolean validUser = false;
		try {
			if (userValidator.isExistingUser(userName, passWord)) {
				Integer userId = userDAO.findIdByUsernameAndPasswordAndStatus(userName.toUpperCase(), passWord,
						MessageConstants.ACTIVE);
				System.out.println(userId);
				if (userId != 0) {
					validUser = true;
				} else {
					throw new ServiceException("can't login for this username or password");
				}

			} else {
				throw new ServiceException("can't login for this username or password");
			}
		} catch (ValidationException | DataAccessException e) {
			e.printStackTrace();
			throw new ServiceException("can't login for this username or password");

		}
		return validUser;
	}

	public boolean updateUser(Integer userId, String status) throws InvalidUserIdException {
		try {
			if (userId != null) {

				LocalDateTime loggedOutTime = LocalDateTime.now();
				String userStatus = MessageConstants.ACTIVE;
				userDAO.inActivateUser(userId, loggedOutTime, status, userStatus);
				return true;
			} else {
				throw new InvalidUserIdException("Invalid user id");
			}
		} catch (DBException e) {
			e.getMessage();
			throw new InvalidUserIdException(e, "Invalid user id");

		}

	}

	public List<UserDTO> getAllRegisteredUsers() {
		List<UserDTO> allUsers = userDAO.findAllUsers();
		System.out.println("Users List" + allUsers);
		return allUsers;
	}

}
