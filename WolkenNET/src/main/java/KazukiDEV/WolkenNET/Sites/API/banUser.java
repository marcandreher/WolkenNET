package KazukiDEV.WolkenNET.Sites.API;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import KazukiDEV.WolkenNET.Content.Moderation;
import KazukiDEV.WolkenNET.Content.Permissions;
import spark.Request;
import spark.Response;
import spark.Route;

public class banUser implements Route {
	public Map<String, Object> m = new HashMap<>();

	public banUser() {
	}

	public Object handle(Request request, Response response) {
		Permissions.hasPermissions(request.cookie("session"), this.m, response);

		if (!((String) m.get("permissions")).equals("10")) {
			response.redirect("/");
			return null;
		}

		// TODO: Check if id is id

		String uID = request.queryParams("uname");
		try {
			Moderation.BanUser(uID);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		// TODO: Weiterleiten
		return "Nutzer wurde gebannt";

	}
}
