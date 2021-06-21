package in.pritha.model;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
	public User(String bookedBy) {
		this.userName = bookedBy;
		
	}
	private String userName;
	private Long mobileNumber;
	private String createPassWord;
	private String confirmPassWord;
	private String role;

}
