package serailzationAndDeseralization;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class StudentAPITestNoSerialization {
	
	public static HashMap map = new HashMap();
	
	// Post requests Creates A New Student Record
	@Test(priority=1, enabled=true)
	void createNewStudent() {
		
		map.put("id", "101");
		map.put("firstName", "Xyz");
		map.put("lastName", "Abc");
		map.put("emailId", "abc@gmail.com");
		map.put("programme", "Manager");
		
		
		ArrayList<String> coursesList = new ArrayList<String>();
		coursesList.add("Java");
		coursesList.add("Selenium");
		
		map.put("courses", "coursesList");
		
		given()
			.contentType(ContentType.JSON)
			.body(map)
		
		.when()
			.post("http://localhost:8085/student")
		
		.then()
			.statusCode(201)
			.assertThat()
			.body("msg", equalTo("Student added"));
	}
	
	@Test(priority=2, enabled= true)
	void getStudentRecord() {
		
		given()
			
		
		.when()
			.get("http://localhost:8085/student/101")
		
		.then()
			.statusCode(200)
			.assertThat()
			.body("id", equalTo(101))
			.log().all();
		
	}

}
