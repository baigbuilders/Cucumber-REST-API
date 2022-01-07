package restAssuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
 *  Verifying Single Content In XML Response
 *  Verifying Multiple Contents In XML Response
 *  Verifying all The Content In XML Response In One Go
 *  Find Values using XML Path In XML Response
 *  XPath with text() function 
 */


public class Demo6_XML_Response {
	
	// Verifying Single Content In XML Response
	
	@Test
	void singleResponse() {
		
		given()
		
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
			
		.then()
			.body("CUSTOMER.ID", equalTo("15"))
			.log().all();
		
	}
	
	
	// Verifying Multiple Content In XML Response
	
	@Test(priority=2, enabled=false)
	void multipleResponse() {
		
		given()
		
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		
		.then()
			.body("CUSTOMER.ID", equalTo("15"))
			.body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
			.body("CUSTOMER.LASTNAME", equalTo("Clancy"))
			.body("CUSTOMER.STREET", equalTo("319 UPland Pl."))
			.body("CUSTOMER.CITY", equalTo("Seattle"));
	}
	
	// Verifying Multiple Content In XML Response In One Go
	
	@Test(priority=3, enabled=true)
	void multipleContentInOneGo() {
		
		given()
		
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		
		.then()
			.body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle"));
	}
	
	// Find Values using XML Path In XML Response
	
	@Test(priority=4, enabled=true)
	void testUsingXPath() {
		
		given()
		
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		
		.then()
			.body(hasXPath("/CUSTOMER/FIRSTNAME"), containsString("Bill"));
	}
	
	@Test(priority=5, enabled=true)
	void testUsingXPath1() {
		
		given()
		
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		
		.then()
			.body(hasXPath("/INVOICEList/INVOICE[text()='30']"), containsString("Bill"))
			.log().all();
		
	}

}
