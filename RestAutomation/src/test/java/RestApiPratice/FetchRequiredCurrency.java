package RestApiPratice;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class FetchRequiredCurrency {

	@Test
	public void fetch()
	{
		Response resp = get
			("https://restcountries.eu/rest/v2/all");
		String expCode = "[INrrtt]";
		ArrayList<Object> obj = resp.jsonPath().get
				("currencies.code");
		System.out.println(obj.size());
		ArrayList<String> stringList = 
				convertToStringList(obj);
		Object currancyObj = getCurrancyObj
				(expCode, stringList, resp);
		System.out.println(currancyObj);
	}
	
	public ArrayList<String> convertToStringList
							(ArrayList<Object> lst)
	{
		ArrayList<String> l = new ArrayList<String>();
		for(Object o : lst)
		{
			String str = o.toString();
			l.add(str);
		}
		return l;
	}
	public Object getCurrancyObj(String CountryCode 
			, ArrayList<String> lst, Response resp)
	{
		Object reqCurrancy = null;
		int count = 0;
		for (String str : lst) {
				if(str.equals(CountryCode))
				{
					reqCurrancy = resp.jsonPath()
						.get("currencies["+count+"]");
				}
			count++;
		}
		if(reqCurrancy == null)
		{
			throw new RuntimeException
						("Country Code invalid!!!");
		}
		return reqCurrancy;
	}
}
