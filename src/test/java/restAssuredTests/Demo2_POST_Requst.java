package restAssuredTests;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class Demo2_POST_Requst {
	
	public static HashMap map = new HashMap();
	
	
	@BeforeClass
	public void postData() {
		map.put("FirstName", RestUtiles.getFirstName());
		map.put("LastName", RestUtiles.getLastName());
		map.put("UserName", RestUtiles.getLastName());
		map.put("Password", RestUtiles.getPassword());
		map.put("Email", RestUtiles.getEmailId());
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RestAssured.basePath="/register";
	}
	
	@Test
	public void testPost() {
		given()
			.contentType("appliction/json")
			.body(map)
			
		.when()
			.post()
			
		.then()
			.statusCode(201)
			.and()
			.body("SuccessCode", equalTo("OPERATION_SUCCESS"))
			.and()
			.body("Message", equalTo("Operation completed successfully"));
	}

}
