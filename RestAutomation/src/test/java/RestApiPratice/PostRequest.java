package RestApiPratice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {

	@Test
	public void addData()
	{
		RequestSpecification req = RestAssured.given();
		
		JSONObject jobj = new JSONObject();
		jobj.put("id", 2);
		jobj.put("author", "radha");
		jobj.put("title", "TestEngineer");
		
		String jobjInJson = JSONObject.toJSONString(jobj);
		req.body(jobjInJson);
		req.contentType(ContentType.JSON);
		
		Response resp = req.post
					("http://localhost:3000/posts");
		int statusCode = resp.getStatusCode();
		System.out.println("Status code is: " + 
										statusCode);
		
		String responseInString = resp.asString();
		System.out.println("Complete Reponse: " + 
									responseInString);
		
		String contentType = resp.getContentType();
		System.out.println("Content Type is: " + 
										contentType);

	}
}









