package restAssuredTests;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo3_PUT_Request {
	
	
	public static HashMap map = new HashMap();
	
	String empName = RestUtiles.getEmpName();
	String empSalary = RestUtiles.getEmpSalary();
	String empAge = RestUtiles.getEmpAge();
	int emp_id = 11254;
	
	@BeforeClass
	public void putData() {
		
		map.put("Name", empName);
		map.put("Salary", empSalary);
		map.put("age", empAge);
		
		RestAssured.baseURI="http://dummy.restapiexample.cpm/api/v1";
		RestAssured.basePath="/update/"+emp_id;
	}
	
	@Test
	public void testPUT() {
		
		given()
			.contentType("application/json")
			.body(map)
		
		.when()
			.put()
		
		.then()
			.statusCode(200)
			.log().all();
		
	}

}
