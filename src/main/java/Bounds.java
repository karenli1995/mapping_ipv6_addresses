
import org.json.*;

public class Bounds {
	private String myJson;
	private int myMinLat;
	private int myMaxLat;
	private int myMinLon;
	private int myMaxLon;
	private String myJSonString = "";	
	private String myAnswer = "";
	
	
	Bounds(String json, String minlat, String maxlat, String minlon, String maxlon){
		myJson = json;
		myMinLat = Integer.parseInt(minlat);
		myMaxLat = Integer.parseInt(maxlat);
		myMinLon = Integer.parseInt(minlon);
		myMaxLon = Integer.parseInt(maxlon);
	}
	
	public String parseJson(){
		JSONArray obj = new JSONArray(myJson);

		for(int i = 0; i<obj.length(); i++){
			JSONObject currobj = obj.getJSONObject(i);
			
			String latitude =currobj.getString("latitude");
			String longitude = currobj.getString("longitude");
						
			double curLat = Double.parseDouble(latitude);
			double curLon = Double.parseDouble(longitude);
			
			
			if(inBounds(curLat, curLon)){
				myJSonString += "{\"id\": " + "\"" + i + "\"," + "\"latitude\": " + "\"" + latitude + "\"," + "\"longitude\": " + "\"" + longitude + "\"},";
			}
		}
		
		if(myJSonString.length() > 0){
			myAnswer = "[" + myJSonString.substring(0, myJSonString.length()-1) + "]";
		}
		
		return myAnswer;
		
	}

	private boolean inBounds(double curLat, double curLon) {
		return (curLat >= myMinLat && curLat <= myMaxLat && curLon >= myMinLon && curLon <= myMaxLon);
	}
	
}
