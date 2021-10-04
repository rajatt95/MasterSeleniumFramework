package org.selenium.api.actions;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.selenium.pom.utils.ConfigLoader;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class CartApi {

	private Cookies cookies;
	
	public Cookies getCookies() {
		return cookies;
	}

	public void setCookies(Cookies cookies) {
		this.cookies = cookies;
	}

	public CartApi() {
		super();
	}

	public CartApi(Cookies cookies) {
		super();
		this.cookies = cookies;
	}
	
	@Override
	public String toString() {
		return "CartApi [cookies=" + cookies + "]";
	}


	public Response addToCart(int productId, int quantity) {
		Header header =new Header("content-type", "application/x-www-form-urlencoded");
		Headers headers=new Headers(header);
		
		HashMap<String, Object> formParams=new HashMap<>();
		formParams.put("product_sku","");
		formParams.put("product_id", productId);
		formParams.put("quantity", quantity);
		
		
		/*If the Customer is not logged in, then only create the Object of Cookies*/
		/*If the Customer is logged in, then use the already created Cookies*/
		if(cookies==null) {
			cookies=new Cookies();
		}
		
		Response response = 
				given().
					baseUri(ConfigLoader.getInstance().getBaseUrl()).
					headers(headers).
					formParams(formParams).
					cookies(cookies).
					log().all().
				when()
					.post("/?wc-ajax=add_to_cart").
				then().
					log().all().extract().response();

		System.out.println("Response status code: "+response.getStatusCode());
		if (response.getStatusCode() != 200) {
			throw new RuntimeException("Failed to add the product "+productId+"to the Cart, HTTP status code: " + response.getStatusCode());
		}
		
		this.cookies=response.getDetailedCookies();
		return response;

	}
}


