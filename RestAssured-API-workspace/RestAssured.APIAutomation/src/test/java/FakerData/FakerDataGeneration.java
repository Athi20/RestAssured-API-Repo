package FakerData;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONArray;


/*
 * we can use this library for API testing. can generate random data
 */
public class FakerDataGeneration {
	
	@Test
	void testGenerateDummyData() {
		
		Faker fakerObj=new Faker();
		
		String fullName= fakerObj.name().fullName();
		String firstName=fakerObj.name().firstName();
		
		System.out.println(fullName);
		System.out.println(firstName);
	}
	

}
