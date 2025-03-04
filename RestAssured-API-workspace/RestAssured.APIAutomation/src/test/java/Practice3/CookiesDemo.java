package Practice3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.Set;

public class CookiesDemo {

	@Test
	void TestCookies() {
		given()
		
		.when()
			.get("https://www.google.com")
				
		.then()
			.cookies("AEC","dsfdgd")
			.log().all();
	}
	
	@Test
	void getCookieInfo() {
		Response res=given()
		
		.when()
			.get("https://www.google.com");
		
		String cookie_value=res.getCookie("AEC");
		System.out.println(cookie_value);
		
	}
	
	@Test(priority=1)
	void getAllCookiesInfo() {
		
		Response res=given()
			
		.when()
			.get("https://www.google.com");
		
		Map<String, String> cookies_value=res.getCookies();
		
		Set<String> cookie_keys=cookies_value.keySet();
		
		for(String k:cookie_keys) {
			System.out.println(k +":"+res.getCookie(k));
		}
		
			
	}
}
