package in.pritha.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
@org.springframework.data.relational.core.mapping.Table("bookings")
public class BookingEntity {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(value = "booking_id")
	private Integer bookingId;

	@Column(value = "username")
	private String username;

	private String status;

	@Column(value = "wedding_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	// @JsonDeserialize(using = LocalDateDeserializer.class)
	// @JsonSerialize(using = LocalDateSerializer.class)
	// @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate weddingDate;

	@Column(value = "wedding_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a")
	private LocalTime weddingTime;

	@Column(value = "wedding_location")
	private String weddingLocation;

	@Column(value = "wedding_style")
	private String weddingStyle;

	@Column(value = "wedding_style_location")
	private String weddingStyleLocation;

	@Column(value = "wedding_food_type")
	private String weddingFoodStyle;

	@Column(value = "wedding_guest_count")
	private String weddingGuestCount;

	@Column(value = "wedding_decor_type")
	private String weddingDecorTheme;

	@Column(value = "booked_date")
	private LocalDateTime bookedDate = LocalDateTime.now();

	@Column(value = "cancelled_date")
	private LocalDate cancelledDate;

	@Column(value = "cancellation_reason")
	private String cancellationReason;

}
