package Utilidad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utilidad
{
  public static String loadFileAsString(String path)
  {
    StringBuilder builder = new StringBuilder();
    try
    {
      BufferedReader br = new BufferedReader(new FileReader(path));
      String line;
      while ((line = br.readLine()) != null) {
        builder.append(line + "\n");
      }
      br.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return builder.toString();
  }
  
  public static int parseInt(String numero)
  {
    try
    {
      return Integer.parseInt(numero);
    }
    catch (NumberFormatException e)
    {
      e.printStackTrace();
    }
    return 0;
  }
  
  public static float parseFloat(String numero)
  {
    try
    {
      return Float.parseFloat(numero);
    }
    catch (NumberFormatException e)
    {
      e.printStackTrace();
    }
    return 0;
  }
}
