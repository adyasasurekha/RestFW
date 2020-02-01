package RestApiPratice;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetRealRequest {

	@Test
	public void fetchCountryDetails()
	{
		Response resp = get
			("https://restcountries.eu/rest/v2/all");
		
		resp.then().log().all();
		
	}
}
