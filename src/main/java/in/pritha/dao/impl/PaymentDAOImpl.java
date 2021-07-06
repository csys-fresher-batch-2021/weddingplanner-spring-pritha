package in.pritha.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.pritha.dao.PaymentDAO;
import in.pritha.dto.PaymentDTO;
import in.pritha.model.Payment;

@Repository
public class PaymentDAOImpl implements PaymentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	final String INSERT_QUERY = "insert into payments(bank,card,card_user_name,amount,transactioncode,purpose) values (?, ?, ?, ?, ?, ?)";

	@Override
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
			Payment payment = new Payment();
			return payment;

		});

		System.out.println(paymentDetailsList);
		return paymentDetailsList;
	}

	@Override
	public boolean savePaymentDetails(PaymentDTO paymentdto) {
		boolean success = false;
		System.out.println("Implements called");
		System.out.println("PAYMENTDAO IMPL" + paymentdto);
		int status = jdbcTemplate.update(INSERT_QUERY, paymentdto.getBank(), paymentdto.getCard(),
				paymentdto.getCard_user_name(), paymentdto.getAmount(), paymentdto.getTransactioncode(),
				paymentdto.getPurpose());
		if (status != 0) {
			success = true;
			System.out.println("Data updated");
		} else {
			System.out.println("Data not updated");

		}
		return success;

	}

}
