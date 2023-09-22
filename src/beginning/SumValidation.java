package beginning;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {

	@Test
	public void sumOfCourses()
	{   
		int sum=0;
		JsonPath js=new JsonPath(Payload.Courseprice());
		int size=js.getInt("courses.size()");
	   
		for(int i=0;i<size;i++) {
			int price=js.get("courses["+i+"].price");
			int copies=js.get("courses["+i+"].copies");
			int amount=price*copies;
			sum=sum+amount;
		
		}
		System.out.println(sum);
		int purchaseAmount=js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount);
	}

}
