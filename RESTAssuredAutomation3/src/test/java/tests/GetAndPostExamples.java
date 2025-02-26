package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class GetAndPostExamples {
	
//	@Test
	public void testGet() {
		baseURI = "https://api.restful-api.dev";
		given().
		get("/objects").
		then().
		statusCode(200).
		body("[0].id",equalTo("1")).
		body("[0].name",equalTo("Google Pixel 6 Pro")).
		body("name",hasItems("Apple iPhone 12 Mini, 256GB, Blue", "Google Pixel 6 Pro"));
//		body("data.price",closeTo(1849.99,0.01));
	}
	
	@Test
	public void testPost() {
		
		Map<String, Object>map = new HashMap<String, Object>();
		
//		map.put("name", "Deepika");
//		map.put("job", "Teacher");
//		System.out.println(map);
//		
		JSONObject request = new JSONObject(map);
		
		request.put("name", "Deepika");
		request.put("job", "Teacher");
		
		System.out.print(request.toJSONString());
		
		baseURI = "https://dummy.restapiexample.com/api";
		
		given().
		   header("Content-Type", "application/json").
		   contentType(ContentType.JSON).accept(ContentType.JSON).
		   body(request.toJSONString()).
		  when().
		   post("/v1/create").
		  then().
		   statusCode(200).
		     log().all();
		  
		
		
		
		
		
	}
	
	

}
