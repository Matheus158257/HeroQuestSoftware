package br.unicamp.Exceptions;

@SuppressWarnings("serial")
public class LifeOnMaximumException extends Exception {

	public LifeOnMaximumException() {
		super();
	}

	public LifeOnMaximumException(String message) {
		super(message);
	}

	public LifeOnMaximumException(Throwable cause) {
		super(cause);
	}

	public LifeOnMaximumException(String message, Throwable cause) {
		super(message, cause);
	}	
	
}
