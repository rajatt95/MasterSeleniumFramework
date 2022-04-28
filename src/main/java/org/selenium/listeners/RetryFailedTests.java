package org.selenium.listeners;

import org.selenium.utils.ConfigLoader;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static org.selenium.constants.FrameworkConstants.YES;

public class RetryFailedTests implements IRetryAnalyzer {

	private int count = 0;
	private int retries = 1;

	@Override
	public boolean retry(ITestResult result) {

		boolean value = false;
		if (ConfigLoader.getInstance().getRetryFailedTests().equalsIgnoreCase(YES)) {
			if (count < retries) {
				count++;
				return true;
			}
		}
		return value;
	}
}
