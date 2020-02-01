package RestApiPratice;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class CheckAssertion {

	@Test
	public void assertionTest()
	{
		Response resp = given()
		.param("userId", "7")
		.param("id", "64")
		.pathParam("x", "posts")
		.when()
	.get("https://jsonplaceholder.typicode.com/{x}");
		
		resp.then().assertThat().statusCode(200);
resp.then().assertThat().contentType(ContentType.JSON);

		// To Fetch All Headers
		Headers headers = resp.getHeaders();
		System.out.println(headers);
		System.out.println("======================");
		
		// TO fetch specific header
	String contType = resp.getHeader("Content-Type");
		System.out.println(contType);
	
		// To fetch only body
		System.out.println(resp.asString());
	}
}










