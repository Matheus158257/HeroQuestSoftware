package br.unicamp.Exceptions;

@SuppressWarnings("serial")
public class NotAllowedToPlaceOnWallException extends Exception {

	public NotAllowedToPlaceOnWallException() {
		super();
	}

	public NotAllowedToPlaceOnWallException(String message) {
		super(message);
	}

	public NotAllowedToPlaceOnWallException(Throwable cause) {
		super(cause);
	}

	public NotAllowedToPlaceOnWallException(String message, Throwable cause) {
		super(message, cause);
	}	
	
}
