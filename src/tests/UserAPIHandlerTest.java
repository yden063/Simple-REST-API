package tests;

import application.User;
import core.UserAPIHandler;

public class UserAPIHandlerTest {
	public static void main(String args[]) {
		UserAPIHandler userAPI = new UserAPIHandler();
		User user = new User("Julien", "Software Engineer");

		System.out.println(userAPI.postObject(user));
	}
}
