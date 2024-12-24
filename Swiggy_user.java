package swiggy;

public class Swiggy_user {

	
	private String username;
	private String password;
	
	public Swiggy_user( String username, String password) {
			
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String toString() {
		
		 return"[username= "+username+", password ="+password+"]";
	}
}
