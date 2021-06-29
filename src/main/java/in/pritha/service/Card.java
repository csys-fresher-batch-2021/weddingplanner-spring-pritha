package in.pritha.service;

import java.time.LocalDate;

interface Card {

	boolean isValidCreditCardNumber(Long creditCardNumber);

	boolean isCardExpired(LocalDate cardExpiryDate);

	boolean isValidCVVPin(Integer CVVPin);

	boolean isValidAmount(Integer amount);

}
