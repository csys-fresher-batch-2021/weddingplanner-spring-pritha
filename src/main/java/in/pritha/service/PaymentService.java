package in.pritha.service;

import org.springframework.stereotype.Service;

import in.pritha.service.bank.Bank;
import in.pritha.service.card.Card;

@Service
public class PaymentService extends Bank implements Card {

	@Override
	public boolean isValidCreditCardNumber(Long cardNo) {
		boolean isvalidCard = false;
		String cardNoString = Long.toString(cardNo);
		int length = (Long.toString(cardNo)).length();
		if (length >= 13 && length <= 16) {
			if (cardNoString.startsWith("6", 0) || cardNoString.startsWith("4", 0) || cardNoString.startsWith("37", 0)
					|| cardNoString.startsWith("5", 0)) {
				isvalidCard = true;
			}
		}
		return isvalidCard;

	}

	@Override
	public int getDiscount(String selectedBank) {
		Bank bank = BankFactory.getInstance(selectedBank);
		return bank.getDiscount(selectedBank);
	}

}
