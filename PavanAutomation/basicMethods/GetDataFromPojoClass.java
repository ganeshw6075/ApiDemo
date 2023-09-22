package basicMethods;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.parsing.Parser;

public class GetDataFromPojoClass {

	@Test
	void GetdataPojo()
	{
		  PojoClass data = given().expect().defaultParser(Parser.JSON)
		  
		  .when().get("http://localhost:3000/students").as(PojoClass.class);
		  
		  System.out.println(data.getStudents().get(1).getName());
		  System.out.println(data.getStudents().get(1).getPhone());
		  System.out.println(data.getStudents().get(1).getLocation());
		  System.out.println(data.getStudents().get(1).getCourse().get(0));
		  
	}

}
