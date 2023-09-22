package basicMethods;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class HowManyWayToCreateRequestBody {

	//this are the four way to create the request body
	
//	Hashmap
//	using org.json Library
//	pojo Class (plain old java object) this is most famous way
//	using external json file

	
	String response;
	int id;
   @Test(priority=1)
	void testPostUsingHashmap()
 {
	 HashMap<String,String> data=new HashMap<String,String>();
	 
	 data.put("name", "Ronaldo");
	 data.put("location", "Spain");
	 data.put("phone", "65465461238");
	 
	  String courseArray[]= {"c++","selenium"};
	  for(int i=0; i<courseArray.length;i++) {
	  data.put("course",courseArray[i]);
	  }
	  
	  response=given()
	  .contentType("application/json")
	  .body(data)
	  
	  .when().post("http://localhost:3000/students")
	  
	  .then().log().all().statusCode(201)
	  .body("name", equalTo("Ronaldo"))
	  .body("location", equalTo("Spain")).assertThat().extract().asString();
	  JsonPath js=new JsonPath(response);
	   id=js.getInt("id");
 }
	
 // post request body by using org.json library
	
//	@Test(priority=1)
//	void testPostUsingJsonLibrary()
// {
//	 JSONObject data=new JSONObject();
//	 data.put("name", "Scott");
//	 data.put("location", "belgium");
//	 data.put("phone", "653248956");
//	 
//	  String courseArray[]= {"c++","selenium"};
//      data.put("course",courseArray );
//      
////	  for(int i=0; i<courseArray.length;i++) {
////	  data.put("course",courseArray[i]);
////	  }
//	  
//	  response=given()
//	  .contentType("application/json")
//	  .body(data.toString())
//	  
//	  .when().post("http://localhost:3000/students")
//	  
//	  .then().log().all().statusCode(201)
//	  .body("name", equalTo("Scott"))
//	  .body("location", equalTo("belgium")).assertThat().extract().asString();
//	  JsonPath js=new JsonPath(response);
//	   id=js.getInt("id");
// }
 
	//using by the pojo class
	
//	@Test(priority=1)
//	void testPostUsingPojoClass()
// {
//	PojoClass data=new PojoClass();
//	
//	data.setName("Michel");
//	data.setLocation("Australia");
//	data.setPhone("5562523216");
//	
//	List<String> course=new ArrayList<String>();
//	course.add("C");
//	course.add("Java");
//	
//	data.setCourse(course);
//	  
//	  response=given()
//	  .contentType("application/json")
//	  .body(data)
//	  
//	  .when().post("http://localhost:3000/students")
//	  
//	  .then().log().all().statusCode(201)
//	  .body("name", equalTo("Michel"))
//	  .body("location",equalTo("Australia")).assertThat().extract().asString();
//	  JsonPath js=new JsonPath(response);
//	   id=js.getInt("id");
//	   System.out.println(id);
// }
//	
	//using by the pojo class
//	@Test(priority=1)
//	void testPostUsingExternalFile() throws Exception
// {
//	
//		File file=new File("D:\\String\\RestAssured\\DemoProject\\PavanAutomation\\Students.json");
//		FileReader fr=new FileReader(file);
//		
//		JSONTokener jt=new JSONTokener(fr);
//		
//		JSONObject data=new JSONObject(jt);
//		
//	   response=given()
//	  .contentType("application/json")
//	  .body(data.toString())
//	  
//	  .when().post("http://localhost:3000/students")
//	  
//	  .then().log().all().statusCode(201)
//	  .body("name", equalTo("Michel"))
//	  .body("location",equalTo("Australia")).assertThat().extract().asString();
//	  JsonPath js=new JsonPath(response);
//	   id=js.getInt("id");
//	   System.out.println("Id of the user created : "+id);
// }
// 
	
	//
	@Test(priority=2,dependsOnMethods= {"testPostUsingPojoClass"})
	void deleteRecord()
	{
		given()
		
		.when().delete("http://localhost:3000/students/"+id)
		
		.then().statusCode(200);

	}
 
}
