package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RestAssuredHeadersValidation {
	@Test
	public void IteratingHeaders() {

		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("");

		Headers allHeaders = response.headers();

		for (Header header : allHeaders) {
			System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		}

	}

	@Test
	public void GetBookHeaders() {

		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("");

		String contentType = response.header("Content-Type");
		System.out.println("Content-Type value: " + contentType);

		String serverType = response.header("Server");
		System.out.println("Server value: " + serverType);

		String acceptLanguage = response.header("Content-Encoding");
		System.out.println("Content-Encoding: " + acceptLanguage);

	}

//	@Test
//	public void WeatherMessageBody() {
//
//		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
//		RequestSpecification httpRequest = RestAssured.given();
//		Response response = httpRequest.get("/1");
//		
//		ResponseBody body = response.getBody();
//		System.out.println("Response body is: " + body.asString());
//		
//		String bodyAsString = body.asString();
//		Assert.assertEquals(bodyAsString.toLowerCase().concat("Kulas Light") /*Expected value*/, true /*Actual value*/, "Response body contains Kulas Light");
//		
//	}

	@Test
	public void getValueForASpecificJsonPath() {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/1");
		ResponseBody body = response.getBody();

		JsonPath jse = response.jsonPath();
		String val = jse.getString("email");

		System.out.println("The email value is : " + val);
		// System.out.println("The specific value is : "+body.asString());

	}

	@Test
	public void VerifyCityInJsonResponse() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();

		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();

		// Then simply query the JsonPath object to get a String value of the node
		// specified by JsonPath: City (Note: You should not put $. in the Java code)
		String city = jsonPathEvaluator.getString("[0].address.street");

		// Let us print the city variable to see what we got
		System.out.println("City received from Response " + city);

		// Validate the response
		Assert.assertEquals(city, "Kulas Light", "Correct city name received in the Response");

	}

	@Test
	public void queryParameter() {
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1";
		RequestSpecification httpRequest = RestAssured.given();
		Response res = httpRequest.queryParam("ISBN", "9781449331818").get("/Book");

		Response body = (Response) res.body();

		String rbdy = body.asString();

		JsonPath jpath = new JsonPath(rbdy);

		String title = jpath.getString("title");
		String subTitle = jpath.getString("subTitle");
		System.out.println("The book title is: " + title + "\n" + "Subtitle: " + subTitle);

	}

}
