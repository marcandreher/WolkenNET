package KazukiDEV.WolkenNET.Sites.Get;

import java.util.HashMap;
import java.util.Map;

import KazukiDEV.WolkenNET.Content.Auth;
import KazukiDEV.WolkenNET.Content.Permissions;
import KazukiDEV.WolkenNET.Content.mysql;
import spark.Request;
import spark.Response;
import spark.Route;

public class logout implements Route {
	public Map<String, Object> m = new HashMap<>();

	public logout() {
	}

	public Object handle(Request request, Response response) {
		Permissions.hasPermissions(request.cookie("session"), this.m, response);
		String sessionChangeSQL = "UPDATE `users` SET `session`= ? WHERE `id` = ?";
		mysql.Exec(sessionChangeSQL, Auth.generateSessionCookie(), (String) m.get("useridst"));
		response.removeCookie("session");
		response.redirect("/");
		return null;
	}
}
