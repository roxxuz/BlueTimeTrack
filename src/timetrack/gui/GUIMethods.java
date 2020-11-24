/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetrack.gui;

import javax.swing.JOptionPane;


/**
 *
 * @author Akram
 */
public class GUIMethods {
   
    
    // För att få fram en option dialogruta. 
    public int showOptionDialog(String title, String message) {
       int input = JOptionPane.showConfirmDialog(null, message,title,JOptionPane.YES_NO_CANCEL_OPTION);
        System.out.println(input);
       return input;
       
    }
}
