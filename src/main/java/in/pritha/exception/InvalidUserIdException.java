package in.pritha.exception;



public class InvalidUserIdException extends Exception {
	

	
	private static final long serialVersionUID = 1L;

	public InvalidUserIdException(String exceptionMessage)
	{
	   super(exceptionMessage); //call parent class exception
	}
	
	public InvalidUserIdException(Throwable e, String message) {
		super(message,e);
	}
	
	

}
