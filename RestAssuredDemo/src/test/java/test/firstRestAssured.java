package test;

import io.restassured.RestAssured;

public class firstRestAssured {

	public static void main(String[] args) {

		//getResponseBody();
		getResponseBody1();

	}

	public static void getResponseBody() {
		System.out.println("*********Get RESPONSE BODY*********");
		RestAssured.given().when().get(
				"http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1").then()
				.log().all();
	}

	public static void getResponseBody1() {
		System.out.println("*********Get RESPONSE BODY*********");
		RestAssured.given().queryParam("CUSTOMER_ID", "68195").queryParam("PASSWORD", "1234")
				.queryParam("Account_No", "1").when().get("http://demo.guru99.com/V4/sinkministatement.php?").then().log()
				.body();
	}

}
