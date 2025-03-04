package Practice6;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/*
 * how to do schema validation:
 * once you get the JSON response of the APi, go to the onlien JSON builder :
 * https://jsonformatter.org/json-to-jsonschema
 * Generate the JSON schema by using the JSON response.then do JSON schema validation using automated tests( Place
 * the schema file under resources only)
 */

public class JSONSchemaValidation {

	@Test
	void TestJSONSchema() {
		
		given()
		
		.when()
			.get("https://fakerestapi.azurewebsites.net/api/v1/Activities")
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("ActivitySchema.json"));
	}
}
