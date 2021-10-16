package org.selenium.api;

import static io.restassured.RestAssured.given;

import java.io.PrintStream;
import java.io.StringWriter;
import java.util.HashMap;

import org.apache.commons.io.output.WriterOutputStream;
import org.selenium.constants.FrameworkConstants;
import org.selenium.pom.utils.ConfigLoader;
import org.selenium.reports.ExtentLogger;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ApiRequest extends SpecBuilder {

	public static Response post(String endPoint, Headers headers, HashMap<String, Object> formParams, Cookies cookies) {

		StringWriter writerRequest;
		PrintStream captor;
		writerRequest = new StringWriter();
		captor = new PrintStream(new WriterOutputStream(writerRequest), true);

		Response response = 
				given(getRequestSpec()).
					filter(new RequestLoggingFilter(captor)).
					//filter(new ResponseLoggingFilter(captor)).
					headers(headers).
					formParams(formParams).
					cookies(cookies)
				.when().
					post(endPoint).
				then().
					spec(getResponseSpec()).
					extract().response();

		printDetailsInExtentReport(writerRequest, response);
		return response;
	}

	private static void printDetailsInExtentReport(StringWriter writer, Response response) {
		if (ConfigLoader.getInstance().getRequestDetailsInReports().equalsIgnoreCase(FrameworkConstants.getYes())) {
			ExtentLogger.info("<details><summary><i><font color=black> Request details: </font></i>" + "</summary>"
					+ "<pre>" + writer.toString() + "</pre>" + "</details> \n");
			//ExtentLogger.info("<details><summary><i><font color=black> Response details: </font></i>" + "</summary>"
					//+ "<pre>" + response.toString() + "</pre>" + "</details> \n");
					//+ "<pre>" + response + "</pre>" + "</details> \n");
					//+ "<pre>" + response.asString() + "</pre>" + "</details> \n");
					//+ "<pre>" + response.asPrettyString() + "</pre>" + "</details> \n");
					//+ "<pre>" + response.peek() + "</pre>" + "</details> \n");
					//+ "<pre>" + response.print() + "</pre>" + "</details> \n");
					//+ response.print() + "</details> \n");
		}
	}

	public static Response get(String endPoint, Cookies cookies) {

		StringWriter writer;
		PrintStream captor;
		writer = new StringWriter();
		captor = new PrintStream(new WriterOutputStream(writer), true);

		Response response = 
			given(getRequestSpec()).
				filter(new RequestLoggingFilter(captor)).
				//filter(new ResponseLoggingFilter(captor)).
				cookies(cookies).
			when().
				get(endPoint).
			then()
				.spec(getResponseSpec()).
				extract().response();

		printDetailsInExtentReport(writer, response);
		return response;

	}
}
