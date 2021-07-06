package in.pritha.dto;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@org.springframework.data.relational.core.mapping.Table("users")
public class UserDTO {

	public UserDTO(String userName, String createPassWord, Long mobileNumber, LocalDate localDate, String active,
			String role) {
		super();
		this.userName = userName;
		this.passWord = createPassWord;
		this.mobileNumber = mobileNumber;
		this.userActiveStatus = active;
		this.role = role;
		this.dateRegistered = localDate;
	}

	public UserDTO(String username, long mobileNumber, String password) {
		this.userName = username;
		this.mobileNumber = mobileNumber;
		this.passWord = password;
	}

	public UserDTO(String username, int userId, long mobileNumber, String passWord, String role) {
		this.userId = userId;
		this.userName = username;
		this.mobileNumber = mobileNumber;
		this.passWord = passWord;
		this.role = role;
	}

	@Column(value = "username")
	private String userName;

	@Id
	private Integer userId;

	@Column(value = "role")
	private String role;

	@Column(value = "mobile_number")
	private Long mobileNumber;

	@Column(value = "password")
	private String passWord;

	@Column(value = "registered_date")
	private LocalDate dateRegistered;

	@Column(value = "user_status")
	private String userActiveStatus;

}
