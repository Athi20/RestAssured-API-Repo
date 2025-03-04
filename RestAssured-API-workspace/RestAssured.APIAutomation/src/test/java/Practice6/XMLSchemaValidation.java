package Practice6;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class XMLSchemaValidation {
	/*
	 * from XML resposne, you can convert that to schema using online xml to xsd converter)
	 */
	
	@Test
	void TestXMLSchema() {
		given()
		
		.when()
			.get("https://fakerestapi.azurewebsites.net/api/v1/Authors")
		.then()
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("Schema.xsd"));
		
	}
	
	/*
	 * the above test case has failed, didnot get time to debug
	 */

}
