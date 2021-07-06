package in.pritha.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discount {

	private String userName;
	private Integer bookingId;
	private Integer earnedCoins;
	private String discountStatus;

}
