package restapitesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class WeatherApiTest {
	@Test
	public void WeatherMessageBody()
	{
	 RestAssured.baseURI = "http://restapi.demoqa.com";
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.get("/utilities/weather/city/Hyderabad");
	 
	 // Retrieve the body of the Response
	 ResponseBody body = response.getBody();
	 
	 // By using the ResponseBody.asString() method, we can convert the  body
	 // into the string representation.
	 System.out.println("Response Body is: " + body.asString());
	}
	
	
	@Test
	public void VerifyCityInJsonResponse()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");

		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();

		// Then simply query the JsonPath object to get a String value of the node
		// specified by JsonPath: City (Note: You should not put $. in the Java code)
		String city = jsonPathEvaluator.get("City");

		// Let us print the city variable to see what we got
		System.out.println("City received from Response " + city);

		// Validate the response
		Assert.assertEquals(city, "Hyderabad", "Correct city name received in the Response");

	}
}
