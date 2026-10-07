package api.endpoints;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import api.payload.User;

public class UserEndPoints {
	
	//Define CRUD implementations
	
	public static Response createUser(User payload) {
		
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
		.when()
			.post(Routes.post_url);
		
		res.then().log().all();
		return res;
			
		
	}
	
	public static Response getUser(String userName) {
		
		Response res=given()
				.pathParam("userName", userName)
				.log().all()
		.when()
			.get(Routes.get_url);
		
		return res;
			
		
	}
	
	public static Response updateUser(String userName,User payload) {
		
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("userName", userName)
		.when()
			.post(Routes.update_url);
		
		return res;
				
	}
	public static Response deleteUser(String userName) {
			
			Response res=given()
					.pathParam("userName",userName)
				.when()
				.post(Routes.delete_url);
			
			return res;
					
		}

}
