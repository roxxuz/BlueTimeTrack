
package timetrack.gui;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Akram
 */
public class GUIMethods {
    
    Connection cn;
    PreparedStatement pstat;
    ResultSet rs;
    String DBAddress;
    String DBUser;
    String DBPass;
    
    //Konstruktor
    public GUIMethods() {
        //Värden från filen db.properties läses in
        readProperties();
        //Lägger in allt som behövs för uppkopplingen till databasen
        //efter att readProperties har läst in värdena i programmet
        cn = prepareDBConnection();
    }
    
    
    public int showDialog(String title, String message) {
        //ImageIcon icon = new ImageIcon("C:\\Users\\Akram\\OneDrive\\Skrivbord\\TimeTrack\\src\\timetrack\\gui\\ic_logo2.png");
        int input = JOptionPane.showConfirmDialog(null,message,title, JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        
            return input;
           
    }
    
    //Denna metod körs varje gång som en instans skapas av klassen (ligger i konstruktorn)
    //Den läser då in de värden som finns i db.properties
    private void readProperties(){
        //Skapar objekt av Properties för att läsa från filen db.properties
        Properties prop = new Properties();
        try {
            FileReader reader = new FileReader("src/timetrack/gui/db.properties");
            prop.load(reader);
            //Tilldelar värdena från filen db.properties till klassvariablerna
            //som sedan ska användas för att logga in på databasen
            DBAddress = prop.getProperty("db");
            DBUser = prop.getProperty("user");
            DBPass = prop.getProperty("pass");
            reader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Kanske saknas filen db.properties i src/timetrack/gui?");
        } catch (IOException ex) {
            Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Kanske saknas filen db.properties i src/timetrack/gui?");
        }
        
    }
    
    /**
    * Använd endast denna metod från den klass där metoden finns
    * I annat fall så ska jFrame skickas med
    * Den här metoden måste anropas efter att
    * DBAddress, DBUser och DBPass har fått värden
    * T.ex. via metoden readProperties()
    * @param text test
    */
    public Connection prepareDBConnection() {
        //Skapar Connection variabel för att kunna skicka tillbaka till anropet
        Connection con = null;
        try {
            con = DriverManager.getConnection(DBAddress, DBUser, DBPass);
        } catch (SQLException ex) {
            Logger.getLogger(GUIMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    
    public class TimerThread extends Thread{
        //Så länge som isRunning=true så uppdateras tiden
        boolean isRunning;
        //Här anges i vilket format som datum och tid ska visas
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        public TimerThread() {
            //isRunning sätts till true direkt i konstruktorn
            //Metoden getRunning() kan användas för att se om den är igång eller inte
            //Det kan behövs för att veta om man måste stänga den när programmet avslutas
            this.isRunning = true;
        }
        
        //Gör Override på metoden run() (kolla i klassen Thread för att se hur run() fungerar)
        @Override
        public void run() {
            //While-loop som kör så länge som isRunning=true
            //Vi stänger av den med metoden setRunning(false) som då ger boolean isRunning värdet false
            while (isRunning) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        //Hämtar tid och datum med dom statiska metoderna getInstance() och getTime()
                        Calendar currentCalendar = Calendar.getInstance();
                        Date currentTime = currentCalendar.getTime();
                        //Skapar en string där aktuellt datum och tid först in
                        String dateTime = (dateFormat.format(currentTime) + "  |  " + timeFormat.format(currentTime));
                        //Strängen skickas med till metoden updateDateTime() som ligger i TImeTrackGUI
                        //Denna metod är static och kan därför användas direkt såhär
                        //Eftersom tiden inte ska behandlas på olika sätt för
                        //olika objekt så valde jag att göra den static
                        TimeTrackGUI.updateDateTime(dateTime);
                        
                    }
                });
                try {
                    //Programmet (endast denna thread) stannar i x antal millisekunder
                    //5000 millisekunder = 5 sekunder
                    //while-loopen kommer alltså att köras och uppdatera tiden var 5'e sekund
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
        
        //Metod för att kunna stänga av uppdateringen av tid och datum
        //Eftersom while-loopen använder denna så kommer den av avbrytas
        //om isRunning sätts till false.
        //När en Thread har kört klart sina metoder så avslutas den automatiskt.
        //Vi kan därfö använda denna metod för att stänga av denna thread när 
        //programmet ska avslutas
        public void setRunning(boolean isRunning) {
            this.isRunning = isRunning;
        }
        
        //Metod för att kunna kolla om denna Thread körs
        //Denna kan vi använda för att veta om vi måste stänga av den i samband
        //med att användaren stänger programmet.
        //Om den fortfarande körs så kommer programmet inte att stänga helt
        public boolean getRunning() {
            return this.isRunning;
        }
    }
        public boolean resetpw(String password, int userid){
            boolean success = false;
            try {
            pstat = cn.prepareStatement("update users set user_password = ? where user_id = ?");
            pstat.setString(1, password);
            pstat.setInt(2, userid);
            pstat.executeUpdate();
    /*        if(rs.next()){
                System.out.println(result);
            }*/
                success = true;
        } catch (SQLException ex) {
                System.out.println(ex);
        }
            return success;
        }
        
    static String pStart;//Static eftersom alla ska ha tillgång till den.
    static String pEnd;
    static String pTotalTime;
    
    private static void projectStartTime() {

        Locale sv = new Locale ("sv","SV");//Skapar en Locale så att datum visas på svenska, alltså "EEEE"(dag) står på svenska.
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());//Hämta/stämpla nuvarande tid
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-(EEEE) HH:mm",sv);//Spara tiden enligt år,måndad,dag(dag ej i siffror)timmar, dagar.
        
        String startTime = sdf.format(ts);//Spara värden i en string om vi vill använda värden senare, exempelvis en totalTime.
        System.out.println(startTime);//Anledning till utskrivning är för att lätt kunan se om något händer.
        
        pStart=startTime;//Spara tiden i pStart i class så alla har tillgång till den.
    }
     private static void projectEndTime() {
      Locale sv = new Locale ("sv","SV");
      Date date = new Date();
      Timestamp ts = new Timestamp(date.getTime());
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-(EEEE) HH:mm",sv);
      
      String endTime = sdf.format(ts);
      System.out.println(endTime);
      
      pEnd = endTime;
    }
  
    private static void projectTotalTime()  {    
        Locale sv = new Locale ("sv","SV");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-(EEEE) HH:mm",sv);

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(pStart);//Formaterar till den format startTime och endTime har för att kunna göra uträkning.
            d2 = format.parse(pEnd);

            //in milliseconds
            long diff = d2.getTime() - d1.getTime();//pEnd - pStart för uträkning

            long diffMinutes = diff / (60 * 1000) % 60;//Gör om millisekunder till minut.
            long diffHours = diff / (60 * 60 * 1000) % 24;//Gör om minut till timmar.
            long diffDays = diff / (24 * 60 * 60 * 1000);//Gör om timmar till dagar.

            System.out.print("Total project time: " +diffDays + " dagar, "+diffHours + " timmar, "+diffMinutes + " minuter, ");
            String days = String.valueOf(diffDays);//Sparade alla dessa i String för att kunna slå ihop dem till en enda sträng.
            String hours = String.valueOf(diffHours);
            String minutes = String.valueOf(diffMinutes);
            pTotalTime = "Dagar: "+days+" Timmar: "+hours+" Minuter: "+minutes;//Slår ihop alla till en sträng och spara i class.
            
        } 
        catch (ParseException e) {
        }
    }
}
