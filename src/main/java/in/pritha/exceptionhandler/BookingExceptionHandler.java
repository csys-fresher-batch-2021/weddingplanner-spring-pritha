package in.pritha.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import in.pritha.exception.ResourceNotFoundException;
import in.pritha.message.Message;

@ControllerAdvice
public class BookingExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Message> mapUnexpectedTypeException(ResourceNotFoundException e) {
		Message errorMessage = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
		e.printStackTrace();
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}

}
