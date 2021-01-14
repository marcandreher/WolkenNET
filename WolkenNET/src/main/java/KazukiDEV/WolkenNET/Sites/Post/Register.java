package KazukiDEV.WolkenNET.Sites.Post;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import KazukiDEV.WolkenNET.Content.mysql;
import spark.Request;
import spark.Response;
import spark.Route;

public class Register implements Route {
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	public Register() {
	}

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);
	static SecureRandom rnd = new SecureRandom();

	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	public Object handle(Request request, Response response) {
		try {
			String username = request.queryParams("username");
			String password = request.queryParams("password");
			String email = request.queryParams("email");
			String country = request.queryParams("country");
	
			if (!validate(email)) {
				response.redirect("/?r=rie&open=register");
				return null;
			}
	
			String session = randomString(30);
			
			String sql_us_ch = "SELECT * FROM `users` WHERE `username` = ?";
			ResultSet rs_us_ch = mysql.Query(sql_us_ch, username);
			
			if (rs_us_ch.next()) {
				response.redirect("/?r=rut&open=register");
				return null;
			}
				
			String sql_ma_ch = "SELECT * FROM `users` WHERE `email` = ?";
			ResultSet rs_ma_ch = mysql.Query(sql_ma_ch, email);
			if (rs_ma_ch.next()) {
				response.redirect("/?r=ret&open=register");
				return null;
			}
		
		    if(username.length() > 15) {
		    	response.redirect("/?r=rul&open=register");
				return null;
		    }
		    
		    if(email.length() > 50) {
		    	response.redirect("/?r=rel&open=register");
				return null;
		    }
		    
		    if(password.length() < 5) {
		    	response.redirect("/?r=rts&open=register");
				return null;
		    }
		    
		    long millis=System.currentTimeMillis();  
		    java.sql.Date date=new java.sql.Date(millis);  
		    
	
		
	
			String sql = "INSERT INTO `users`(`username`, `email`, `password_md5`, `registered_on`, `last_login`, `country`, `permissions`, `avatar`, `session`) VALUES (?,?,?,?,?,?,?,?,?)";
			mysql.Exec(sql, username, email, MD5(password), date.toString(), "", country, "1", "", session);
			response.redirect("/?open=login");
			return "";
		}catch(Exception e) {
			e.printStackTrace();
			response.redirect("/?r=re&open=register");
			return null;
		}
	}

	String randomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
					.charAt(rnd.nextInt("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".length())));
		return sb.toString();
	}

	public String MD5(String md5) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; i++)
				sb.append(Integer.toHexString(array[i] & 0xFF | 0x100).substring(1, 3));
			return sb.toString();
		} catch (NoSuchAlgorithmException noSuchAlgorithmException) {
			return null;
		}
	}
}
