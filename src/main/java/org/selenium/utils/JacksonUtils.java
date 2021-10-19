package org.selenium.utils;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

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