package in.pritha.exception;

public class DBException extends Exception {

	private static final long serialVersionUID = 1L;

	public DBException(String exceptionMessage) {
		super(exceptionMessage); // call parent class exception
	}

	public DBException(Throwable e, String message) {
		super(message, e);
	}

}
