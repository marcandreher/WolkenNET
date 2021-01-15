package KazukiDEV.WolkenNET.Content;

import KazukiDEV.WolkenNET.Config.u;

public class Moderation {

	public static void BanUser(String username) {
		u.s.println(u.warning + "The User " + Color.RED + username + Color.RESET + " was banned");
		String ban_sql = "UPDATE `users` SET `banned`= true WHERE `username` = ?";
		mysql.Exec(ban_sql, username);
	}
	
}
