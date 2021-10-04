package org.selenium.pom.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Cookie;

import io.restassured.http.Cookies;

public class CookieUtils {

	public List<Cookie> convertRestAssuredCookiesToSeleniumCookies(Cookies cookies) {
		
		List<io.restassured.http.Cookie> restAssuredCookies=new ArrayList<>();
		restAssuredCookies=cookies.asList();
		
		List<Cookie> seleniumCookies=new ArrayList<>();
		
		for(io.restassured.http.Cookie restAssuredCookie: restAssuredCookies) {
			seleniumCookies.add(
					new Cookie(
							restAssuredCookie.getName(), 
							restAssuredCookie.getValue(),
							restAssuredCookie.getDomain(),
							restAssuredCookie.getPath(),
							restAssuredCookie.getExpiryDate(),
							restAssuredCookie.isSecured(),
							restAssuredCookie.isHttpOnly()
								
							/*Present in Selenium 4.x*/
							//restAssuredCookie.getSameSite()
							));
		}
		
		return seleniumCookies;
	}
}
