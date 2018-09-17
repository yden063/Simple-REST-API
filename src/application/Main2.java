package application;

public class Main2 {

	public static void main(String[] args) {
		User user1 = new User("Julien","Ingénieur");
		
		JSonHandler jsonH = new JSonHandler();
		
		System.out.println(jsonH.userToJson(user1));
		
		System.out.println(jsonH.jsonToUser("{\"name\":\"Julien ABT\",\"job\":\"Ingénieur Info\"}").getName());
		
	}

}
