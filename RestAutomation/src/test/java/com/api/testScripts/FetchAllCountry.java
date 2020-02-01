package com.api.testScripts;

import org.testng.annotations.Test;

import com.api.rootRepo.RootClass;

import io.restassured.response.Response;

public class FetchAllCountry extends RootClass{

	@Test
	public void getCountries()
	{
		String apiData = config.getPropertyObject
						("fetchAllDetailCountries");
		
		Response resp = config.executeRequest(apiData);
		
		resp.then().log().all();
		
	}
}
