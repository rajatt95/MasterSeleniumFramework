package org.selenium.exceptions;

@SuppressWarnings("serial")
public class InvalidPathForExcelException extends InvalidPathForFilesException {

	public InvalidPathForExcelException(String message) {

		super(message);
	}

	public InvalidPathForExcelException(String message, Throwable cause) {
		super(message, cause);
	}
}
