package com.api.rootRepo;

import org.testng.annotations.BeforeSuite;
import static io.restassured.RestAssured.*;
public class RootClass {

	public ApiConfig config = new ApiConfig();
	
	@BeforeSuite
	public void configBS()
	{
		/*baseURI = "http://restcountries.eu/";
		basePath = "rest/v2/";*/
	}
}
