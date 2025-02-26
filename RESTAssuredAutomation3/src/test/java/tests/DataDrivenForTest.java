package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenForTest extends DataForTest{
	
//	@Test(dataProvider = "DataForProvider")
	public void testPost_DATA(String firstName, String lastName, int ID) {
		
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", firstName);
		request.put("LastName", lastName);
		request.put("SubjectId", ID);
		
		

		
		baseURI = "http://localhost:3000/";
		
		given().
		   header("Content-Type", "application/json").
		   contentType(ContentType.JSON).accept(ContentType.JSON).
		   body(request.toJSONString()).
		  when().
		   post("/subject").
		  then().
		   statusCode(201).
		     log().all();
		  
	}
	
	
	
	@Test (dataProvider = "DeleteObject")
	public void testDelete_One(String SubjectId) {
		
		
		baseURI = "http://localhost:3000/";

		   
		when().
		    delete("/subject/"+SubjectId).
		 then().
		    statusCode(200).
		    log().all();
		   
		
		
		 
		  
	}

}
