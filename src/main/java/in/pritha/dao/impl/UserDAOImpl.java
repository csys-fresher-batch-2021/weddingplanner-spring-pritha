package in.pritha.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.pritha.controller.UserController;
import in.pritha.dao.UserDAO;
import in.pritha.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	  @Autowired
	  private JdbcTemplate jdbcTemplate; 

	  final String INSERT_QUERY = "insert into users(username,password,mobile_number) values (?, ?, ?)";
	  
	  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
		    this.jdbcTemplate = jdbcTemplate;  
		  }
	
	  public void save(UserDTO userdto) {
		  System.out.println("Implements called");
		  System.out.println("USERDTO IMPL"+ userdto);
		    int status = jdbcTemplate.update(INSERT_QUERY, userdto.getUserName(),
		    		userdto.getPassWord(),userdto.getMobileNumber());   
		    if(status!=0) {
		    	System.out.println("Data updated");
		    }else {
		    	System.out.println("Data not updated");

		    }
		    
		  }
	  
	  public boolean register(UserDTO user) {
		  boolean saved =false;
		  try {
			  String sql="insert into users(username,password,mobile_number) values(?,?,?)";
			  Object[]params = {user.getUserName(),user.getPassWord(),user.getMobileNumber()};
			  int rows = jdbcTemplate.update(sql,params);
			  logger.debug("No.of.rows.inserted:"+ rows);
			  if(rows==1) {
				  saved = true;
			  }
		  }catch(Exception e) {
			  e.getMessage();
			  e.printStackTrace();
			  saved = false;
			  logger.error("Error while register" + user.getUserName());
			  
			  
		  }
	  
	 return saved;
	  } 
}
