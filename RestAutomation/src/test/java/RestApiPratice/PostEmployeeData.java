package RestApiPratice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
public class PostEmployeeData {

	@Test
	public void addEmpData()
	{
		RequestSpecification reqPreCond = given();
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", "RaviKant1");
		jobj.put("salary", 1000000);
		jobj.put("age", 16);
	//	jobj.put("image", "");
		
		String jsonData = JSONObject.toJSONString(jobj);
		reqPreCond.body(jsonData);
		reqPreCond.contentType(ContentType.JSON);
		
		RequestSender sender = reqPreCond.when();
		Response resp = sender.post
	("http://dummy.restapiexample.com/api/v1/create");
		
		ValidatableResponse reqPostCond = resp.then();
		reqPostCond.log().all();
	}
}










