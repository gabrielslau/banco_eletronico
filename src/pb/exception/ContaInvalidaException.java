package pb.exception;

public class ContaInvalidaException extends Exception {
	private static final long serialVersionUID = -2357408465106049510L;

	public ContaInvalidaException() {
	}

	public ContaInvalidaException(String message) {
		super(message);
	}

	public ContaInvalidaException(Throwable cause) {
		super(cause);
	}

	public ContaInvalidaException(String message, Throwable cause) {
		super(message, cause);
	}

	public ContaInvalidaException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
