package application;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSonHandler {
	private ObjectMapper objectMapper = new ObjectMapper();

	public String userToJson(User user) {
		StringWriter jsonString = new StringWriter();

		try {
			objectMapper.writeValue(jsonString, user);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return jsonString.toString();
	}

	public User jsonToUser(String json) {
		User user = null;
		String retour = extractData(json);

		try {
			user = objectMapper.readValue(retour, User.class);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException nullExcep) {
			System.out.println("Field 'data' does not exist, generating a new user with no data");
		}

		return user;
	}

	public List<User> jsonToUsers(String json) {
		List<User> list;

		String retour;
		retour = extractData(json);

		try {
			list = objectMapper.readValue(retour, new TypeReference<List<User>>() {});
		} catch (IOException e) {
			list = null;
			e.printStackTrace();
		}

		return list;
	}

	private String extractData(String jsonIn) {
		String dataValuestr = null;

		try {
			JsonNode node = objectMapper.readTree(jsonIn);
			dataValuestr = node.findValue("data").toString();

		} catch (NullPointerException e1) {
			e1.printStackTrace();
			dataValuestr = "{}";
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dataValuestr;
	}
}
