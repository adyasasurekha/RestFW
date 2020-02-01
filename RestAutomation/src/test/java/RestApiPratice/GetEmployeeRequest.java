package RestApiPratice;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class GetEmployeeRequest {

	@Test
	public void fetchEmpDetails()
	{
		Response resp = get("http://dummy.restapiexample.com/api/v1/employee/29951");
		resp.then().log().all();
	}
}
