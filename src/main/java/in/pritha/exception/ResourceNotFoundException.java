package in.pritha.exception;

public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String exceptionMessage) {
		super(exceptionMessage); // call parent class exception
	}

	public ResourceNotFoundException(Throwable e, String message) {
		super(message, e);
	}

}
