package in.pritha.service;

import in.pritha.service.bank.Bank;

public class BankFactory {

	public static Bank getInstance(String selectedBank) {
		if ("SBI".equalsIgnoreCase(selectedBank)) {
			return new SBI();
		} else if ("CANARA".equalsIgnoreCase(selectedBank)) {
			return new CANARA();
		} else if ("HDFC".equalsIgnoreCase(selectedBank)) {
			return new HDFC();
		} else if ("AXIS".equalsIgnoreCase(selectedBank)) {
			return new AXIS();
		} else {
			return null;
		}
	}
}

class SBI extends Bank {
	@Override
	public int getDiscount(String selectedBank) {
		return 5;
	}
}

class CANARA extends Bank {
	@Override
	public int getDiscount(String selectedBank) {
		return 10;
	}
}

class HDFC extends Bank {
	@Override
	public int getDiscount(String selectedBank) {
		return 15;
	}
}

class AXIS extends Bank {
	@Override
	public int getDiscount(String selectedBank) {
		return 20;
	}
}
