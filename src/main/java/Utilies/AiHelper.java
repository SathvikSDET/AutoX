package Utilies;

import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AiHelper {
	
	
	private static final String BASE_URL ="http://localhost:11434/api/generate";
	private static final String MODEL ="deepseek-r1:1.5b";
	
	public static String generateResponse(String prompt) {
		
		
		//Create JSON Object
		JSONObject requestJson = new JSONObject();
		requestJson.put("model", MODEL);
		requestJson.put("prompt", prompt);
		requestJson.put("stream", false);
		
		Response response = RestAssured.given()
										.baseUri(BASE_URL)
										.header("Content-Type","application/json")
										.body(requestJson.toString())
										.when().post();
	
	
        JSONObject jsonResponse = new JSONObject(response.getBody().asString());
        return jsonResponse.getString("response");
	}
	
	 public static void main(String[] args) {
	        String prompt = "Why is the ocean blue?";
	        String response = generateResponse(prompt);
	        System.out.println("API Response: " + response);
	    }
	

}
