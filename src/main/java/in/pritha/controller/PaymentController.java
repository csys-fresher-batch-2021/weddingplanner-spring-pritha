package in.pritha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.pritha.model.Payment;
import in.pritha.service.PaymentManager;

@RestController
public class PaymentController{
	
	@Autowired
	private PaymentManager paymentmanager;//= new PaymentManager();
	
	@GetMapping
	public String hello() {
		return "hello";
	}
	@GetMapping("/ListAllPaymentDetailsServlet")
	public List<Payment> getAllPaymentDetails(){
		return paymentmanager.getAllPaymentDetails();
	}

	
	@GetMapping("/AddPaymentDetailsServlet")
	public boolean addPaymentDetails(@RequestParam("payment")Payment payment) {
		return paymentmanager.addPaymentDetails(payment);
	}
}