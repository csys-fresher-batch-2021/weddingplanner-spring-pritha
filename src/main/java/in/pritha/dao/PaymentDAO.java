package in.pritha.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.pritha.model.Payment;

@Repository
public class PaymentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// created object for my own class
	private static PaymentDAO paymentDAO = null;

	// created own method to access my class objects
	public static PaymentDAO getInstance() {
		// if object is null only, create object - avoid duplication
		// singleton concept
		if (paymentDAO == null) {
			paymentDAO = new PaymentDAO();
		}
		return paymentDAO;
	}

	@SuppressWarnings("deprecation")
	public List<Payment> findAllPaymentDetails() {
		String sql = "Select username,bookingid,cardtype,amount,status,transactioncode from payment_details";
		Object[] params = {};
		List<Payment> paymentDetailsList = jdbcTemplate.query(sql, params, (rs, rowNum) -> {
			String userName = rs.getString("username");
			Integer bookingId = rs.getInt("bookingId");
			String cardType = rs.getString("cardtype");
			Integer amount = rs.getInt("amount");
			String status = rs.getString("status");
			String transactionCode = rs.getString("transactioncode");
			Payment payment = new Payment(userName, bookingId, cardType, amount, status, transactionCode);
			return payment;

		});

		System.out.println(paymentDetailsList);
		return paymentDetailsList;
	}

	public boolean savePaymentDetails(Payment payment) {
		String sql = "insert into payment_details(username,bookingid,cardtype,amount,status,transactioncode) values (?,?,?,?,?,?)";
		Object[] params = { payment };
		int rows = jdbcTemplate.update(sql, params);
		return rows == 1;

	}

}
