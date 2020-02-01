package RestApiPratice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostBulkData {

	@Test
	public void addBulkData()
	{
		RequestSpecification req = RestAssured.given();
		
		JSONObject jobj1 = new JSONObject();
		jobj1.put("Java", 75);
		jobj1.put("Sql", 80);
		jobj1.put("Api", 90);
		
		JSONObject jobj2 = new JSONObject();
		jobj2.put("name", "shreya");
		jobj2.put("rollnum", 25);
		jobj2.put("subject", jobj1);
		jobj2.put("status", "pass");
		
		JSONObject jobj3 = new JSONObject();
		jobj3.put("student", jobj2);
		
		String jsonObj = JSONObject.toJSONString(jobj3);
		req.body(jsonObj);
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












