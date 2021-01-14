package KazukiDEV.WolkenNET.Sites.Post;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;

import KazukiDEV.WolkenNET.Content.mysql;
import spark.Request;
import spark.Response;
import spark.Route;

public class Login implements Route {
  public Login() {}
  
  public Object handle(Request request, Response response) {
    String email = request.queryParams("email");
    String password = request.queryParams("password");
    
    try {
    	String sql = "SELECT * FROM `users` WHERE `email` = ? AND `password_md5` = ?";
    	ResultSet rs = mysql.Query(sql, email, MD5(password));
    	int i = 0;
    	while(rs.next()) {
    		i++;
    		response.cookie("session", rs.getString("session"));
    		response.redirect("/");
    		return null;
    	}
    	if(i==0) {
    		response.redirect("/?l=li&open=login");
    		return null;
    	}
    }catch(Exception e) {
    	e.printStackTrace();
    	response.redirect("/?l=lie&open=login");
		return null;
    }
    return null;
 
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
