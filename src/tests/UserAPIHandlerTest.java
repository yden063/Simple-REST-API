package tests;

import application.User;
import core.UserAPIHandler;

public class UserAPIHandlerTest {
	public static void main(String args[]) {
		UserAPIHandler userAPI = new UserAPIHandler();
		User user = new User("Julien", "Software Engineer");

		// Add a user via a POST request
		System.out.println(userAPI.postObject(user));

		User user2 = userAPI.getObject(2);
		System.out.println(user2.getAvatar());

		// GET multiples objects
		userAPI.getObjects().forEach(e -> {
			System.out.println(e.getFirst_name());
		});

	}
}
