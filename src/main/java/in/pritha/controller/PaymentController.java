package in.pritha.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pritha.dao.PaymentDAO;
import in.pritha.dto.PaymentDTO;
import in.pritha.model.Payment;
import in.pritha.service.PaymentManager;
import in.pritha.service.PaymentService;

@RestController
@RequestMapping("payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private PaymentDAO paymentDAOImpl;

	@Autowired
	private PaymentManager paymentservice;
	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

	@GetMapping
	public String hello() {
		return "hello";
	}

	@GetMapping("/ListAllPaymentDetailsServlet")
	public List<Payment> getAllPaymentDetails() {
		return paymentservice.getAllPaymentDetails();
	}

	@PostMapping("/AddPaymentDetailsServlet")
	public boolean addPaymentDetails(@RequestBody Payment payment) {
		return paymentservice.addPaymentDetails(payment);
	}

	@PostMapping("/checkpaymentdetails")
	public Payment checkPaymentDetails(@RequestBody Payment payment) {
		logger.info("Payment Details{} :" + payment);
		int discount = paymentService.getDiscount(payment.getSelectedBank());
		System.out.println(discount);

		return payment;
	}

	@PostMapping("/returnpaymentdetails")
	public boolean returnPaymentDetails(@Valid @RequestBody Payment payments) {
		logger.info("Payment Details{} :" + payments);
		PaymentDTO payment = new PaymentDTO(payments.getSelectedBank(), payments.getCardType(),
				payments.getCardUserName(), payments.getAmount(), payments.getTransactionCode(), payments.getPurpose());
		boolean success = paymentDAOImpl.savePaymentDetails(payment);
		return success;

	}

}