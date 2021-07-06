package in.pritha.dao;

import java.util.List;

import in.pritha.dto.PaymentDTO;
import in.pritha.model.Payment;

public interface PaymentDAO {

	// boolean savePaymentDetails(Payment payment);

	List<Payment> findAllPaymentDetails();

	boolean savePaymentDetails(PaymentDTO payment);
}
