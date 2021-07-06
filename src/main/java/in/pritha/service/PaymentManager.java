package in.pritha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pritha.dao.PaymentDAO;
import in.pritha.model.Payment;

@Service
public class PaymentManager {

	@Autowired
	private PaymentDAO paymentDAO;// = new PaymentDAO();

	public List<Payment> getAllPaymentDetails() {
		return paymentDAO.findAllPaymentDetails();
	}

	public boolean addPaymentDetails(Payment payment) {
		// todo - validation
		boolean isAdded = true;
		// isAdded = paymentDAO.savePaymentDetails(payment);
		return isAdded;
	}
}
