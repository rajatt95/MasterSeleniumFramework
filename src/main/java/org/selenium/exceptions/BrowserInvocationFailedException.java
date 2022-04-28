/**
 * @author Rajat Verma
 * https://www.linkedin.com/in/rajat-v-3b0685128/
 * https://github.com/rajatt95
 * https://rajatt95.github.io/
 *
 * Course: Selenium Java Test Framework & Best Practices - Masterclass (https://www.udemy.com/course/selenium-java-test-framework/)
 * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
 * Tutor: Amuthan Sakthivel (https://www.testingminibytes.com/)
 */

/***************************************************/


package org.selenium.exceptions;

@SuppressWarnings("serial")
public class BrowserInvocationFailedException extends FrameworkException {
	public BrowserInvocationFailedException(String message) {
		super(message);
	}

	public BrowserInvocationFailedException(String message, Throwable cause) {
		super(message, cause);
	}

}
