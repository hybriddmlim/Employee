package webapp.exception;

public class URLRuntimeException extends RuntimeException {
	
	public URLRuntimeException() {
		super();
	}
	
	public URLRuntimeException(String message) {
		super(message);
	}
	
	public URLRuntimeException(String message, Throwable e) {
		super(message, e);
	}

}
