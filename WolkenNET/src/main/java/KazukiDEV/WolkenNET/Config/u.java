package KazukiDEV.WolkenNET.Config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

import KazukiDEV.WolkenNET.Content.Color;

public class u {
  public static PrintStream s = System.out;
  
  public static String info = Color.MAGENTA + "[" + Color.BLUE + "INFO" + Color.MAGENTA + "] "  + Color.RESET;
  
  public static String warning = Color.MAGENTA + "[" + Color.YELLOW + "WARNING" + Color.MAGENTA + "] "  + Color.RESET;
  
  public static String error = Color.MAGENTA + "[" + Color.RED + "ERROR" + Color.MAGENTA + "] " + Color.RESET;
  
  public static String mysql = Color.MAGENTA + "[" + Color.GREEN + "MySQL" + Color.MAGENTA + "] " + Color.RESET;
  
  public static String recaptcha = Color.MAGENTA + "[" + Color.CYAN + "Google ReCaptcha v2" + Color.MAGENTA + "] " + Color.RESET;
  
  public static String getHTML(String urlToRead) throws Exception {
      StringBuilder result = new StringBuilder();
      URL url = new URL(urlToRead);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String line;
      while ((line = rd.readLine()) != null) {
         result.append(line);
      }
      rd.close();
      return result.toString();
   }
}
