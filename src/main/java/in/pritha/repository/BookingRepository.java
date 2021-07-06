package in.pritha.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.pritha.dto.BookingDTO;
import in.pritha.model.BookingEntity;

@Repository
public interface BookingRepository extends CrudRepository<BookingEntity, Integer> {

	@Query("Select status,booked_date,wedding_date,wedding_time,wedding_location from bookings b where b.username = :username")
	BookingEntity findByName(@Param("username") String username);

	@Query("select*from user_earned_coins_vw;")
	List<BookingDTO> findLeaderBoard();

	@Override
	List<BookingEntity> findAll();
}
