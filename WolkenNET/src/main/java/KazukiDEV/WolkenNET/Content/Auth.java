package KazukiDEV.WolkenNET.Content;

import java.security.SecureRandom;

public class Auth {
	
	public static String generateSessionCookie() {
		return randomString(30);
	}
	static SecureRandom rnd = new SecureRandom();
	
	static String randomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
					.charAt(rnd.nextInt("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".length())));
		return sb.toString();
	}

}
