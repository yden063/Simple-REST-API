package application;

import java.io.IOException;
import java.io.StringWriter;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSonHandler {
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public String userToJson(User user){
		StringWriter jsonString = new StringWriter();
		
		try {
			objectMapper.writeValue(jsonString, user);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return jsonString.toString();
	}
	
	public User jsonToUser(String json){
		User user;

		json = extractData(json);
				
		try {
			user = objectMapper.readValue(json, User.class);
		} catch (IOException e) {
			e.printStackTrace();
			user = null;
		} catch (NullPointerException nullExcep){
			System.out.println("Field 'data' does not exist, generating a new user with no data");
			user = new User();
		}
		
		return user;
	}
	
	public User[] jsonToUsers(String json){
		User[] list;
		
		json = extractData(json);
		
		try {
			list = objectMapper.readValue(json, User[].class);
		} catch (IOException e) {
			list = null;
		}
		
		return list;
	}
	
	private String extractData(String jsonIn){
		String jsonOut;
		
		try {
			jsonOut = objectMapper.readTree(jsonIn).get("data").asText();
		} catch (NullPointerException e1) {
			e1.printStackTrace();
			jsonOut = "{}";
		} catch (IOException e) {
			e.printStackTrace();
			jsonOut = "{}";
		}
		
		return jsonOut;
	}
}
