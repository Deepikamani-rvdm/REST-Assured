package tests;

import static io.restassured.RestAssured.baseURI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.matcher.RestAssuredMatchers.*;

public class XMLSchemaValidation {
	
	@Test
	
	public void schemaValidation() throws FileNotFoundException, IOException {
File file = new File("./SoapRequest/Add.xml");
		
		if(file.exists())
			System.out.println(" >> File Exists");
		
		try(FileInputStream fileInputStream = new FileInputStream(file)){
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
		
		baseURI = "http://www.dneonline.com";
		
		given().
		   contentType("text/xml").
		   accept(ContentType.XML).
		   body(requestBody).
		   
		 when().
		    post("/calculator.asmx").
		 then().
		    statusCode(200).log().all().
		 and().
		    body("//*:AddResult.text()",equalTo("5")).  // https://www.freeformatter.com/xpath-tester.html  >> for validating xpath
		 and().
		     assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("Calculator.xsd"));
		}
		
	}

}
