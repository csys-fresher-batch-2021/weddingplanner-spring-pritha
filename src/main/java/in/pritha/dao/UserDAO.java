package in.pritha.dao;

import java.time.LocalDateTime;
import java.util.List;

import in.pritha.dto.UserDTO;
import in.pritha.exception.DBException;

public interface UserDAO {

	// method declaration only
	void save(UserDTO user);

	List<UserDTO> findAllUsers();

	Integer findIdByUsernameAndPasswordAndStatus(String username, String passWord, String status);

	void inActivateUser(Integer userId, LocalDateTime loggedOutTime, String status, String userStatus)
			throws DBException;

}
