package org.selenium.exceptions;

@SuppressWarnings("serial")
public class InvalidPathForJSONFileException extends InvalidPathForFilesException {

	public InvalidPathForJSONFileException(String message) {
		super(message);
	}

	public InvalidPathForJSONFileException(String message, Throwable cause) {
		super(message, cause);
	}

}
