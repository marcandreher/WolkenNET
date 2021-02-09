package KazukiDEV.WolkenNET.Content;

public class User {

	private int id;

	private String username;
	
	private String authority;
	
	private String country;
	
	private String mail;
	
	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMail() {
		return mail;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getAuthority() {
		return authority;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public int getID() {
		return this.id;
	}

	public void setID(int id) {
		this.id = id;
	}

}
