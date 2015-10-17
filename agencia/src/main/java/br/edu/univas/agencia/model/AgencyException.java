package br.edu.univas.agencia.model;

public class AgencyException extends Exception {

	private static final long serialVersionUID = 294525458181308190L;

	public AgencyException() {
	}

	public AgencyException(String message) {
		super(message);
	}

	public AgencyException(Throwable cause) {
		super(cause);
	}

	public AgencyException(String message, Throwable cause) {
		super(message, cause);
	}

	public AgencyException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
