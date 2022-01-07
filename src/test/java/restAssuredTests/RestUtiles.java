package restAssuredTests;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtiles {
	
	public static String getFirstName() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return ("John" + generatedString);
	}
	
	public static String getLastName() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return ("Khan"+ generatedString);
	}
	
	public static String getUserName() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return ("john" + generatedString);
	}
	
	public static String getPassword() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return ("John" + generatedString);
	}
	
	public static String getEmailId() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString + "@gmail.com");
	}
	
	public static String getEmpName() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return ("John" + generatedString);
	}
	
	public static String getEmpSalary() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}
	
	public static String getEmpAge() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

}
