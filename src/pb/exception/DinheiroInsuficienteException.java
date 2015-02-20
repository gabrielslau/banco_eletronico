package pb.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class DinheiroInsuficienteException extends Exception {

	private static final long serialVersionUID = 1L;

	public DinheiroInsuficienteException() {
	}

	public DinheiroInsuficienteException(String message) {
		super(message);
	}

	public DinheiroInsuficienteException(Throwable cause) {
		super(cause);
	}

	public DinheiroInsuficienteException(String message, Throwable cause) {
		super(message, cause);
	}

	public DinheiroInsuficienteException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
