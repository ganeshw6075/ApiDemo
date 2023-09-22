package beginning;

import org.testng.annotations.Test;

import files.Payload;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DynamicJson {

	@Test
	public void addBooks()
	{
		RestAssured.baseURI="http://216.10.245.166";
		given().log().all().header("Content-Type","application/json").body(Payload.addBook())
		.when().post("Library/Addbook.php")
		.then().assertThat().statusCode(200).body("ID",equalTo("bcd227"));
	}
}
