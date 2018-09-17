package application;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSonHandler {

	public String userToJson(User user){
		//create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();
		StringWriter jsonString = new StringWriter();
		
		try {
			objectMapper.writeValue(jsonString, user);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonString.toString();
	}
	
	public User jsonToUser(String json){
		ObjectMapper objectMapper = new ObjectMapper();
		User user =null;
		try {
			user = objectMapper.readValue(json, User.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public ArrayList<User> jsonToUsers(String json){
		
		
		
		return null;
	}
}

