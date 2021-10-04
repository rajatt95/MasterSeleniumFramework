package org.selenium.listeners;

import org.selenium.constants.FrameworkConstants;
import org.selenium.pom.utils.ConfigLoader;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {

	private int count = 0;
	private int retries = 1;

	@Override
	public boolean retry(ITestResult result) {

		boolean value = false;
		// if
		// (PropertyUtils.get(ConfigProperties.RETRY_FAILED_TESTS).equalsIgnoreCase("yes"))
		// {
		if (ConfigLoader.getInstance().getFailedStepsScreenshot().equalsIgnoreCase(FrameworkConstants.getYes())) {
			if (count < retries) {
				count++;
				return true;
			}
		}
		return value;
	}
}
