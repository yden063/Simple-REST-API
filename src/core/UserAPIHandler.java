package core;

import java.util.List;

import application.JSonHandler;
import application.User;

public class UserAPIHandler implements ObjectAPIHandler<User> {

	InteractionAPI api;
	JSonHandler handler;

	@Override
	public User getObject(int id) {
		api = new InteractionAPI();
		handler = new JSonHandler();

		String json = api.get("users/" + id);
		User user = handler.jsonToUser(json);

		return user;
	}

	@Override
	public String postObject(User object) {
		api = new InteractionAPI();
		handler = new JSonHandler();
		User user = object;

		String json = handler.userToJson(user);
		String returnedResponse = api.post("users", json);

		return returnedResponse;
	}

	@Override
	public List<User> getObjects() {
		// TODO Auto-generated method stub
		return null;
	}
}
