package ddt;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadingDataFromJson {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		JSONParser jsonparse = new JSONParser();
		FileReader reader = new FileReader("./src\\test\\resources\\Commondata.json");
		Object javaobj = jsonparse.parse(reader);

		JSONObject obj = (JSONObject) javaobj;
		String BROWSER = obj.get("browser").toString();
		System.out.println(BROWSER);
	}

}
