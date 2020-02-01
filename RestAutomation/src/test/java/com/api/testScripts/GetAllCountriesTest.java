package com.api.testScripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.rootRepo.RootClass;

import io.restassured.response.Response;

@Listeners(com.api.rootRepo.TakeListner.class)
public class GetAllCountriesTest extends RootClass{

	@Test
	public void fetchAllCountries()
	{
		String apiData = config.getPropertyObject
								("getAllCountries");
		Response resp = config.executeRequest(apiData);
		
		resp.then().log().all();
	}
}
