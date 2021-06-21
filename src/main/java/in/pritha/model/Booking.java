package in.pritha.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
	
	
		


	public Booking(int bookingId, User bookedBy, String bookingStatus, LocalDate bookedDate) {
		this.bookingId=bookingId;
		this.bookedBy=bookedBy;
		this.bookingStatus=bookingStatus;
		this.bookedDate=bookedDate;
	}
	
	private Integer bookingId;
	private User bookedBy = new User("Pritha");
	private String bookingStatus;
	private LocalDate bookedDate ;
	private String weddingDate;
	private String weddingTime;
	private String weddingLocation;
	private String weddingStyle;
	private String weddingStyleLocation;
	private String weddingFoodType;
	private String weddingGuestCount;
	private String weddingDecorType;
	

}
