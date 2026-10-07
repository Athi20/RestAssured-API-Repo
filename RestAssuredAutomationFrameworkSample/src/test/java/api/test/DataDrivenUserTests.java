package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenUserTests {
	
	User userPayload;
	
	@BeforeClass
	public void setUpTestData() {
				
		User userpayload =new User();
		userpayload.setFirstName("Scott");
		userpayload.setLastName("Peterson");
		userpayload.setEmail("scottp@gmail.com");
		userpayload.setPassword("ABC123");
		userpayload.setPhone("1234567");		
	}
		
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostUser(User userPayload) {
		
		Response res=UserEndPoints.createUser(userPayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(),200);
		
	}
	
	@Test(priority=2,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testgetUser(String userName) {
		
		Response res=UserEndPoints.getUser(userName);
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority=3,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void deleteUserByUserName(String userName) {
		
		Response res=UserEndPoints.deleteUser(userName);
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(),204);
		
	}

}
