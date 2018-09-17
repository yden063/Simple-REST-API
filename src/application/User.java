package application;

public class User {
	private String name;
	private String job;

	public User(){}
	
	public User(String name,String job){
		this.name=name;
		this.job=job;
	}

	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	
}
