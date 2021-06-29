package in.pritha.dao.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.pritha.controller.UserController;
import in.pritha.dao.UserDAO;
import in.pritha.dto.UserDTO;
import in.pritha.exception.DBException;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	final String INSERT_QUERY = "insert into users(username,password,mobile_number) values (?, ?, ?)";

	final String UPDATE_QUERY = "update users set user_status=?, logout_time =? where user_id=? AND user_status=?";

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void save(UserDTO userdto) {
		System.out.println("Implements called");
		System.out.println("USERDTO IMPL" + userdto);
		int status = jdbcTemplate.update(INSERT_QUERY, userdto.getUserName(), userdto.getPassWord(),
				userdto.getMobileNumber());
		if (status != 0) {
			System.out.println("Data updated");
		} else {
			System.out.println("Data not updated");

		}

	}

	public boolean register(UserDTO user) {
		boolean saved = false;
		try {
			String sql = "insert into users(username,password,mobile_number) values(?,?,?)";
			Object[] params = { user.getUserName(), user.getPassWord(), user.getMobileNumber() };
			int rows = jdbcTemplate.update(sql, params);
			logger.debug("No.of.rows.inserted:" + rows);
			if (rows == 1) {
				saved = true;
			}
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			saved = false;
			logger.error("Error while register" + user.getUserName());

		}

		return saved;
	}

	@Override
	public List<UserDTO> findAllUsers() {

		String sql = "SELECT * FROM USERS";

		return jdbcTemplate.query(sql, (rs, rowNum) -> new UserDTO(rs.getString("username"),
				rs.getLong("mobile_number"), rs.getString("password")));
	}

	@Override
	@SuppressWarnings("deprecation")
	public Integer findIdByUsernameAndPasswordAndStatus(String userName, String passWord, String status) {

		String sql = "SELECT user_id FROM users WHERE username = ? AND password =? AND user_status=?";

		return jdbcTemplate.queryForObject(sql, new Object[] { userName, passWord, status }, Integer.class);

	}

	@Override
	public void inActivateUser(Integer userId, LocalDateTime loggedOutTime, String status, String userStatus)
			throws DBException {
		System.out.println("Implements called");
		System.out.println("USERDTO IMPL" + userId);
		int success = jdbcTemplate.update(UPDATE_QUERY, status, loggedOutTime, userId, userStatus);
		if (success != 0) {
			System.out.println("Logouted the user");
		} else {
			System.out.println("Not able to loggedout");
			throw new DBException("Invalid User Id");

		}

	}

}
