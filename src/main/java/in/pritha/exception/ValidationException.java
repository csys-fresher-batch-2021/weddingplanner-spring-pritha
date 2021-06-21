package in.pritha.exception;



public class ValidationException extends Exception {

	
	private static final long serialVersionUID = 1L;
	
	
	
	public ValidationException(String exceptionMessage)
	{
	   super(exceptionMessage); //call parent class exception
	}
	
	public ValidationException(Throwable e, String message) {
		super(message,e);
	}

}
