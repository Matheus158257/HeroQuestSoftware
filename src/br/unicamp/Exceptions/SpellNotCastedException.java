package br.unicamp.Exceptions;

@SuppressWarnings("serial")
public class SpellNotCastedException extends Exception {

		public SpellNotCastedException() {
			super();
		}

		public SpellNotCastedException(String message) {
			super(message);
		}

		public SpellNotCastedException(Throwable cause) {
			super(cause);
		}

		public SpellNotCastedException(String message, Throwable cause) {
			super(message, cause);
		}	
}
