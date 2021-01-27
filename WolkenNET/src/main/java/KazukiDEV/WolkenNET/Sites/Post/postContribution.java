package KazukiDEV.WolkenNET.Sites.Post;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import KazukiDEV.WolkenNET.Content.Permissions;
import KazukiDEV.WolkenNET.Content.mysql;
import spark.Request;
import spark.Response;
import spark.Route;

public class postContribution implements Route {
	public postContribution() {
	}
	public Map<String, Object> m = new HashMap<>();

	public Object handle(Request request, Response response) {
		if(Permissions.hasPermissions(request.cookie("session"), this.m, response) == false) {
			//TODO: Login Fenster öffnen
			response.redirect("/");
			return null;
		}
		String title = request.queryParams("title");
		String bbcode_text = request.queryParams("bbcode_text");
		TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
		df.setTimeZone(tz);
		String nowAsISO = df.format(new Date());
		String uID = (String) m.get("useridst");
		String gID = request.queryParams("topic_id");
		
		String checkSQL = "SELECT * FROM `contributions` WHERE `sublink` = ? AND `user_id` = ?";
		ResultSet checkRS = mysql.Query(checkSQL, title, uID);
		try {
			while(checkRS.next()) {
				return null;
			}
			
			String insertSQL = "INSERT INTO `contributions`(`topic_id`, `user_id`, `timestamp`, `bbcode_text`, `sublink`) VALUES (?,?,?,?,?)";
			mysql.Exec(insertSQL, gID, uID, nowAsISO, bbcode_text, title);
			
			String forwardSQL = "SELECT * FROM `topics` WHERE `id` = ?";
			ResultSet forwardRS = mysql.Query(forwardSQL, request.queryParams("topic_id"));
			while(forwardRS.next()) {
				String link = forwardRS.getString("sublink").replaceAll(" ", "%20");
				response.redirect("/thema/" + link);
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return null;

	}
}
