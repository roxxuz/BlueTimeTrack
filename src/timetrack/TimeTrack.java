/*
MAINKLASSEN
*/
package timetrack;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import timetrack.gui.*;

public class TimeTrack {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        
        
        //Login
        LoginGUI loginGUI = new LoginGUI();
        loginGUI.setVisible(true);
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        
        
    }
}
