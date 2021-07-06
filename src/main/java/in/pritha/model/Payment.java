package in.pritha.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.Digits;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString
@Table(value = "payments")
@JsonInclude(value = Include.NON_NULL)
public class Payment {

	@Id
	@Column(value = "payment_id")
	private Integer paymentId;

	@NotNull(message = "Bank cannot be Null")
	@NotEmpty(message = "Bank cannot be Empty")
	@Column(value = "bank")
	private String selectedBank;

	@NotNull(message = "Card cannot be Null")
	@NotEmpty(message = "Card cannot be Empty")
	@Column(value = "card")
	private String cardType;

	@NotNull(message = "CardUsername cannot be Null")
	@NotEmpty(message = "CardUsername cannot be Empty")
	@Size(min = 2, max = 30, message = "Unmatched size - CardUsername should be(2,30)")
	@Column(value = "card_user_name")
	private String cardUserName;

	@Digits(fraction = 0, integer = 16, message = "cardNo must be 16 digits")
	@Positive(message = "CardNo cannot be negative")
	private Long cardNo;

	@FutureOrPresent(message = "Card Expiry Cannot be in past")
	private LocalDate expiryDate;

	// @UniqueElements(message = "cvv should be unique")
	@Digits(fraction = 0, integer = 3, message = "cvv should be 3 digits")
	private Integer cvv;

	@Range(min = 1, max = 1000000, message = " Unmatched size - amount should be(1,1000000)")
	private Integer amount;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private String status;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Column(value = "payment_date")
	private LocalDateTime paymentDate = LocalDateTime.now();

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Column(value = "transaction_code")
	private String transactionCode = "45670";

	private String purpose;

}
