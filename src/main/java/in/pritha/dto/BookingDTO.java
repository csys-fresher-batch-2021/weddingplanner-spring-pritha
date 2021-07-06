package in.pritha.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookings")
public class BookingDTO {

	@Column(name = "user_id")
	private Integer userId;

	private String username;

	@Column(name = "mobile_number")
	private Long mobileNumber;

	@Column(name = "earned_coins")
	private Integer earnedCoins;

}
