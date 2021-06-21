package in.pritha.message;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message {
	
	public Message(String message, HttpStatus badRequest) {
	this.errorMessage = message;
	this.request = badRequest;
	}
	private String infoMessage;
	private String errorMessage;
	private HttpStatus request;

}
