package in.pritha.service;

abstract class Bank {
	abstract int getDiscount();
}

class BankFactory {

	public static Bank getInstance(String selectedBank) {
		if ("SBI".equalsIgnoreCase(selectedBank)) {
			return new SBI();
		}
		return null;
	}
}

class BankService {

	public int getDiscount(String selectedBank) {
		Bank bank = BankFactory.getInstance(selectedBank);
		return bank.getDiscount();
	}
}

class SBI extends Bank {
	@Override
	int getDiscount() {
		return 5;
	}
}

class CANARA extends Bank {
	@Override
	int getDiscount() {
		return 10;
	}
}

class HDFC extends Bank {
	@Override
	int getDiscount() {
		return 15;
	}
}

class AXIS extends Bank {
	@Override
	int getDiscount() {
		return 20;
	}
}
