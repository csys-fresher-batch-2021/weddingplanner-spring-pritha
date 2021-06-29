package in.pritha.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookings")
public class BookingEntity {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	// "id_Sequence")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id", updatable = false, nullable = false)
	private Integer bookingId;

	@Column(name = "username")
	private String username;

	private String status;

	@Column(name = "wedding_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	// @JsonDeserialize(using = LocalDateDeserializer.class)
	// @JsonSerialize(using = LocalDateSerializer.class)
	// @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate weddingDate;

	@Column(name = "wedding_time", columnDefinition = "TIME")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a")
	private LocalTime weddingTime;

	@Column(name = "wedding_location")
	private String weddingLocation;

	@Column(name = "wedding_style")
	private String weddingStyle;

	@Column(name = "wedding_style_location")
	private String weddingStyleLocation;

	@Column(name = "wedding_food_type")
	private String weddingFoodStyle;

	@Column(name = "wedding_guest_count")
	private String weddingGuestCount;

	@Column(name = "wedding_decor_type")
	private String weddingDecorTheme;

	@Column(name = "booked_date", columnDefinition = "DATE")
	private LocalDateTime bookedDate = LocalDateTime.now();

	@Column(name = "cancelled_date", nullable = true, columnDefinition = "DATE")
	private LocalDate cancelledDate;

	@Column(name = "cancellation_reason", nullable = true)
	private String cancellationReason;

}
