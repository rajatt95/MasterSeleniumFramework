/**
 * @author Rajat Verma
 * https://www.linkedin.com/in/rajat-v-3b0685128/
 * https://github.com/rajatt95
 * https://rajatt95.github.io/
 *
 * Course: Selenium Java Test Framework & Best Practices - Masterclass (https://www.udemy.com/course/selenium-java-test-framework/)
 * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
 */

/***************************************************/

package org.selenium.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {

	/*
	 * public static BillingAddress deSerializationJSON(InputStream is,
	 * BillingAddress billingAddress) throws IOException { ObjectMapper objectMapper
	 * = new ObjectMapper(); return objectMapper.readValue(is,
	 * billingAddress.getClass()); }
	 */

	/* Generic method -. can be used for any class */
	public static <T> T deSerializationJSON(String fileName, Class<T> T) throws IOException {
		/* myBillingAddress.json --> has to be present under src/test/resources */
		InputStream is = JacksonUtils.class.getClassLoader().getResourceAsStream(fileName);
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(is, T);
	}

}