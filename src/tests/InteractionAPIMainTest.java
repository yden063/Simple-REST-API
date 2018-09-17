package tests;

import core.InteractionAPI;

public class InteractionAPIMainTest {

	public static void main(String[] args) {
		InteractionAPI api = new InteractionAPI();

		// GET Request
		String responseGET = api.get("users");
		System.out.println(responseGET);

		// POST Request
		String jsonData = "{\"name\":\"Julien ABT\",\"job\":\"Ingénieur Info\"}";
		String responsePOST = api.post("users", jsonData);
		System.out.println(responsePOST);

	}

}
