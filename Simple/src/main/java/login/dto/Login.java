package login.dto;

public class Login {

	private String id;
	private String pw;
	private String email;
	private String phone;

	public Login() {}

	public Login(String id, String pw, String email, String phone) {
		super();
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", pw=" + pw + ", email=" + email + ", phone=" + phone + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
