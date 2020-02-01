package RestApiPratice;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CheckResponseTIme {

	@Test
	public void assertionTestForRespTime()
	{
		Response resp = given()
				.param("userId", "7")
				.param("id", "64")
				.pathParam("x", "posts")
				.when()
	.get("https://jsonplaceholder.typicode.com/{x}");
		
		/*resp.then().assertThat().time
						(Matchers.lessThan(1000L));*/
		
		resp.then().assertThat().time
					(Matchers.greaterThan(1000L));
		
		long actTimeInMS = resp.time();
	//	Assert.assertTrue(actTimeInMS < 2000);
		
		long actTimeInSec = resp.timeIn
								(TimeUnit.SECONDS);
	//	Assert.assertTrue(actTimeInSec < 2);
				
		System.out.println("Time in MS: " + actTimeInMS);
		System.out.println("Time in Sec: " + actTimeInSec);
	}
}












