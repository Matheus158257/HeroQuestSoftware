package br.unicamp.Exceptions;

public class ItemNotInBagException extends Exception {

	public ItemNotInBagException() {
		super();
	}

	public ItemNotInBagException(String message) {
		super(message);
	}

	public ItemNotInBagException(Throwable cause) {
		super(cause);
	}

	public ItemNotInBagException(String message, Throwable cause) {
		super(message, cause);
	}	
	
}
