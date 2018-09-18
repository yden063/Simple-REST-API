package tests;

import core.InteractionAPI;

public class InteractionAPIMainTest {

	public static void main(String[] args) {
		InteractionAPI api = new InteractionAPI();

		// GET all users request
		String responseGET = api.get("users");
		System.out.println(responseGET);

		// GET single user request
		String responseGETSingleUser = api.get("users/2");
		System.out.println(responseGETSingleUser);

		// POST Request
		String jsonData = "{\"name\":\"Julien ABT\",\"job\":\"Ingénieur Info\"}";
		String responsePOST = api.post("users", jsonData);
		System.out.println(responsePOST);

	}

}
