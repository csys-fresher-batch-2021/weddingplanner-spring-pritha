package in.pritha.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import in.pritha.model.Booking;
import in.pritha.model.User;


@Controller
public class BookingControllerMVC {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/ListAllBookingsServlet")
	public String booking(HttpServletRequest request) {
		System.out.println("list all bookings");
		User user = new User("pritha");
		Booking booking = new Booking(7178,user,"BOOKED",LocalDate.now());
		List<Booking> bookingDetails = new ArrayList<>();
		bookingDetails.add(booking);
		System.out.println(bookingDetails);
		request.setAttribute("BOOKING_DETAILS", bookingDetails);
		return "listallbookings.jsp";
	}
	
	
	
}
