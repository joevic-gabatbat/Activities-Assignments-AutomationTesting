package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredPostRequest {

	@Test(enabled = false)
	public void userRegistrationSuccessful() {

		RestAssured.baseURI = "https://demoqa.com/Account/v1/User";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("userName", "test_rest");
		requestParams.put("password", "Testrest@123");
		request.body(requestParams.toJSONString());
		Response response = request.post();
		Response body = (Response) response.body();

		System.out.println(response.getStatusLine());
		System.out.println(body.asString());

	}
}
