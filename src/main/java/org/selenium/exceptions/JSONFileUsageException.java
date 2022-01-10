package org.selenium.exceptions;

@SuppressWarnings("serial")
public class JSONFileUsageException extends FrameworkException {

	public JSONFileUsageException(String message) {
		super(message);
	}

	public JSONFileUsageException(String message, Throwable cause) {
		super(message, cause);
	}
}
