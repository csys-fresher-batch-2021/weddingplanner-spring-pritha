package in.pritha.message;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

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

	// list
	public final List<FieldError> errorMessagesList = new ArrayList<>();

	// method for binding errors and return as list
	public void addFieldError(String field, String defaultMessage) {
		FieldError error = new FieldError(field, defaultMessage, defaultMessage);
		errorMessagesList.add(error);

	}

}
