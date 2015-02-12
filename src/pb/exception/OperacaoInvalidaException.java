package pb.exception;

public class OperacaoInvalidaException extends Exception {
	private static final long serialVersionUID = 5922494527557917728L;

	public OperacaoInvalidaException() {
	}

	public OperacaoInvalidaException(String message) {
		super(message);
	}

	public OperacaoInvalidaException(Throwable cause) {
		super(cause);
	}

	public OperacaoInvalidaException(String message, Throwable cause) {
		super(message, cause);
	}

	public OperacaoInvalidaException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
