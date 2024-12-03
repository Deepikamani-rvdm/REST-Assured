package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


//https://restful-api.dev - dummy rest API

public class TestOne {
	
	//java code
	
		public static void main(String[] name) {
			
	Response response = get("https://api.restful-api.dev/objects");
			
			System.out.println(response.getStatusCode());
			
			System.out.println(response.getTime());
			
		}

	
	@Test
	public void test_1() {
		
		
		Response response = get("https://api.restful-api.dev/objects");
		
		System.out.println(response.getStatusCode());
		
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	
	@Test
	public void test_2() {
		
		baseURI ="https://api.restful-api.dev";
		
		given().
		  get("/objects?id=3&id=5&id=10").
		then().
		  statusCode(200).
		  body("[0].id",equalTo("3"));
		
	}
	
	
	
	

}
