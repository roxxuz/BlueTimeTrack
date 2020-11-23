/*
MAINKLASSEN!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!!!!!!!!!!!!!!!!!!!!
 */
package timetrack;

import timetrack.model.*;
import timetrack.gui.*;

public class TimeTrack {

    public static void main(String[] args) {
        
        //Skapar GUI (JFrame objekt) till programmet 
        TimeTrackGUI tGUI = new TimeTrackGUI();
        
        //Kallar på main-metoden i JFrame eftersom att det finns kod där som autogenereras
        //i designläget och den kommer kanske att ändra sig under tiden?
        tGUI.main(null);
        
        //Gör en dispose för att programmet ska stänga helt efter exit.
        //Programmet kommer endast hit när JFrame stängs
        tGUI.dispose();
    }
}
