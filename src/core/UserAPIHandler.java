package core;

import application.JSonHandler;
import application.User;

public class UserAPIHandler implements ObjectAPIHandler {

	InteractionAPI api;
	JSonHandler handler;

	@Override
	public Object getObject(int id) {
		api = new InteractionAPI();
		handler = new JSonHandler();

		String json = api.get("user/" + id);
		User user = handler.jsonToUser(json);

		return user;
	}

	@Override
	public String postObject(Object object) {
		api = new InteractionAPI();
		handler = new JSonHandler();
		User user = (User) object;

		String json = handler.userToJson(user);
		String returnedResponse = api.post("users", json);

		return returnedResponse;
	}

	@Override
	public Object getObjects() {
		// TODO Auto-generated method stub
		return null;
	}
}
