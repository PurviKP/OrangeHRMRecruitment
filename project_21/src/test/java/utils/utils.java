package utils;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class utils {
	 public static JSONObject loadJsonFile(String fileLocation){
	        JSONParser jsonParser = new JSONParser();
	        JSONObject jsonObject = null;
	        try {
	            Object obj = jsonParser.parse(new FileReader(fileLocation));
	            jsonObject = (JSONObject) obj;
	        }catch(Exception e){
	            System.out.println(e.getMessage());
	        }
	        return jsonObject;
	    }

}
