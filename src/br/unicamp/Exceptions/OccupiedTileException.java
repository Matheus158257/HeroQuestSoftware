package br.unicamp.Exceptions;

@SuppressWarnings("serial")
public class OccupiedTileException extends Exception {

	public OccupiedTileException() {
		super();
	}

	public OccupiedTileException(String message) {
		super(message);
	}

	public OccupiedTileException(Throwable cause) {
		super(cause);
	}

	public OccupiedTileException(String message, Throwable cause) {
		super(message, cause);
	}	
	
}
