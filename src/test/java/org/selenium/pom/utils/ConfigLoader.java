package org.selenium.pom.utils;

import java.util.Properties;

import org.selenium.pom.constants.EnvType;

/*Singleton Design pattern*/
public class ConfigLoader {

	private static final String RESOURCES_PATH = System.getProperty("user.dir") + "/src/test/resources/";
	private Properties properties;
	//private final Properties properties;
	private static ConfigLoader configLoader;

	private ConfigLoader() {

		/* Setting EnvType.STAGE as default environment */
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

		/*
		 * case STAGE -> properties = PropertyUtils.propertyLoader(RESOURCES_PATH +
		 * "stg_config.properties"); case INT -> properties =
		 * PropertyUtils.propertyLoader(RESOURCES_PATH + "int_config.properties"); case
		 * QA -> properties = PropertyUtils.propertyLoader(RESOURCES_PATH +
		 * "qa_config.properties"); case PRODUCTION -> properties =
		 * PropertyUtils.propertyLoader(RESOURCES_PATH + "prod_config.properties");
		 * default -> throw new IllegalStateException("Invalid EnvType: " + env);
		 */}
	}

	public static ConfigLoader getInstance() {
		if (configLoader == null) {
			configLoader = new ConfigLoader();
		}
		return configLoader;
	}

	public String getBaseUrl() {
		String prop = properties.getProperty("baseUrl");
		if (prop != null) {
			return prop;
		} else {
			throw new RuntimeException("Property baseUrl is not specified in the config.properties file");
		}
	}

	public String getUsername() {
		String prop = properties.getProperty("username");
		if (prop != null) {
			return prop;
		} else {
			throw new RuntimeException("Property username is not specified in the config.properties file");
		}
	}

	public String getPassword() {
		String prop = properties.getProperty("password");
		if (prop != null) {
			return prop;
		} else {
			throw new RuntimeException("Property password is not specified in the config.properties file");
		}
	}

}
