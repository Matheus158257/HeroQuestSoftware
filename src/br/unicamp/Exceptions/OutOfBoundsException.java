package br.unicamp.Exceptions;

@SuppressWarnings("serial")
public class OutOfBoundsException extends Exception {

	public OutOfBoundsException() {
		super();
	}
	
	public OutOfBoundsException(String message) {
		super(message);
	}
	
	public OutOfBoundsException(Throwable cause) {
		super(cause);
	}
	
	public OutOfBoundsException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
