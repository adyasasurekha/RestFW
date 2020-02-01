package RestApiPratice;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class FetchExactData {

	@Test
	public void checkJsonPath()
	{
		Response resp = get
			("http://localhost:3000/posts");
		
		// Fetch All currencies object
		Object obj = resp.jsonPath().get("student.name");
			System.out.println(obj);
	}
}











