package in.pritha.exceptionhandler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import in.pritha.message.Message;

@ControllerAdvice
public class PaymentExceptionHandler {

	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Message> methodArgumentNotValidException(MethodArgumentNotValidException e) {
		// bind all information about that all field errors
		BindingResult result = e.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		Message error = new Message("validation errors", null);
		for (FieldError fieldError : fieldErrors) {
			// getting field and field error message only
			error.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
