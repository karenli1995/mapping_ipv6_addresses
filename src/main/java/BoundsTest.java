import junit.framework.TestCase;


public class BoundsTest extends TestCase {
	private String myJson;
	private String myMinLat;
	private String myMaxLat;
	private String myMinLon;
	private String myMaxLon;
	
	public void testOutputMatchesBoundInput() {
		myJson = "[{\"id\": \"1\",\"latitude\": \"1.2931\",\"longitude\": \"103.8558\"},{\"id\": \"2\",\"latitude\": \"35.685\",\"longitude\": \"139.7514\"},{\"id\": \"3\",\"latitude\": \"35.685\",\"longitude\": \"139.7514\"}]";
		myMinLat = "1";
		myMaxLat = "2";
		myMinLon = "103";
		myMaxLon = "104";
		Bounds bounds = new Bounds(myJson, myMinLat, myMaxLat, myMinLon, myMaxLon);
		assertEquals("[{\"id\": \"0\",\"latitude\": \"1.2931\",\"longitude\": \"103.8558\"}]", bounds.parseJson());
		
		myMinLat = "2";
		myMaxLat = "4";
		myMinLon = "103";
		myMaxLon = "104";
		Bounds bounds2 = new Bounds(myJson, myMinLat, myMaxLat, myMinLon, myMaxLon);
		assertEquals("", bounds2.parseJson());
	}
}
