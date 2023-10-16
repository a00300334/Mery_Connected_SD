/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

/**
 *
 * @author SRI-mpidgeon
 */

import java.io.*;
import java.net.*;
 
public class ReadWebPage2 {
   public static void main(String args[]) {
      String line;
      URL url;
      InputStream urlStream;
      BufferedReader html;
      try {
         url = new URL("https://www.rte.ie/news/");
         urlStream = url.openStream();// returns InputStream
       
         // User buffered reader to read  the InputStream - see javadocs for the following syntax
         html = new BufferedReader(new InputStreamReader(urlStream));
         while ((line = html.readLine()) != null) {
            System.out.println(line);
         }
      } catch (MalformedURLException ex) {
         System.out.println("ex: " + ex);   
      } catch (Exception ex) {
         System.out.println("ex: " + ex);
      }
   }
}
