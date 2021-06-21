package in.pritha.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import in.pritha.exception.InvalidUserIdException;
import in.pritha.message.Message;

@ControllerAdvice
public class UserExceptionHandler {
	
	
	
		@ExceptionHandler(Exception.class)
		public ResponseEntity<Message> mapException(Exception e) {
			Message errorMessage = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
			e.printStackTrace();
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}
		
		
		
		@ExceptionHandler(InvalidUserIdException.class)
		public ResponseEntity<Message> mapUnexpectedTypeException(InvalidUserIdException e) {
			Message errorMessage = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
			e.printStackTrace();
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}

}
