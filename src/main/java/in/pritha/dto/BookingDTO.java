package in.pritha.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookings")
public class BookingDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "booking_id", updatable = false, nullable = false)
	private Integer bookingId;

	private String username;

	private String status;

	@Column(name = "wedding_date")
	private LocalDate weddingDate;

	@Column(name = "wedding_time", columnDefinition = "TIME")
	private LocalTime weddingTime;

	@Column(name = "wedding_location")
	private String weddingLocation;

	@Column(name = "wedding_style")
	private String weddingStyle;

	@Column(name = "wedding_style_loction")
	private String weddingStyleLocation;

	@Column(name = "wedding_food_type")
	private String weddingFoodType;

	@Column(name = "wedding_guest_count")
	private String weddingGuestCount;

	@Column(name = "wedding_decor_type")
	private String weddingDecorType;

	@Column(name = "booked_date", columnDefinition = "DATE")
	private LocalDate bookedDate = LocalDate.now();

	@Column(name = "cancelled_date", nullable = true, columnDefinition = "DATE")
	private LocalDate cancelledDate;

	@Column(name = "cancellation_reason", nullable = true)
	private String cancellationReason;

}
