/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetrack.gui;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Akram
 */
public class GUIMethod {
    
    public int showDialog(String title, String message) {
        ImageIcon icon = new ImageIcon("C:\\Users\\Akram\\OneDrive\\Skrivbord\\TimeTrack\\src\\timetrack\\gui\\ic_logo2.png");
        int input = JOptionPane.showConfirmDialog(null,message,title, JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, icon);
        
            return input;
           
    }
}
