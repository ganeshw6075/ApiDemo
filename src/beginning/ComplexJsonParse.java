package beginning;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	
	public static void main(String[] args) {
		
		JsonPath js=new JsonPath(Payload.Courseprice());
		
		// Print No of courses returned by API
		int size=js.getInt("courses.size()");
		
		System.out.println(size);
		
		//Print Purchase Amount
		
        int purchaseAmount=js.getInt("dashboard.purchaseAmount");
		
		System.out.println(purchaseAmount);
		
		
		// Print Title of the first course
		
		String firstTitle=js.getString("courses[0].title");
		System.out.println(firstTitle);


		// Print All course titles and their respective Prices
		
		for(int i=0;i<size;i++) {
			
			String titles = js.get("courses["+i+"].title");
			int price= js.get("courses["+i+"].price");
			System.out.println(titles+" : "+price);
		}
		

		// Print no of copies sold by RPA Course
	
         for(int i=0;i<size;i++) {
			
			String titles = js.get("courses["+i+"].title");
			
			if(titles.equals("RPA"))
			{
				int Copies=js.get("courses["+i+"].copies");
				System.out.println(Copies);
				break;
			}
		}

		// Verify if Sum of all Course prices matches with Purchase Amount
         
         
	}
}
