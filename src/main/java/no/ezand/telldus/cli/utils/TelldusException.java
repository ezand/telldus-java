package no.ezand.telldus.cli.utils;

public class TelldusException extends RuntimeException {
	public TelldusException() {
	}

	public TelldusException(Throwable cause) {
		super(cause);
	}

	public TelldusException(String message) {
		super(message);
	}

	public TelldusException(String message, Throwable cause) {
		super(message, cause);
	}

	public TelldusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
