package in.pritha.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import in.pritha.model.Booking;
import in.pritha.service.BookingService;

public class JdkStreamsTest {

	@Test
	public void testForReturnAsListToMap() {
		BookingService.getAllBookingDetails();
		
	}
	
	@Test
	public void testForReturnAsSeperateStatusList() {
		Map<String, List<Booking>> map = BookingService.groupByBookingStatus();
		System.out.println(map);
	}
	
	@Test
	public void testForSearchByTwoFilters(LocalDate bookedDate,String bookingStatus) {
		
		
		
	}
	
}
