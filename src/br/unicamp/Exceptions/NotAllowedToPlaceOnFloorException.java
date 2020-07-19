package br.unicamp.Exceptions;

public class NotAllowedToPlaceOnFloorException extends Exception {

	public NotAllowedToPlaceOnFloorException() {
		super();
	}

	public NotAllowedToPlaceOnFloorException(String message) {
		super(message);
	}

	public NotAllowedToPlaceOnFloorException(Throwable cause) {
		super(cause);
	}

	public NotAllowedToPlaceOnFloorException(String message, Throwable cause) {
		super(message, cause);
	}	
	
}
