package com.api.testScripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.rootRepo.RootClass;

import io.restassured.response.Response;

@Listeners(com.api.rootRepo.TakeListner.class)
public class PostObjectInserverTest extends RootClass{

	@Test
	public void createData()
	{
		String apiData = config.getPropertyObject
									("createPost");
		Response resp = config.executeRequest(apiData);
		resp.then().log().all();
	}
}
