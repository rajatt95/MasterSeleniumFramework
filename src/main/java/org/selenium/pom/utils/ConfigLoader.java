package org.selenium.pom.utils;

import java.util.Properties;

import org.selenium.pom.enums.EnvType;

/*Singleton Design pattern*/
public class ConfigLoader {

	private static final String SEND_EMAIL_TO_USERS = "send_email_to_users";
	private static final String OVERRIDE_REPORTS = "override_reports";
	private static final String SKIPPED_STEPS_SCREENSHOT = "skipped_steps_screenshot";
	private static final String PASSED_STEPS_SCREENSHOT = "passed_steps_screenshot";
	private static final String FAILED_STEPS_SCREENSHOT = "failed_steps_screenshot";
	private static final String RETRY_FAILED_TESTS = "retry_failed_tests";
	private static final String PASSWORD = "password";
	private static final String USERNAME = "username";
	private static final String BASE_URL = "baseUrl";
	private static final String REQUEST_DETAILS_IN_REPORTS = "request_details_in_reports";
	
	
	
	private static final String RESOURCES_PATH = System.getProperty("user.dir") + "/src/test/resources/";
	private Properties properties;
	// private final Properties properties;
	private static ConfigLoader configLoader;

	
	
	private ConfigLoader() {

		/* Setting EnvType.STAGE as default environment */
		/*
		 * This will check for the env value from Jenkins/Maven first. If it does not get any
		 * input from Jenkins/mvn cmd line, then, will take stg_config.properties file as
		 * default
		 */
		String env = System.getProperty("env", EnvType.STAGE.toString());

		switch (EnvType.valueOf(env)) {
		/* Only STAGE is working, Rest are taken for example */

		case STAGE: {
			properties = PropertyUtils.propertyLoader(RESOURCES_PATH + "stg_config.properties");
			break;
		}
		case INT: {
			properties = PropertyUtils.propertyLoader(RESOURCES_PATH + "int_config.properties");
			break;
		}
		case QA: {
			properties = PropertyUtils.propertyLoader(RESOURCES_PATH + "qa_config.properties");
			break;
		}
		case PRODUCTION: {
			properties = PropertyUtils.propertyLoader(RESOURCES_PATH + "prod_config.properties");
			break;
		}
		default: {
			throw new IllegalStateException("Invalid EnvType: " + env);
		}

		}
	}

	public static ConfigLoader getInstance() {
		if (configLoader == null) {
			configLoader = new ConfigLoader();
		}
		return configLoader;
	}

	public String getBaseUrl() {
		String prop = properties.getProperty(BASE_URL);
		if (prop != null) {
			return prop;
		} else {
			throw new RuntimeException("Property "+BASE_URL+" is not specified in the config.properties file");
		}
	}

	public String getUsername() {
		String prop = properties.getProperty(USERNAME);
		if (prop != null) {
			return prop;
		} else {
			throw new RuntimeException("Property "+USERNAME+" is not specified in the config.properties file");
		}
	}

	public String getPassword() {
		String prop = properties.getProperty(PASSWORD);
		if (prop != null) {
			return prop;
		} else {
			throw new RuntimeException("Property "+PASSWORD+" is not specified in the config.properties file");
		}
	}

	public String getFailedStepsScreenshot() {
		String prop = properties.getProperty(FAILED_STEPS_SCREENSHOT);
		if (prop != null) {
			return prop.trim();
		} else {
			throw new RuntimeException(
					"Property "+FAILED_STEPS_SCREENSHOT+" is not specified in the config.properties file");
		}
	}

	public String getPassedStepsScreenshot() {
		String prop = properties.getProperty(PASSED_STEPS_SCREENSHOT);
		if (prop != null) {
			return prop.trim();
		} else {
			throw new RuntimeException(
					"Property "+PASSED_STEPS_SCREENSHOT+" is not specified in the config.properties file");
		}
	}

	public String getSkippedStepsScreenshot() {
		String prop = properties.getProperty(SKIPPED_STEPS_SCREENSHOT);
		if (prop != null) {
			return prop.trim();
		} else {
			throw new RuntimeException(
					"Property "+SKIPPED_STEPS_SCREENSHOT+" is not specified in the config.properties file");
		}
	}
	
	public String getRetryFailedTests() {
		String prop = properties.getProperty(RETRY_FAILED_TESTS);
		if (prop != null) {
			return prop.trim();
		} else {
			throw new RuntimeException(
					"Property "+RETRY_FAILED_TESTS+" is not specified in the config.properties file");
		}
	}
	

	public String getOverrideReports() {
		String prop = properties.getProperty(OVERRIDE_REPORTS);
		if (prop != null) {
			return prop.trim();
		} else {
			throw new RuntimeException("Property "+OVERRIDE_REPORTS+" is not specified in the config.properties file");
		}
	}

	public String getSendEmailToUsers() {
		String prop = properties.getProperty(SEND_EMAIL_TO_USERS);
		if (prop != null) {
			return prop.trim();
		} else {
			throw new RuntimeException("Property "+SEND_EMAIL_TO_USERS+" is not specified in the config.properties file");
		}
	}

	public String getRequestDetailsInReports() {
		String prop = properties.getProperty(REQUEST_DETAILS_IN_REPORTS);
		if (prop != null) {
			return prop.trim();
		} else {
			throw new RuntimeException("Property "+REQUEST_DETAILS_IN_REPORTS+" is not specified in the config.properties file");
		}
	}
	
}


