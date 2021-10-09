package files;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

public class serializeTest {

	public static void main(String[] args) {
		
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress("Bagbanlar 3");
		p.setLanguage("English");
		p.setPhone_number("2717029");
		p.setWebsite("https://rahulshettyacademy.com");
		p.setName("My home");
		List<String>myList = new ArrayList<String>();
		myList.add("park");
		myList.add("shop");
		p.setTypes(myList);
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		
		
		
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response res = given().log().all().queryParam("key", "qaclick123").body(p)
				.when().post("/maps/api/place/add/json")
				.then().assertThat().statusCode(200).extract().response();
		String responseString = res.asString();
		System.out.println(responseString);
				

	}

}
