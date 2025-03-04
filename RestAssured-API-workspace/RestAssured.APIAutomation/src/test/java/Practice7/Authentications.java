package Practice7;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


/*
 * different typesof authentications in Rest Assured:
 * 1.BAsic
 * 2.Digest
 * 3.Preemptive
 * 4.Oauth1.0,2.0
 * 5.Bearer Token
 * 6.API key
 */
public class Authentications {
	
	@Test(priority=1)
	void TestBasicAuth() {
		
		given()
			.auth().basic("postman","password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	@Test(priority=2)
	void TestDigestAuth() {
		
		given()
			.auth().digest("postman","password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	@Test(priority=3)
	void TestPreEmptiveAuth() {
		
		given()
			.auth().preemptive().basic("postman","password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	@Test(priority=4)
	void TestBearerTokenAuth() {
		
		String bearerToken="";
		
		given()
			.headers("Authorization","Bearer"+bearerToken)
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	@Test(priority=5)
	void Test0Auth1Authentication() {
	
		
		given()
			.auth().oauth("consumerKey", "consumerKey", "accessToken", "tokenSecret")
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	@Test(priority=6)
	void Test0Auth2Authentication() {
		
		given()
			.auth().oauth2("auth2token")
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	@Test(priority=7)
	void TestAPIKeyAuthentication() {
		
		given()
			.queryParam("appid", "aaaa")
		.when()
			.get("api.openweathremap.org/data/2.5/forecast/daily?=Delhi&units=metric&cnt=7")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}

}
