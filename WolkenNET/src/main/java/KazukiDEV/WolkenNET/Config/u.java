package KazukiDEV.WolkenNET.Config;

import java.io.PrintStream;

import KazukiDEV.WolkenNET.Content.Color;

public class u {
  public static PrintStream s = System.out;
  
  public static String info = Color.MAGENTA + "[" + Color.BLUE + "INFO" + Color.MAGENTA + "] "  + Color.RESET;
  
  public static String warning = Color.MAGENTA + "[" + Color.YELLOW + "WARNING" + Color.MAGENTA + "] "  + Color.RESET;
  
  public static String error = Color.MAGENTA + "[" + Color.RED + "ERROR" + Color.MAGENTA + "] " + Color.RESET;
  
  public static String mysql = Color.MAGENTA + "[" + Color.GREEN + "MySQL" + Color.MAGENTA + "] " + Color.RESET;
  
  public static String recaptcha = Color.MAGENTA + "[" + Color.CYAN + "Google ReCaptcha v2" + Color.MAGENTA + "] " + Color.RESET;
}
