package KazukiDEV.WolkenNET.Content;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.ResultSet;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class reCaptcha {
	
	public static boolean handleCaptcha(String responseG) throws Exception {
		String secret = "";
		String secretSQL = "SELECT * FROM `system_settings` WHERE id=?";
		ResultSet secretRS = mysql.Query(secretSQL, 5+"");
		while(secretRS.next()) {
			secret = secretRS.getString("value_string");
		}
		
		URL url = new URL ("https://www.google.com/recaptcha/api/siteverify?secret=" + secret + "&response=" + responseG);
		HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		con.setDoOutput(true);

		try(BufferedReader br = new BufferedReader(
				  new InputStreamReader(con.getInputStream(), "utf-8"))) {
				    StringBuilder response = new StringBuilder();
				    String responseLine = null;
				    while ((responseLine = br.readLine()) != null) {
				        response.append(responseLine.trim());
				    }
				    System.out.println(response.toString());
				    JSONParser parser = new JSONParser();
					Object obj = parser.parse(response.toString());
					JSONObject jsonObject = (JSONObject) obj;
					if((Boolean) jsonObject.get("success") == false) {
						return false;
					}
					return true;
				}
		
	}

}
