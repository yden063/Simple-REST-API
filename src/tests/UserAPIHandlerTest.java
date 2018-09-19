package tests;

import application.User;
import core.UserAPIHandler;

public class UserAPIHandlerTest {
	public static void main(String args[]) {
		UserAPIHandler userAPI = new UserAPIHandler();
		User user = new User("Julien", "Software Engineer");

		// Add a user via a POST request
		//System.out.println(userAPI.postObject(user));

		User [] users = userAPI.getObjects(); // Problem ==> return null
		if(users == null)
			System.out.println("null");

	}
}
