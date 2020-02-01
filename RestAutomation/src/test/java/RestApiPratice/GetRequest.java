package RestApiPratice;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequest {

	@Test
	public void fetchData()
	{
		Response resp = RestAssured.get
					("http://localhost:3000/posts");
		
		resp.then().log().all();
		/*int statusCode = resp.getStatusCode();
		System.out.println("Status code is: " + 
										statusCode);
		
		String responseInString = resp.asString();
		System.out.println("Complete Reponse: " + 
									responseInString);
		
		String contentType = resp.getContentType();
		System.out.println("Content Type is: " + 
										contentType);*/
	} 
}









