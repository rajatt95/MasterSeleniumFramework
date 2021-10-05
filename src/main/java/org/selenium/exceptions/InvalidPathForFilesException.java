package org.selenium.exceptions;

@SuppressWarnings("serial")
public class InvalidPathForFilesException extends FrameworkException {

	public InvalidPathForFilesException(String message) {
		super(message);
	}

	public InvalidPathForFilesException(String message, Throwable cause) {
		super(message, cause);
	}

}
