package KazukiDEV.WolkenNET.Config;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Config {
	public static String createJSON(HashMap<String, Object> map) {
		String end = "{\n";
		int i = 0;
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			i++;
			if (i == map.size()) {
				end = String.valueOf(end) + "\t\"" + (String) entry.getKey() + "\": \"" + entry.getValue() + "\"\n";
				continue;
			}
			end = String.valueOf(end) + "\t\"" + (String) entry.getKey() + "\": \"" + entry.getValue() + "\",\n";
		}
		end = String.valueOf(end) + "}";
		return end;
	}

	public static Object config = null;

	public static JSONObject objconfig = null;

	public static void loadConfig() throws Exception {
		JSONParser parser = new JSONParser();
		Object obj = null;
		obj = parser.parse(new FileReader("config.json"));
		config = obj;
		JSONObject jsonObject = (JSONObject) obj;
		objconfig = jsonObject;
		System.out.println(String.valueOf(u.info) + "Successfully loaded Config.json");
	}

	public static void createConfig() {
		File f = new File("config.json");
		if (f.exists()) {
			System.out.println(String.valueOf(u.info) + "Found Config! No one must be created");
		} else {
			System.out.println(String.valueOf(u.error) + "No Config Found! Create one...");
			HashMap<String, Object> obj = new HashMap<>();
			obj.put("sparkport", "88");
			obj.put("mysqlip", "localhost");
			obj.put("mysqlport", "3306");
			obj.put("mysqldatabase", "giveway");
			obj.put("mysqlusername", "root");
			obj.put("mysqlpassword", "");
			obj.put("debug", "false");
			System.exit(0);
		}
	}

	public static String getString(String string) {
		String result = (String) objconfig.get(string);
		return result;
	}

	public static Boolean getBool(String string) {
		Boolean result = (Boolean) objconfig.get(string);
		return result;
	}

	public static long getLong(String string) {
		long result = ((Long) objconfig.get(string)).longValue();
		return result;
	}
}
