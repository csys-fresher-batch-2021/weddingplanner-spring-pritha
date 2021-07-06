package in.pritha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {

	private String bank;
	private String card;
	private String card_user_name;
	private Integer amount;
	private String transactioncode;
	private String purpose;

}
