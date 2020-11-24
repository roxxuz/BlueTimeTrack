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
    
    public void showDialog() {
        ImageIcon icon = new ImageIcon("timetrack/timetrack.gui/ic_logo.png");
        int input = JOptionPane.showConfirmDialog(null,"title", "message", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, icon);
        System.out.println(input);
            //return input;
    }
}
