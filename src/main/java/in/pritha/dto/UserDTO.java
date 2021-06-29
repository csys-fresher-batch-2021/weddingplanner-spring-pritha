package in.pritha.dto;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class UserDTO {
	
	public UserDTO(String userName, String createPassWord, Long mobileNumber, LocalDate localDate, String active, String role) {
		super();
		this.userName = userName;
		this.passWord = createPassWord;
		this.mobileNumber = mobileNumber;
		this.userActiveStatus=active;
		this.role=role;
		this.dateRegistered=localDate;
	}
	
	public UserDTO(String username, long mobileNumber, String password) {
		this.userName=username;
		this.mobileNumber=mobileNumber;
		this.passWord=password;
	}

	public UserDTO(String username, int userId, long mobileNumber, String passWord, String role) {
		this.userId = userId;
		this.userName=username;
		this.mobileNumber=mobileNumber;
		this.passWord=passWord;
		this.role = role;
	}

	@Column(name="username")
	private String userName;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")  
	private Integer userId;
	
	@Column(name="role")
	private String role;
	
	@Column(name="mobile_number") 
	private Long mobileNumber;
	
	@Column(name="password")
	private String passWord;
	
	@Column(name="registered_date")  
	private LocalDate dateRegistered; 
	
	@Column(name="user_status")  
	private String userActiveStatus;
	 
	

}
