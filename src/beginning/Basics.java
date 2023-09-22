package beginning;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import files.ReusableMethod;

public class Basics {

	@Test
	
	//public void addPlace() 
	public static void main(String args[]){
		// TODO Auto-generated method stub
		
		//given:all input detail for api
		//when:submit the api
		//then:validate the response of api
		
		//addPlace
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	    .body(Payload.addPlace())
		
		.when().post("maps/api/place/add/json")
		
		.then().assertThat().statusCode(200)
		.header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		JsonPath js=new JsonPath(response);
		String placeid=js.getString("place_id");
		
		System.out.println(placeid);
		
		//UpdatePlace
		
		String newAddress="70 Summer walk, USA";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeid+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
		.when().put("maps/api/place/update/json")
		
		.then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//GetPlace
       
		String address=given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
		
		.when().put("maps/api/place/get/json")
		
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath jsp=ReusableMethod.rawToJson(address);
		String actualAddress=jsp.getString("address");
	    System.out.println(actualAddress);
	    
	    Assert.assertEquals(actualAddress, newAddress);
	}

}
