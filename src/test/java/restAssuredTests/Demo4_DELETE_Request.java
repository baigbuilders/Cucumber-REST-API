package restAssuredTests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Demo4_DELETE_Request {
	
	@Test
	public void deleteData() {
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees/";
		RestAssured.basePath="/delete/11";
		
	Response response = 	
		given()
			// Nothing required inside given() for deleting.
		
		.when()
			.delete()
		
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all()
			.extract().response();
	
			String jsonAsString = response.asString();
			Assert.assertEquals(jsonAsString.contains("Successfully deleted Records"), true);
	}

}
