package RestApiPratice;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Parameter {

	@Test
	public void checkParameter()
	{
		given()
		.param("userId", "7")
		.param("id", "64")
		.pathParam("x", "posts")
		.when()
		.get("https://jsonplaceholder.typicode.com/{x}")
		.then()
		.log().all();
		
		
	}
}
