
package timetrack.gui;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author roxxu
 */
public class LoginGUI extends javax.swing.JFrame {
    
    Connection cn = null;
    PreparedStatement pstat = null;
    ResultSet rs = null;

    String DBAddress = "";
    String DBUser = "";
    String DBPass = "";
    
    public LoginGUI() {
        //Tagen från main till konstruktorn för att koden ska köras när objektet skapas
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        initComponents();
        this.setTitle("LOGIN");
        //Placerar fönstret i mitten av skärmen (ska göra innan setvisible)
        this.setLocationRelativeTo(null);
        //Kallar på metoden som läser in värden från filen db.properties
        //och sparar i strängarna DBAddress, DBUser och DBPass
        readProperties();
    }
    
    //Loginmetod som kallas på från main direkt när programmet startar
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel = new MotionPanel(this);
        emailLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        titleLable = new javax.swing.JLabel();
        emailInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        passField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginPanel.setBackground(new java.awt.Color(54, 69, 100));
        loginPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        loginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(204, 204, 204));
        emailLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        emailLabel.setText("Användarnamn:");
        loginPanel.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 66, 100, 20));

        passLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        passLabel.setForeground(new java.awt.Color(204, 204, 204));
        passLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        passLabel.setText("Lösenord:");
        loginPanel.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 96, 100, 20));

        titleLable.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        titleLable.setForeground(new java.awt.Color(255, 255, 255));
        titleLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLable.setText("- Time Track -");
        loginPanel.add(titleLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 10, 260, 30));

        emailInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailInputActionPerformed(evt);
            }
        });
        loginPanel.add(emailInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 120, 30));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Logga in med användarnamn och lösenord");
        loginPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 240, -1));

        exitButton.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        exitButton.setText("Avsluta");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        loginPanel.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 80, -1));

        loginButton.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        loginButton.setText("Logga in");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        loginPanel.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        passField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFieldActionPerformed(evt);
            }
        });
        loginPanel.add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 92, 120, 30));

        getContentPane().add(loginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        //Hämtar inmatningarna i textfälten
        String email = emailInput.getText();
        String pass = passField.getText();
        
        //If-satsen anropar metoden loginUser och skickar med email och pass från textfälten
        //Metoden kommer returnera en int med användarens ID, som lagras i userID.
        //Om användare + lösenord är fel eller inte finns så returneras 0.
        int userID = loginUser(email,pass);
        
        if(userID > 0){
            //Kallar på metoden som ska starta huvudprogrammet och skickar med 
            //inloogad användares userID (från databasen)
            startTimeTrack(userID);
        }
    }//GEN-LAST:event_loginButtonActionPerformed
    
    //Kommer hit om användaren trycker "ENTER" i textrutan.
    //Tangenten "enter" räknas som en action och det räcker därför med att bara
    //ha en actionListener.
    private void passFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFieldActionPerformed
        //Kallar på metoden loginButtonActionPerformed() som är samma
        //som när användaren trycker på OK vid inloggning.
        loginButtonActionPerformed(evt);
    }//GEN-LAST:event_passFieldActionPerformed
    
    //Kommer hit om användaren trycker "ENTER" i textrutan.
    //Tangenten "enter" räknas som en action och det räcker därför med att bara
    //ha en actionListener.
    private void emailInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailInputActionPerformed
        //Kallar på metoden loginButtonActionPerformed() som är samma
        //som när användaren trycker på OK vid inloggning.
        loginButtonActionPerformed(evt);
    }//GEN-LAST:event_emailInputActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
        
    }
    private int loginUser(String email, String pass1){
        String qEmail = email;
        String qPass = pass1;
        //returnUserID som kommer att returnera UserID från databasen om användarnamn + lösenord matchar
        //Annars är den default 0 och returnerar då 0.
        int returnUserID = 0;
        try {
            //Ökar timeout till 5 sekunder
            DriverManager.setLoginTimeout(5);
            //Skapar en koppling till DB med dess adress, user och pass
            cn = DriverManager.getConnection(DBAddress, DBUser, DBPass);
            //Skapar ett SELECT statement till PreparedStatement objekt
            pstat = cn.prepareStatement("select * from users where email=? and user_password=?");
            //Ändrar value-parametrar till texten i text-fälten.
            pstat.setString(1, qEmail);
            pstat.setString(2, qPass);
            //Utför SQL kommand
            rs = pstat.executeQuery();
            //Kollar om det finns MINST en rad från select statement (while hade kollat alla)
            if(rs.next()){
                //sparar värdet från första kolumnen (userID) från Select statemant.
                returnUserID = rs.getInt(1);
            }
            //Om ingen rad returneras från select statemant så betyder det att kombinationen
            //av användarnamn och lösenord ej hittades i databasen och då körs istället else.
            else{
                JOptionPane.showMessageDialog(null, "Felaktigt användarnamn/lösenord", "Ej behörig!", 0);
            }
            //Stänger kopplingen till databasen så att inte
            //max antal användare för databasen ska överskridas.
            cn.close();
        //Om något går fel med kopplingen till databasen... (kommer även hit om felaktigt select statement används osv.
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kunde inte ansluta till databasen.\nKontrollera att du är ansluten till internet.", "Är du online?", 0);
            System.out.println(ex);
        }
        //Returnerar userID (från databasen)
        //Om login misslyckades så returneras 0.
        return returnUserID;
    }
    
    private void startTimeTrack(int userID){
        
        TimeTrackGUI tGUI = new TimeTrackGUI();
        //Sätter inloggad användare till userID (från databasen)
        tGUI.setUserID(userID);
        //Placerar objeketet i mitten på användarens skärm
        tGUI.setLocationRelativeTo(null);
        tGUI.setVisible(true);
        this.dispose();
        
    }
    
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
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailInput;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPasswordField passField;
    private javax.swing.JLabel passLabel;
    private javax.swing.JLabel titleLable;
    // End of variables declaration//GEN-END:variables
}
