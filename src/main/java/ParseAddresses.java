import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ParseAddresses {
	private String myJSon = "";
	private String myNewJSon = "";
	
	public String readLargeFile2(String fileName){
		String line = null;
		int i = 0;

		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				String[] eachRow = line.split(",");
				String lat = eachRow[0];
				String lon = eachRow[1];
				i++;
				
				myJSon += "{\"id\": " + "\"" + i + "\"," + "\"latitude\": " + "\"" + lat + "\"," + "\"longitude\": " + "\"" + lon + "\"},";
			}
			
			if((line = bufferedReader.readLine()) == null){
				myNewJSon = "[" + myJSon.substring(0, myJSon.length()-1) + "]";
			}

			bufferedReader.close();         
		}
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");                
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return myNewJSon;
	}

}
