package KazukiDEV.WolkenNET.Content;

import KazukiDEV.WolkenNET.Config.u;

public class Moderation {

	public static void BanUser(String username) {
		u.s.println(u.warning + "The User " + Color.RED + username + Color.RESET + " was banned");
		String ban_sql = "UPDATE `users` SET `banned`= true, `session` = ? WHERE `username` = ?";
		mysql.Exec(ban_sql, Auth.generateSessionCookie(), username);
	}
	
	public static void deleteContribution(int id) {
		u.s.println(u.warning + "The Contribution with the ID: " + Color.RED + new StringBuilder().append(id).toString() + Color.RESET + " was banned");
		String sql = "DELETE * FROM `contributions` WHERE `id` = ?";
		mysql.Exec(sql, new StringBuilder().append(id).toString() + "");
	}
	//(Privater chat)
	//Beitrag sperren
	//Beitrag freischalten
	
}
