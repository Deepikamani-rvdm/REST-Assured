package tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;



public class DataDrivenExamples {
	
	
//	@DataProvider(name ="DataForProvider")
	public Object[][] dataForPost(){
		
//		Object[][] data = new Object[2][3];
//		data[0][0] = "Athiran";
//		data[0][1] = "Arian";
//		data[0][2] = 2;
//		
//		data[1][0] = "Seetha";
//		data[1][1] = "Jayseelan";
//		data[1][2] = 3;
//		
//		return data;
		
		return new Object[][] {
			{"RAJU", "Ramya", 1},
			{"Ram", "Seetha",9}
			
			
		};
		
		
	}
	
//	@Test(dataProvider = "DataForProvider")
	@Test
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
	
	@DataProvider (name = "DeleteObject")
	public Object[] dataForDelete() {
		return new Object[] {
				"7cd1"

		};
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
	
	
	@Parameters("userid")
	@Test
	public void testDelete_Two(String userid) {
		
		System.out.println("UserId: "+userid);
		baseURI = "http://localhost:3000/";

		   
		when().
		    delete("/subject/"+userid).
		 then().
		    statusCode(404).
		    log().all();
		   
		
		
		 
		  
	}

	

	
	

}
