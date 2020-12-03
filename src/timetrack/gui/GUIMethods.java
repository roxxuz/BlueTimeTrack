
package timetrack.gui;


import java.awt.Color;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Akram
 */
public class GUIMethods{
    
    Connection cn;
    PreparedStatement pstat;
    ResultSet rs;
    String DBAddress;
    String DBUser;
    String DBPass;
    JFrame loginJFrame;
    String currentUser;
    TimeTrackGUI tGUI;
    
    //Konstruktor
    public GUIMethods() {
        readProperties();
        cn = prepareDBConnection();
    }
    
    public int loginUser(String email, String pass1){
        String qEmail = email;
        String qPass = pass1;
        //returnUserID som kommer att returnera UserID från databasen om användarnamn + lösenord matchar
        //Annars är den default 0 och returnerar då 0.
        int returnUserID = 0;
        try {
            //Ökar timeout till 5 sekunder
            DriverManager.setLoginTimeout(5);
            //Skapar ett SELECT statement till PreparedStatement objekt
            pstat = cn.prepareStatement("SELECT * FROM users WHERE email=? AND BINARY user_password=?");
            //Ändrar value-parametrar till texten i text-fälten.
            pstat.setString(1, qEmail);
            pstat.setString(2, qPass);
            //Utför SQL kommand
            rs = pstat.executeQuery();
            //Kollar om det finns MINST en rad från select statement (while hade kollat alla)
            if(rs.next()){
                //sparar värdet från första kolumnen (userID) från Select statemant.
                returnUserID = rs.getInt(1);
                currentUser = rs.getString(2) + " " + rs.getString(3);
            }
            //Om ingen rad returneras från select statemant så betyder det att kombinationen
            //av användarnamn och lösenord ej hittades i databasen och då körs istället else.
            else{
                JOptionPane.showMessageDialog(null, "Felaktigt användarnamn/lösenord", "Ej behörig!", 0);
            }
            
        //Om något går fel med kopplingen till databasen... (kommer även hit om felaktigt select statement används osv.
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kunde inte ansluta till databasen.\nKontrollera att du är ansluten till internet.", "Är du online?", 0);
            System.out.println(ex);
        }
        //Returnerar userID (från databasen)
        //Om login misslyckades så returneras 0.
        return returnUserID;
    }
    
    public int showDialog(String title, String message) {
        //ImageIcon icon = new ImageIcon("C:\\Users\\Akram\\OneDrive\\Skrivbord\\TimeTrack\\src\\timetrack\\gui\\ic_logo2.png");
        int input = JOptionPane.showConfirmDialog(null,message,title, JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        
            return input;
           
    }
    
    private void readProperties(){
        //Metod som läser in värden från filen db.properties
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
    
    public void setCurrentUserLabel(TimeTrackGUI tGUI) {
        tGUI.currentUserLabel.setText(currentUser);
    }
    
    public Connection prepareDBConnection() {
        //Skapar Connection variabel med login info till DB
        //och returnerar den
        Connection con = null;
        try {
            con = DriverManager.getConnection(DBAddress, DBUser, DBPass);
        } catch (SQLException ex) {
            Logger.getLogger(GUIMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
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
    
    public void closeDBConnection() {
    try {
        cn.close();
    } catch (SQLException ex) {
        Logger.getLogger(GUIMethods.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public void startTimeTrack(JFrame loginJFrame, GUIMethods loginGUI_guiM, int userID){
        this.loginJFrame = loginJFrame;
        loginJFrame.setVisible(false);
        //Gör loginrutan osynlig när användaren har loggat in
        TimeTrackGUI tGUI = new TimeTrackGUI(loginJFrame);
        //Sätter inloggad användare till userID (från databasen)
        tGUI.setUserID(userID);
        setCurrentUserLabel(tGUI);
        //Placerar objeketet i mitten på användarens skärm
        tGUI.setLocationRelativeTo(null);
        tGUI.setVisible(true);
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
        //Vi kan därfö använda denna metod för att stänga av thread när 
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
    

      public boolean deleteProject(int projectid){
            boolean success = false;
            try {
            pstat = cn.prepareStatement("delete from projects where projects_id = ?");
            pstat.setInt(1, projectid);
            pstat.executeUpdate();
            
                success = true;
        }   catch (SQLException ex) {
                System.out.println(ex);
        } 
            return success;
        }
        
            public boolean deleteUser(int userid){
            boolean success = false;
            try {
            pstat = cn.prepareStatement("delete from users where user_id = ?");
            pstat.setInt(1, userid);
            pstat.executeUpdate();
            
                success = true;
        }   catch (SQLException ex) {
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

            
            public boolean createProject(String pname, String pdesc, int pstatus,int custid){
                boolean success = false;
                try {
                    pstat = cn.prepareStatement("insert into projects (project_name, project_description, project_status_id, customer_id) VALUES (?,?,?,?)");
                    pstat.setString(1, pname);
                    pstat.setString(2, pdesc);
                    pstat.setInt(3, pstatus);
                    pstat.setInt(4, custid);
                    pstat.executeUpdate();
                    
                    success = true;
                } catch (SQLException ex) {
                        System.out.println(ex);
                        }
                return success;
                }
            
            
            
              public boolean createUser(String name, String lastName, String email, String password, String skill, boolean isAdmin) {
                boolean success = false;
                try {
                     pstat = cn.prepareStatement("insert into users (FName, LName, email, user_password, is_admin) VALUES (?,?,?,?,?) ");
                     pstat.setString(1,name);            
                     pstat.setString(2,lastName);
                     pstat.setString(3,email);
                     pstat.setString(4,password);
                     pstat.setBoolean(5, isAdmin);
                     pstat.executeUpdate();
            
                    success = true;
            
             } catch (SQLException ex) {
                 System.out.println(ex);
                        }
                return success;
             }
            
              public void getAvailableSkills() {
                  tGUI.jComboBox1.removeAllItems();
        try {
            pstat = cn.prepareStatement("select skill from skills");
            rs = pstat.executeQuery();
            while(rs.next()) {
                tGUI.jComboBox1.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUIMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
            
              }

    public class Thread2 extends Thread {
      
    public void run(){
        //Gör en fade in och fade out på en Label
        //Ska från vit 255,255,255 till grön 60,117,57
        try {
            Thread.sleep(750);
        } catch (InterruptedException ex) {
            Logger.getLogger(GUIMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < 255; i=i+2) {
             
            tGUI.setTimeSucceededLabelColor(new java.awt.Color(60, 117, 57, i));
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.err.println("Fel i faden på texten \"Din tidrapportering har registrerats\"");
            }
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(GUIMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 255; i > 0; i--) {
             
            tGUI.setTimeSucceededLabelColor(new java.awt.Color(60, 117, 57, i));
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.err.println("Fel i faden på texten \"Din tidredovisning har registrerats\"");
            }
        }
    }
  }
    public ResultSet getUserProjects(int userID) {
    try {
            //Skapar ett SELECT statement till PreparedStatement objekt
            pstat = cn.prepareStatement("SELECT project_name FROM projects p\n" +
                                        "join users_has_projects up on p.projects_id = up.project_id\n" +
                                        "join users u on up.user_id = u.user_id\n" +
                                        "where u.user_id = ?");
            
            pstat.setInt(1, userID);
            //Utför SQL statement till Databas. Returnerar ett resultat till ResultSet rs
            rs = pstat.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    return rs;
    }
    
    public boolean sendTimeToDB(int userID, int project, String date, String startTime, String endTime){
        //Slår samman datum och tid till en sträng. Det är så den lagras i databasen
        String dateTimeStart = date + " " + startTime;
        String dateTimeEnd = date + " " + endTime;
        boolean success = false;
        try {
        pstat = cn.prepareStatement("INSERT INTO time (start_time, end_time, user_id, project_id) VALUES (?, ?, ?, ?);");
        pstat.setString(1, dateTimeStart);
        pstat.setString(2, dateTimeEnd);
        pstat.setInt(3, userID);
        pstat.setInt(4, project);
        int re = pstat.executeUpdate();
        //Kontrollerar om det är mer än 0 tillbaka så har det lyckats
        if (re > 0) {
            //Ny thread startar som kommer att visa en text med att rapporteringen har lyckats
            Thread2 thread2 = new Thread2();
            thread2.start();
            tGUI.setTimeDefaultValues();
        }
        else {
            System.err.println("Något gick fel med att skicka tidrapporteringen");
        }
    } catch (SQLException ex) {
            System.out.println(ex);
    }
        return success;
    }
    
    public int getProjectID(String projectName){
        try {
        pstat = cn.prepareStatement("select projects_id from projects where project_name = ?");
        pstat.setString(1, projectName);
        rs = pstat.executeQuery();
        } catch (SQLException ex) {
                System.out.println(ex);
        }
        int projectID = 0;
        try {
            if(rs.next()) {
                projectID = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUIMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projectID;
    }
    
    public boolean isCorrectTimeFields(String date, String startTime, String endTime) {
        boolean isCorrect = false;
        //Kollar så att inmatnig av datum och tid är i korrekt format
        if(isValidFormat("yyyy-MM-dd", date, Locale.ENGLISH)
        && isValidFormat("H:mm", startTime, Locale.ENGLISH)
        && isValidFormat("H:mm", endTime, Locale.ENGLISH)) {
            isCorrect = true;
        }
        return isCorrect;
    }
    
    public boolean isValidFormat(String format, String value, Locale locale) {
    //Kontrollerar om datum eller tid är angett i korrekt format
    //Kolla i metoden isCorrectTimeFields() för att se hur den kan användas
    LocalDateTime ldt = null;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format, locale);

    try {
        ldt = LocalDateTime.parse(value, formatter);
        String result = ldt.format(formatter);
        return result.equals(value);
    } catch (DateTimeParseException e) {
        try {
            LocalDate ld = LocalDate.parse(value, formatter);
            String result = ld.format(formatter);
            return result.equals(value);
        } catch (DateTimeParseException exp) {
            try {
                LocalTime lt = LocalTime.parse(value, formatter);
                String result = lt.format(formatter);
                return result.equals(value);
            } catch (DateTimeParseException e2) {
            }
        }
    }

    return false;
}
    
    public void setTimeTrackGUI(TimeTrackGUI tGUI) {
        this.tGUI = tGUI;
    }

}
