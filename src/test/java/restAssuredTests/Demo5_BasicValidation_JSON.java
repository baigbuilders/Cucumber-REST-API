package restAssuredTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

/*
 *Test Status Code
 *Log Response
 *Verifying Single Content In Response Body
 *Verifying Multiple Contents In Response Body
 *Setting Parameters & Headers
 */

public class Demo5_BasicValidation_JSON {
	
	//1) Test Status Code
	
	@Test(priority=1, enabled=false)
	public void testStatusCode() {
		
		given()
		// Not Required given()
		
		.when()
			.get("https://jsonplaceholder.typicode.com/posts/5")
		
		.then()
			.statusCode(200)
			.log().all();
	}
	
	// log Response
	
	@Test(priority=2, enabled= false)
	public void testLogging() {
		
		given()
			
		
		.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		
		.then()
			.statusCode(200)
			.log().all();
	}
	
	// Verifying Single content In Response Body
	
	@Test(priority=3, enabled=false)
	public void testSingleResponse() {
		
		given()
		
		
		.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		
		.then()
			.statusCode(200)
			.body("RestResponse.result.name", equalTo("India"));
	}
	
	// Verifying Multiple Contents In Response Body
	
	@Test(priority=4, enabled=false)
	public void testMultipleREsponse() {
		
		given()
		
		
		.when()
			.get("http://services.groupkt.com/country/get/all")
		
		.then()
			.body("RestResponse.result.name", hasItems("India", "Australia", "USA"));
		
	}
	
	//Setting parameters & Headers
	
	@Test(priority=5, enabled=true)
	public void testParamsAndHeaders() {
		
		given()
			.param("MyName", "XYZ")
			.header("MyHeader", "Indian")
		
		.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
			
		.then()
			.log().all();
	}

}
