package in.pritha.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pritha.exception.ServiceException;
import in.pritha.message.Message;
import in.pritha.model.Booking;
import in.pritha.service.BookingService;

@RestController
public class BookingController {
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	@PostMapping("/CheckBookingDetailsServlet")
	public ResponseEntity<?> checkBookingDetails(Booking booking) {
		System.out.println("check details of booking ");
		
			 logger.info("Booking Details: {}", booking);
			 try {
				BookingService.bookingValidator(booking);
				
				 Message message = new Message();
				 message.setInfoMessage("Valid Booking Details"); 
				 return new ResponseEntity<>(booking,HttpStatus.OK);
				 
				
			} catch (ServiceException e) {
				Message message = new Message();
				e.printStackTrace();
				message.setErrorMessage("Your BookingDetails are incorrect");
				return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
				
			}
	}
	

}
