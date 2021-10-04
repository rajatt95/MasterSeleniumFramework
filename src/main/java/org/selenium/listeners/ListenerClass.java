package org.selenium.listeners;

import java.util.Arrays;

import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.pom.utils.BrowserOSInfoUtils;
import org.selenium.reports.ExtentLogger;
import org.selenium.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ListenerClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initReports();
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.flushReports();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
		// ExtentReport.createTest(result.getMethod().getDescription());

		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).author());

		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).category());

		ExtentReport.addDevices();
		ExtentLogger.info(BrowserOSInfoUtils.getOS_Browser_BrowserVersionInfo());

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		// TMB
		// ExtentLogger.pass(result.getMethod().getMethodName() + " is passed");

		// Rajat
		String logText = "<b>" + result.getMethod().getMethodName() + " is passed.</b>";
		Markup markup_message = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		ExtentLogger.pass(markup_message, true);

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TMB
		// ExtentLogger.fail(result.getMethod().getMethodName() + " is failed");
		// ExtentLogger.fail(result.getMethod().getMethodName() + " is failed", true);
		ExtentLogger.fail(result.getThrowable().toString());
		// ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));

		// ExtentLogger.info("------------------------------------------------");

		// Rajat
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		ExtentLogger.fail("<details><summary><b><font color=red> Exception occured, click to see details: </font></b>"
				+ "</summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");
		String logText = "<b>" + result.getMethod().getMethodName() + " is failed.</b>";
		Markup markup_message = MarkupHelper.createLabel(logText, ExtentColor.RED);
		ExtentLogger.fail(markup_message, true);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TMB
		// ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped");
		// ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped", true);

		ExtentLogger.skip(result.getThrowable().toString());
		
		// Rajat
		String logText = "<b>" + result.getMethod().getMethodName() + " is skipped.</b>";
		Markup markup_message = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		ExtentLogger.skip(markup_message, true);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		/*
		 * As of now, we are not using it
		 */
	}

	@Override
	public void onStart(ITestContext result) {
		/*
		 * As of now, we are not using it.
		 * 
		 * We have only 1 <test> in suite. We do not have any implementation for it.
		 */
	}

	@Override
	public void onFinish(ITestContext result) {
		/*
		 * As of now, we are not using it.
		 * 
		 * We have only 1 <test> in suite. We do not have any implementation for it.
		 */
	}

}
