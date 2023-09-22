package basicMethods;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AllRequest {

	static String response;
	int id;
		@Test(priority=1)
	     void getUsers()
		{
	    
	    RestAssured.baseURI="https://reqres.in";
				
		given()
		
		.when().get("/api/users?page=2")
		
		.then().statusCode(200).body("data[3].first_name", equalTo("Byron"))
		.log().all();
		}
	    
		@Test(priority=2)
		 void CreateUser() {
			RestAssured.baseURI="https://reqres.in";
			
		    response=given()
			.contentType("application/Json")
			.body("{\r\n"
					+ "    \"name\": \"morpheus\",\r\n"
					+ "    \"job\": \"leader\"\r\n"
					+ "}")
			
			.when().post("/api/users")
			
			.then().extract().response().asString();
		    
		    JsonPath js=new JsonPath(response);
		    id=js.getInt("id");
		    System.out.println(id);
			
		}
		
		@Test(priority=2,dependsOnMethods= {"CreateUser"})
		 void updateUser()
		{
			RestAssured.baseURI="https://reqres.in";
			
			given().contentType("application/json")
			.body("{\r\n"
					+ "    \"name\": \"suyash\",\r\n"
					+ "    \"job\": \"zion resident\"\r\n"
					+ "}")
			
			.when().put("/api/users/"+id)
			
			.then().log().all()
			.statusCode(200)
			.body("name", equalTo("suyash"));
		}
	   
		@Test(priority=4)
		void delete()
		{
			RestAssured.baseURI="https://reqres.in";
			
			given()
			
			.when().delete("/api/users/"+id)
			
			.then().assertThat().statusCode(204);
		}
	    

	}


