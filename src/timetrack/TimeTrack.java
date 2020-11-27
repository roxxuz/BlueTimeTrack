/*
MAINKLASSEN
*/
package timetrack;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import timetrack.gui.*;

public class TimeTrack {
private static void startTime() {
        Locale sv = new Locale ("sv","SV");//Skapar en Locale så att datum visas på svenska, alltså "EEEE"(dag) står på svenska.
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());//Hämta/stämpla nuvarande tid
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-(EEEE) HH:mm",sv);//Spara tiden enligt år,måndad,dag(dag ej i siffror)timmar, dagar.
        
        String startTime = sdf.format(ts);//Spara värden i en string om vi vill använda värden senare, exempelvis en totalTime.
        System.out.println(startTime);
    }
  private static void endTime() {
      Locale sv = new Locale ("sv","SV");
      Date date = new Date();
      Timestamp ts = new Timestamp(date.getTime());
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-(EEEE) HH:mm",sv);
      
      String endTime = sdf.format(ts);
      System.out.println(endTime);
  }
    /**
     * @param args the command line arguments
     */
 
    public static void main(String[] args) {
        
        //Login
        LoginGUI loginGUI = new LoginGUI();
        loginGUI.setVisible(true);
        
        
    }
}
