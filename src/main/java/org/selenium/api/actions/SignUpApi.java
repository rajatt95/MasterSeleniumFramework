package org.selenium.api.actions;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.selenium.api.ApiRequest;
import org.selenium.pom.objects.User;
import org.selenium.pom.utils.ConfigLoader;
import org.selenium.reports.ExtentLogger;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class SignUpApi {

	private Cookies cookies;

	public Cookies getCookies() {
		return cookies;
	}

	public void setCookies(Cookies cookies) {
		this.cookies = cookies;
	}

	private String fetchRegisterNonceValueUsingGroovyGPath() {
		Response response = getAccount();

		/**
		 * We are getting this in the Response in the API call for getAccount()
		 * 
		 * <input type="hidden" id="woocommerce-register-nonce" name=
		 * "woocommerce-register-nonce" value="656055dd4d"/>
		 * 
		 * We are trying to fetch this value --> 656055dd4d
		 */
		return response.htmlPath().getString("**.findAll { it.@name == 'woocommerce-register-nonce' }.@value");
	}

	private String fetchRegisterNonceValueUsingJSoup() {
		Response response = getAccount();
		Document doc = Jsoup.parse(response.body().prettyPrint());
		/*
		 * <input type="hidden" id="woocommerce-register-nonce" name=
		 * "woocommerce-register-nonce" value="656055dd4d"/>
		 */
		Element element = doc.selectFirst("#woocommerce-register-nonce");
		return element.attr("value");
	}

	private Response getAccount() {
		Cookies cookies = new Cookies();
		Response response = 
				given().
					baseUri(ConfigLoader.getInstance().getBaseUrl()).
					cookies(cookies).
					log().all().
				when().
					get("/account").
				then().
					log().all().extract().response();

		System.out.println("Response status code: "+response.getStatusCode());
		if (response.getStatusCode() != 200) {
			throw new RuntimeException("Failed to fetch the account, HTTP status code: " + response.getStatusCode());
		}
		//ExtentLogger.pass(MarkupHelper.createCodeBlock(response.asString(), CodeLanguage.JSON));
		return response;
	}
	
	public Response register(User user) {
		Cookies cookies = new Cookies();
		
		Header header =new Header("content-type", "application/x-www-form-urlencoded");
		Headers headers=new Headers(header);
		
		HashMap<String, Object> formParams=new HashMap<>();
		formParams.put("username", user.getUsername());
		formParams.put("email", user.getEmail() );
		formParams.put("password", user.getPassword());
		formParams.put("woocommerce-register-nonce", fetchRegisterNonceValueUsingJSoup());
		formParams.put("register", "Register");
		
		/*
		 * Response response = given().
		 * baseUri(ConfigLoader.getInstance().getBaseUrl()). headers(headers).
		 * formParams(formParams). cookies(cookies). log().all(). when()
		 * .post("/account"). then(). log().all().extract().response();
		 */
		
		//Response response=ApiRequest.post(Endpoint.ACCOUNT.url, headers, formParams, cookies);
		Response response=ApiRequest.post("/account", headers, formParams, cookies);
		
		
		System.out.println("Response status code: "+response.getStatusCode());
		if (response.getStatusCode() != 302) {
			throw new RuntimeException("Failed to register the account, HTTP status code: " + response.getStatusCode());
		}
		//ExtentLogger.pass(MarkupHelper.createCodeBlock(response.asString(), CodeLanguage.JSON));
		this.cookies=response.getDetailedCookies();
		return response;
	}

}
