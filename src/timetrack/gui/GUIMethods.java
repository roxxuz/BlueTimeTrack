/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetrack.gui;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Akram
 */
public class GUIMethods {
    
    
    public int showDialog(String title, String message) {
        //ImageIcon icon = new ImageIcon("C:\\Users\\Akram\\OneDrive\\Skrivbord\\TimeTrack\\src\\timetrack\\gui\\ic_logo2.png");
        int input = JOptionPane.showConfirmDialog(null,message,title, JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        
            return input;
           
    }
    
    
    public class TimerThread extends Thread{
        
        boolean isRunning;

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
            while (isRunning) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        //Hämtar tid och datum med dom statiska metoderna getInstance() och getTime()
                        Calendar currentCalendar = Calendar.getInstance();
                        Date currentTime = currentCalendar.getTime();
                        //Här uppdateras dateTimeLabel i TimeTrackGUI med aktuellt datum och tid.
                        //Den är ändrad till static i TimeTrackGUI och kan därför uppdateras direkt såhär
                        TimeTrackGUI.dateTimeLabel.setText(dateFormat.format(currentTime) + "  |  " + timeFormat.format(currentTime));
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
}
