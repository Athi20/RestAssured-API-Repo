package APIChaining;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;


public class GetUser {
	
	@Test
	void testGetUser(ITestContext context) {
		
		String bearer_token="ef2a04376f928b64d75407eaa86a3c20222c8dba26ffef2de199969acb33e3a9";
		int id=(Integer)context.getAttribute("userId");
		
		given()
		 	.headers("Authentication","Bearer"+bearer_token)
		 	.contentType("application/json")
		 	.pathParam("id", id)
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
			.statusCode(200)
			.log().all();
	}

}
