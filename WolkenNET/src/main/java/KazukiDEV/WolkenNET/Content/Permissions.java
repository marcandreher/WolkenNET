package KazukiDEV.WolkenNET.Content;

import java.sql.ResultSet;
import java.util.Map;

import KazukiDEV.WolkenNET.Main.App;
import spark.Response;

public class Permissions {

	public static boolean hasPermissions(String cookie, Map<String, Object> map, Response r) {
		r.type("text/html");
		App.sessionv++;
		try {
			String sql = "SELECT * FROM `users` WHERE `session` = ?";
			ResultSet rs = mysql.Query(sql, cookie);
			if (rs.next()) {
				map.put("username", rs.getString("username"));
				map.put("avatar", rs.getString("avatar"));
				map.put("userid", Integer.valueOf(rs.getInt("id")));
				map.put("useridst", new StringBuilder().append(rs.getInt("id")).toString());
				map.put("permissions", rs.getString("permissions"));
				map.put("loggedin", "true");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("loggedin", "false");
		map.put("permissions", "0");
		map.put("userid", Integer.valueOf(0));
		map.put("useridst", "");

		return false;
	}

}
