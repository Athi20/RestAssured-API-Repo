package api.test;

import org.testng.Assert;
import com.google.gson.Gson;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import api.payload.User;
import io.restassured.response.Response;
import api.endpoints.UserEndPoints;

public class userTests {
	Faker faker;
	User userpayload;
	
	
	@BeforeClass
	public void setUpTestData() {
		
		
		//user Faker Class for fake data
		faker =new Faker();
		userpayload =new User();
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUserName(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5,10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		System.out.println(new Gson().toJson(userpayload));
		
	}
	
	@Test(priority=1)
	public void testPostUser() {
		
		Response res=UserEndPoints.createUser(userpayload);
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	
	@Test(priority=2)
	public void testGetUser() {
		
		Response res=UserEndPoints.getUser(this.userpayload.getUserName());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(),200);
		
		
	}
	
	@Test(priority=3)
	public void testUpdateUser() {
		
		//update values
		userpayload.setUserName(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		Response res= UserEndPoints.updateUser(this.userpayload.getUserName(), userpayload);
		
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		
		
		
	}
	
	@Test(priority=4)
	public void testDeleteUser() {
		
		Response res=UserEndPoints.deleteUser(this.userpayload.getUserName());
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}

}
