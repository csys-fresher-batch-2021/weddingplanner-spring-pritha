package in.pritha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pritha.exception.InvalidBookingDetailsException;
import in.pritha.exception.ValidationException;
import in.pritha.model.BookingEntity;
import in.pritha.repository.BookingRepository;
import in.pritha.validator.BookingValidator;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private BookingValidator bookingValidator;

	public BookingEntity checkBookingDetails(BookingEntity booking) throws InvalidBookingDetailsException {
		BookingEntity dataFromDAO = null;
		try {
			if (bookingValidator.dateTimeValidator(booking.getWeddingDate(), booking.getWeddingTime(),
					booking.getWeddingLocation())) {
				dataFromDAO = bookingRepository.save(booking);
				System.out.println("Object " + dataFromDAO);
				System.out.println("saved data in dao");

			} else {
				throw new InvalidBookingDetailsException("Invalid Booking Details");
			}
		} catch (ValidationException e) {
			e.getMessage();
			throw new InvalidBookingDetailsException(e, "Invalid Booking Details");
		}
		return dataFromDAO;
	}

}
