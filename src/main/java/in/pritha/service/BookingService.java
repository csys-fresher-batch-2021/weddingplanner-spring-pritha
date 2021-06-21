package in.pritha.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import in.pritha.exception.ServiceException;
import in.pritha.model.Booking;
import in.pritha.model.User;

public class BookingService {

	public static boolean bookingValidator(Booking booking) throws ServiceException {
		boolean isValidBookingData=false;
		if(booking!=null) {
			isValidBookingData=true;
		}else {
			throw new ServiceException("Invalid Data");
		}
		return isValidBookingData;
	}
	
	static List<Booking> bookingDetails = new ArrayList<>();
	static {
		User user = new User("pritha");
		bookingDetails.add(new Booking(6354,user,"BOOKED",LocalDate.now()));
		bookingDetails.add(new Booking(7172,user,"CANCELLED",LocalDate.now()));
		bookingDetails.add(new Booking(8567,user,"PAID",LocalDate.now()));
		bookingDetails.add(new Booking(9123,user,"UNPAID",LocalDate.now()));
		bookingDetails.add(new Booking(6355,user,"BOOKED",LocalDate.now()));
		}
	
	//Using Java JDK8 Streams
	//List to Map conversion
	public static Map<User, String> getAllBookingDetails(){
		Map<User,String> bookingDetailsMap = new HashMap<>();
		bookingDetailsMap = bookingDetails.stream().collect(Collectors.toMap(Booking :: getBookedBy, Booking :: getBookingStatus));
		return bookingDetailsMap;
		
	}
	
	//separate status list
	public static Map<String,List<Booking>> groupByBookingStatus(){
		Map<String,List<Booking>> bookingDetailsMap = new HashMap<>();
		bookingDetailsMap = bookingDetails.stream().collect(Collectors.groupingBy(Booking :: getBookingStatus));
		return bookingDetailsMap;
		
	}
	/*
	 * //get status by two filters-today date,booked status public static
	 * Set<String> getBookingStatusForToday(LocalDate todayDate,String
	 * bookingStatus){ Set<String> filteredBookingStatus = bookingDetails.stream()
	 * .filter(bookingDetails->bookingDetails.getBookedDate()
	 * .contains(LocalDate.now()) && bookingDetails.getBookingStatus()
	 * .equals(bookingStatus))) .map(bookingDetails->bookingDetails.get())
	 * .collect(Collectors.toSet());
	 * 
	 * return filteredBookingStatus;
	 * 
	 * 
	 * }
	 */
	
	
	
	

}
