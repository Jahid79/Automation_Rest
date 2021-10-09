package files;

import io.restassured.path.json.JsonPath;

public class ComplexJson {

	public static void main(String[] args) {
		
		JsonPath js = new JsonPath(payload.CoursePrice());
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		String titleFirstCourse = js.getString("courses[0].title");
		System.out.println(titleFirstCourse);
		
		for (int i=0; i<count; i++) 
		{
			String courseTitles=js.getString("courses["+i+"].title");
			System.out.println(js.get("courses["+i+"].price").toString());
			
			System.out.println(courseTitles);
			
		}
		 
		for (int i=0; i<count; i++) 
		{
			String courseTitles=js.getString("courses["+i+"].title");
			if (courseTitles.equalsIgnoreCase("RPA"))
			{
				int copies = js.getInt("courses["+i+"].copies");
				System.out.println(copies);
				break;
				
			}
					
		}
		
		
	}

}
