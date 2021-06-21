package in.pritha.exception;

public class ServiceException extends Exception {
	
private static final long serialVersionUID = 1L;
	
	
	
	public ServiceException(String exceptionMessage)
	{
	   super(exceptionMessage); //call parent class exception
	}
	public ServiceException(Throwable e, String message) {
		super(message,e);
	}
}
