package br.unicamp.Exceptions;

@SuppressWarnings("serial")
public class NotSpellerException extends Exception {

		public NotSpellerException() {
			super();
		}

		public NotSpellerException(String message) {
			super(message);
		}

		public NotSpellerException(Throwable cause) {
			super(cause);
		}

		public NotSpellerException(String message, Throwable cause) {
			super(message, cause);
		}	
}
