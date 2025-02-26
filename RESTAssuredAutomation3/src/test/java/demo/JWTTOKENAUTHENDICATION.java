package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;


public class JWTTOKENAUTHENDICATION {
	
	@Test
	public void testLoginAndGetToken() {
		
		// Login request body
		String requestBody = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\"}";
		
		//Sending login request
		Response response = given()
				.contentType(ContentType.JSON)
				.body(requestBody)
				.when()
				.post("https://reqres.in/api/login");
		
		// Validate response
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//Extract token from response
		String token = response.jsonPath().getString("token");
		System.out.println("Generated Token: " + token);
		
		// Ensure token is not null
		Assert.assertNotNull(token);
	}
	
	
	

}
