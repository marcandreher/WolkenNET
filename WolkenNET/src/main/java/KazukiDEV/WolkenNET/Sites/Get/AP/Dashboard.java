package KazukiDEV.WolkenNET.Sites.Get.AP;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import KazukiDEV.WolkenNET.Content.Permissions;
import KazukiDEV.WolkenNET.Content.mysql;
import KazukiDEV.WolkenNET.Main.App;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;

public class Dashboard implements Route {
	public Map<String, Object> m = new HashMap<>();

	public Dashboard() {
	}

	public Object handle(Request request, Response response) {
		Permissions.hasPermissions(request.cookie("session"), this.m, response);
		m.put("titlebar", "AP Dashboard");
		m.put("sessionviews", App.sessionv + "");

		String registered_users = "SELECT * FROM `users`";
		int users = 0;
		try {
			ResultSet up_next_rs = mysql.Query(registered_users);
			while (up_next_rs.next()) {
				users++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		m.put("registered", new StringBuilder().append(users).toString());

		try {
			Template template = App.cfg.getTemplate("/ap/dashboard.html");
			Writer out = new StringWriter();
			template.process(this.m, out);
			return out.toString();
		} catch (IOException | freemarker.template.TemplateException e) {
			throw new RuntimeException(e);
		}
	}
}
