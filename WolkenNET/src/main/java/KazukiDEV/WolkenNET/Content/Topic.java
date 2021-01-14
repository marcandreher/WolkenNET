package KazukiDEV.WolkenNET.Content;

public class Topic {
	private String Icon; // GETSET

	private String Title; // GETSET

	private String Description; // GETSET

	private int id; // GETSET

	private String Sublink; // GETSET

	private String Groupid; // GETSET

	private String Important; // GETSET

	private String posts;

	public String getPosts() {
		return posts;
	}

	public void setPosts(String posts) {
		this.posts = posts;
	}

	public String getSublink() {
		return this.Sublink;
	}

	public int getID() {
		return this.id;
	}

	public String getGroupid() {
		return this.Groupid;
	}

	public void setID(int id) {
		this.id = id;
	}

	public void setSublink(String Sublink) {
		this.Sublink = Sublink;
	}

	public String getImportant() {
		return this.Important;
	}

	public void setGroupid(String Groupid) {
		this.Groupid = Groupid;
	}

	public String getIcon() {
		return this.Icon;
	}

	public void setIcon(String Icon) {
		this.Icon = Icon;
	}

	public void setImportant(String Important) {
		this.Important = Important;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		this.Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
}
