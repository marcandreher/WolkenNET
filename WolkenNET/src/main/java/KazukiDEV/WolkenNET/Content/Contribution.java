package KazukiDEV.WolkenNET.Content;

public class Contribution {

	private int id;

	private String Timestamp;

	private String Bbcode_text;

	private String Sublink;

	private String Username;

	private String Userid;

	private String Perm;

	public String getPerm() {
		return this.Perm;
	}

	public void setPerm(String Perm) {
		this.Perm = Perm;
	}

	public void setUserid(String Userid) {
		this.Userid = Userid;
	}

	public String getUserid() {
		return Userid;
	}

	public void setUsername(String Username) {
		this.Username = Username;
	}

	public String getUsername() {
		return Username;
	}

	public void setBbcode_text(String Bbcode_text) {
		this.Bbcode_text = Bbcode_text;
	}

	public String getBbcode_text() {
		return Bbcode_text;
	}

	public void setTimestamp(String Timestamp) {
		this.Timestamp = Timestamp;
	}

	public String getTimestamp() {
		return Timestamp;
	}

	public String getSublink() {
		return this.Sublink;
	}

	public int getID() {
		return this.id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public void setSublink(String Sublink) {
		this.Sublink = Sublink;
	}

}
