package com.api.testScripts;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.api.rootRepo.RootClass;
import io.restassured.response.Response;

@Listeners(com.api.rootRepo.TakeListner.class)
public class GetEmployeeIdTest extends RootClass{

	@Test
	public void fetchEmployeeID()
	{
		String apiData = config.getPropertyObject
								("getEmployeeIDTest");
		
		Response resp = config.executeRequest(apiData);
	//	Assert.fail();
		resp.then().log().all();
	}
}
