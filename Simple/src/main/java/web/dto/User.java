package web.dto;

public class User {

	private String username;
	private int userage;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUserage() {
		return userage;
	}

	public void setUserage(int userage) {
		this.userage = userage;
	}

	public User(String username, int userage) {
		super();
		this.username = username;
		this.userage = userage;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", userage=" + userage + "]";
	}
	
	
	
}
