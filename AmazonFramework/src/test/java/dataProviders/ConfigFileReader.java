package dataProviders;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ConfigFileReader {
	
	public static String getJsonString(String parameter)
	{
		String Value = "";
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("/Users/gustavo/eclipse-workspace/UnoSquare/AmazonAutomation/configFiles/config.json"));
			JSONObject jsonObject = (JSONObject) obj;
			Value = (String) jsonObject.get(parameter);
			
		}
		catch (Exception e) {
			System.out.println("The parameter was not found");
			System.out.println(e.getMessage());
		}
		return Value;
	}

}
