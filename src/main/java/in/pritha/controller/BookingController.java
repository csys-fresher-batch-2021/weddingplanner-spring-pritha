package in.pritha.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.pritha.dao.BookingDAO;
import in.pritha.dto.BookingDTO;
import in.pritha.exception.InvalidBookingDetailsException;
import in.pritha.exception.ResourceNotFoundException;
import in.pritha.model.BookingEntity;
import in.pritha.repository.BookingRepository;
import in.pritha.service.BookingService;

@RestController
@RequestMapping("bookings")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private BookingDAO bookingDAO;

	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

	@PostMapping("/checkbookingdetails")
	public BookingEntity checkBookingDetails(@RequestBody BookingEntity booking) throws InvalidBookingDetailsException {
		System.out.println("check details of booking ");

		logger.info("Booking Details: {}", booking);

		return bookingService.checkBookingDetails(booking);

	}

	@SuppressWarnings("unchecked")
	@PutMapping("cancel/{id}")
	public ResponseEntity<BookingEntity> cancelBooking(@PathVariable(value = "id") Integer bookingId,
			@RequestBody BookingEntity bookingDetails) throws ResourceNotFoundException {
		BookingEntity booking = bookingRepository.findById(bookingId)
				.orElseThrow(() -> new ResourceNotFoundException("Booking Id not found on :: " + bookingId));
		System.out.println("Id Find?" + booking);
		System.out.println("cancelled Booking data: " + bookingDetails);
		final boolean updatedBooking = bookingDAO.cancelBooking(bookingDetails);
		if (updatedBooking == true) {
			return ResponseEntity.ok(bookingDetails);
		} else {
			return (ResponseEntity<BookingEntity>) ResponseEntity.badRequest();
		}

	}

	@GetMapping("getmybookings")
	public BookingEntity myBookings(@RequestParam(name = "username", required = true) String username) {
		BookingEntity myBookingsList = bookingRepository.findByName(username);

		logger.info("Booking Details: {}", myBookingsList);
		return myBookingsList;

	}

	@GetMapping("getallbookings")
	public List<BookingEntity> allBookings() {
		List<BookingEntity> allBookingsList = bookingRepository.findAll();
		// sort by booked date desc using comparator
		Comparator<BookingEntity> sortByBookingDate = Comparator.comparing(BookingEntity::getBookedDate);
		Collections.sort(allBookingsList, sortByBookingDate.reversed());

		logger.info("Booking Details: {}", allBookingsList);
		return allBookingsList;

	}

	@GetMapping("getleaderboard")
	public List<BookingDTO> getLeaderBoard() {
		List<BookingDTO> leaderBoard = bookingRepository.findLeaderBoard();
		logger.info("LeaderBoard Details: {}", leaderBoard);
		return leaderBoard;

	}

	@GetMapping("getmyaccount")
	public Integer myAccount(@RequestParam(name = "username", required = true) String username) {
		Integer count = bookingDAO.findMyAccount(username);
		return count;

	}

}
