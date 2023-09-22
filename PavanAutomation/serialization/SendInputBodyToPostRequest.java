package serialization;

import java.util.ArrayList;
import java.util.List;

public class SendInputBodyToPostRequest {

	public static void main(String[] args) {
		
		AddPlace a=new AddPlace();
		a.setAccuracy(25);
		a.setLanguage("English");
		a.setName("Mark wood");
		List<String> list=new ArrayList<String>();
		list.add("shop");
		list.add("bike");
		a.setType(list);
		Location l=new Location();
		l.setLat(36.56);
		l.setLng(86546.666);
		a.setLocation(l);
		
		
		System.out.println(a);
		
	}

}
