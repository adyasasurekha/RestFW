package RestApiPratice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BulkData {

	@Test
	public void postBulkdata() throws IOException
	{
		RequestSpecification req = RestAssured.given();
		Path path = Paths.get("C:\\Users\\Windows 8.1"
		+ "\\Desktop\\JDBC Data\\Testdata.json");
		
		byte[] data = Files.readAllBytes(path);
		
		String jsonData = new String(data);
		
		req.contentType(ContentType.JSON);
		req.body(jsonData);
		
		Response resp = req.post
				("http://localhost:3000/comments");
		
		resp.then().log().all();
		
		
	}
}











