package in.pritha.dao;

import in.pritha.model.BookingEntity;

public interface BookingDAO {

	// method declaration only
	BookingEntity cancelBookingDetailsAndTheirEarnedCoins(BookingEntity booking);

	boolean cancelBooking(BookingEntity booking);

	Integer findMyAccount(String username);

}
