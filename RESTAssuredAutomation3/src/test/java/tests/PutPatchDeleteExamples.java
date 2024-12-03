package tests;

import static io.restassured.RestAssured.*;


import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteExamples {
	
	@Test
	public void testPut() {
		
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Deepika");
		request.put("job", "Teacher");
		
		System.out.print(request.toJSONString());
		
		baseURI = "https://dummy.restapiexample.com/public/api";
		
		given().
		   header("Content-Type", "application/json").
		   contentType(ContentType.JSON).accept(ContentType.JSON).
		   body(request.toJSONString()).
		  when().
		   put("/v1/update/21").
		  then().
		   statusCode(409).
		     log().all();
		  
		
		
		
		
		
	}
	
	@Test
	public void testPatch() {
		
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Deepika");
		request.put("job", "Teacher");
		
		System.out.print(request.toJSONString());
		
		baseURI = "https://dummy.restapiexample.com";
		
		given().
		   header("Content-Type", "application/json").
		   contentType(ContentType.JSON).accept(ContentType.JSON).
		   body(request.toJSONString()).
		  when().
		   patch("/api/v1/update/21/").
		  then().
		   statusCode(409).
		     log().all();
		  
	}
	
	@Test
	public void testDelete() {
		

		
		baseURI = "https://dummy.restapiexample.com";
		
		
		  when().
		   delete("/api/v1/delete/2/").
		  then().
		   statusCode(409).
		     log().all();
		  
	}
	
	

	
	

	
	

}
