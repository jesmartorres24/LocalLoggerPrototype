package MMA;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class apilouise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Principles of RestAssured Library
		// given - all input details
		// when - submit the API, resource, http methods,
		// then - validate the response

		// validate the Add Place API request in your Postman is working as expected
		baseURI = "https://rahulshettyacademy.com";

		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				// setup first window > preferences > search editor > typing > tick "escape text
				// when pasting into a string literal"
				.body("{\r\n" + "    \"location\": {\r\n" + "    \"lat\": -38.383494,\r\n"
						+ "    \"lng\": 33.427362\r\n" + "},\r\n" + "    \"accuracy\": 50,\r\n"
						+ "    \"name\": \"Maristela Flores\",\r\n"
						+ "    \"phone_number\": \"(+91) 983 893 3937\",\r\n"
						+ "    \"address\": \"29, side layout, cohen 09\",\r\n" + "    \"types\": [\r\n"
						+ "        \"shoe park\",\r\n" + "        \"shop\"\r\n" + "    ],\r\n"
						+ "    \"website\": \"http://google.com\",\r\n" + "    \"language\": \"French-IN\"\r\n" + "}")
				.when().post("maps/api/place/add/json").then().assertThat().statusCode(200);

	}

}
