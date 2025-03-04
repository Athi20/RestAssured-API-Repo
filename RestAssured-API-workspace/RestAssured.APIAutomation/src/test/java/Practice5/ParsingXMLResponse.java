package Practice5;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class ParsingXMLResponse {
	
	@Test
	void TestParsingXML() 
	{
		
		Response res=given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1");
	
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/xml;charset=utf-8");
		
		String page_no=res.xmlPath().get("TravelInformationResponse.page").toString();
		Assert.assertEquals(page_no, "1");
	}
	
	@Test
	void usingXMLPathClass() 
	{
		
		Response res=given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1");
	
		XmlPath xmlObj=new XmlPath(res.asString());
		List <String> travellers=xmlObj.getList("TravelInformationResponse.travelers.Travelerinformation");
		
		int travellerSize=travellers.size();
		Assert.assertEquals(travellerSize, 10);
		
		
		//Verify a particaular name is present
		List<String> travelerName=res.xmlPath().getList("TravelInformationResponse.travelers.Travelerinformation.name");
		
		boolean status=false;
		for( String name : travelerName)
		{
			if(name.equals("Vijay Bharath Reddy")) {
				
				status=true;
				break;
			}
		}
		Assert.assertEquals(status, true);
		
	}
}