package in.pritha.exception;

public class InvalidBookingDetailsException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidBookingDetailsException(String exceptionMessage) {
		super(exceptionMessage); // call parent class exception
	}

	public InvalidBookingDetailsException(Throwable e, String message) {
		super(message, e);
	}

}
