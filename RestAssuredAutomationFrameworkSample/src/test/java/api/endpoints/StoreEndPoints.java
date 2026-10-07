package api.endpoints;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {
	
	//CRUD methods implementation
	public static Response createStore(Store payload) {
		
		Response res=given()
						.contentType(ContentType.JSON)// we have to check Swagger to see what mandatory values we need to send
						.body(payload)
					.when()
						.post(Routes.post_url);
		
		return res;
	}
	
	
	public static Response readStore(String storeName) {
			
			Response res=given()
							.pathParam("storeName",storeName)
						.when()
							.get(Routes.get_url);
			
			return res;
		}
	
	public static Response updateStore(String storeName, Store playload) {
		
		Response res=given()
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)// we have to check Swagger to see what mandatory values we need to send
						.body(payload)
						.pathParam("storeName",storeName)
					.when()
						.put(Routes.update_url);
		
		return res;
	}

}
