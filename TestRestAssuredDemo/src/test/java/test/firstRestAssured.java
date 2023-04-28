package test;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import io.restassured.RestAssured;

public class firstRestAssured {

	public static void main(String[] args) {

//		getResponseBody();
//		getResponseBody1();
//		getResponsStatus();

		readDataFromJSONFile();

		String url = "https://jsonplaceholder.typicode.com/users";
		getResponseBody(url);

	}

	public static void getResponseBody() {
		System.out.println("***** Get response body *****");
		RestAssured.given().when()
				.get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1")
				.then().log().all();

	}

	public static void getResponseBody1() {
		System.out.println("***** Get response body *****");
		RestAssured.given().queryParam("CUSTOMER_ID", "68195").queryParam("PASSWORD", "1234!")
				.queryParam("Account_No", "1").when().get("http://demo.guru99.com/V4/sinkministatement.php").then()
				.log().body();
	}

	public static void getResponsStatus() {
		int statusCode = RestAssured.given().queryParam("CUSTOMER_ID", "68195").queryParam("PASSWORD", "1234!")
				.queryParam("Account_No", "1").when().get("http://demo.guru99.com/V4/sinkministatement.php")
				.getStatusCode();
		System.out.println("The response status is " + statusCode);
		String url = "http://demo.guru99.com/V4/sinkministatement.php";
		RestAssured.given().when().get(url).then().assertThat().statusCode(200);
	}

	// Read data from json file
	private static void readDataFromJSONFile() {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("./src/test/java/test/testFile.json"));
			JSONObject jsonObject = (JSONObject) obj;
			String name = (String) jsonObject.get("Name");
			String course = (String) jsonObject.get("Course");
			JSONArray subjects = (JSONArray) jsonObject.get("Subjects");
			System.out.println("Name: " + name);
			System.out.println("Course: " + course);
			System.out.println("Subjects: ");
			Iterator iterator = subjects.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Overload getResponseBody with parameter String url then get body, status code, status line
	public static void getResponseBody(String url) {
		System.out.println("***** Get response body *****");
		RestAssured.given().when().get(url).then().log().body();

		int statusCode = RestAssured.given().when().get(url).getStatusCode();
		System.out.println("The response status code: " + statusCode);

		String statusLine = RestAssured.given().when().get(url).getStatusLine();
		System.out.println("The response status line: " + statusLine);
	}
}
