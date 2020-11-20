/*

 */
package timetrack;
//JAG LÄGGER TILL EN KOMMENTAR HÄR!!!!!!!!!!!
// Test från IntelliJ
import timetrack.model.*;
import timetrack.gui.*;

/**
 *
 * @author aquar
 */
public class TimeTrack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Skapar GUI (JFrame objekt) till programmet 
        TimeTrackGUI tGUI = new TimeTrackGUI();
        
        //Kallar på main-metoden i JFrame eftersom att det finns kod där som autogenereras
        //i designläget och den kommer kanske att ändra sig under tiden?
        tGUI.main(null);
        
        //Gör en dispose för att programmet ska stänga helt efter exit.
        //Programmet kommer endast hit när JFrame stängs
        tGUI.dispose();
        
       
        
        
        
//        User myUser = new User();
//        myUser.setID(1);
//        myUser.setName("Kalle");
//        myUser.setEmail("kalle@example.org");
//        myUser.setPassword("changeit");
//        myUser.setAdmin(false);
        
        //Print out a oneline string with the user properies using the get methods
        
        
        //System.out.println("ID: " + myUser.getID() + " Name: " + myUser.getName() + " E-mail: " + myUser.getEmail() + " Password: " + myUser.getPassword());
        //System.out.println(myUser.getAllInfo());

        // try {
        //   System.out.println("Hello World!" + User.getID + );
            
        //} catch (Exception e) {
        //    System.out.println(e.getMessage());
        //}
    }
    
    
}
