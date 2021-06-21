package in.pritha.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	
	private String userName;
	private Integer bookingId;
	private String cardType;
	private Long cardNo;
	private LocalDate expiryDate;
	private Integer cvv;
	private Integer amount;
	private String status;
	private String transactionCode;
	private String purpose;
	public Payment(String userName, Integer bookingId,String cardType, Integer amount, String status, String transactionCode) {
		super();
		this.userName = userName;
		this.bookingId = bookingId;
		this.cardType = cardType;
		this.amount = amount;
		this.status = status;
		this.transactionCode = transactionCode;
	}


}
