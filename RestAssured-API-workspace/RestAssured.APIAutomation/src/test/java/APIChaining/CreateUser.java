package APIChaining;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateUser {

	@Test
	void test_createUser(ITestContext context) {
		
		//lets use Faker library to get random data
		Faker faker=new Faker();
		
		//lets form the request body first--> using JSOnObject
		
		JSONObject data=new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "female");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearer_token="ef2a04376f928b64d75407eaa86a3c20222c8dba26ffef2de199969acb33e3a9";
		
		int id=given()
			.headers("Authentication","Bearer"+bearer_token)
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");
		
		System.out.println("Generated id"+ id);
		
		context.setAttribute("userId",id);
		
		//to set the attribute at the suite level and run the test casese separately
		//context.getSuite().setAttribute("userId",id)
		
		
		
	}
}
