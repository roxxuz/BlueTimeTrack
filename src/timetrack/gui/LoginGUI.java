
package timetrack.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class LoginGUI extends javax.swing.JFrame {
    
    PreparedStatement pstat;
    ResultSet rs;
    
    GUIMethods guiM = new GUIMethods();
    //Kallar på metoden som förbereder uppkopplingen till MySQL servern
    Connection cn = guiM.prepareDBConnection();
    
    public LoginGUI() {
        
        initComponents();
        loginButton.setVisible(false);
        this.setTitle("LOGIN");
        //Placerar fönstret i mitten av skärmen (ska göra innan setvisible)
        this.setLocationRelativeTo(null);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        motionPanel = new MotionPanel(this);
        mainTopPanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        userLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        emailInput = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        userLogin = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        menuSignInPanel = new javax.swing.JPanel();
        menuSignInLabel = new javax.swing.JLabel();
        menuExitPanel = new javax.swing.JPanel();
        menuExitLabel = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        copyrightLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        motionPanel.setBackground(new java.awt.Color(74, 88, 117));
        motionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainTopPanel.setBackground(new java.awt.Color(47, 66, 84));
        mainTopPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoLabel.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        logoLabel.setForeground(new java.awt.Color(255, 255, 255));
        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setText("TT");
        mainTopPanel.add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 330, 50));

        motionPanel.add(mainTopPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 70));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        userLabel.setForeground(new java.awt.Color(47, 66, 84));
        userLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userLabel.setText("ANVÄNDARNAMN");
        mainPanel.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 330, 30));

        passLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        passLabel.setForeground(new java.awt.Color(47, 66, 84));
        passLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passLabel.setText("LÖSENORD");
        mainPanel.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 330, 30));

        emailInput.setForeground(new java.awt.Color(47, 66, 84));
        emailInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emailInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailInputActionPerformed(evt);
            }
        });
        mainPanel.add(emailInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 330, 30));

        passField.setForeground(new java.awt.Color(47, 66, 84));
        passField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFieldActionPerformed(evt);
            }
        });
        mainPanel.add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 330, 30));

        userLogin.setFont(new java.awt.Font("SansSerif", 1, 8)); // NOI18N
        userLogin.setForeground(new java.awt.Color(47, 66, 84));
        userLogin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        userLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userLoginMouseClicked(evt);
            }
        });
        mainPanel.add(userLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 30, 30));

        loginLabel.setFont(new java.awt.Font("SansSerif", 1, 8)); // NOI18N
        loginLabel.setForeground(new java.awt.Color(47, 66, 84));
        loginLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        loginLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginLabelMouseClicked(evt);
            }
        });
        mainPanel.add(loginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 30, 30));

        menuSignInPanel.setBackground(new java.awt.Color(92, 126, 162));
        menuSignInPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSignInPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuSignInPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuSignInPanelMouseExited(evt);
            }
        });
        menuSignInPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuSignInLabel.setForeground(new java.awt.Color(255, 255, 255));
        menuSignInLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuSignInLabel.setText("LOGGA IN");
        menuSignInPanel.add(menuSignInLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 30));

        mainPanel.add(menuSignInPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 330, 30));

        menuExitPanel.setBackground(new java.awt.Color(92, 126, 162));
        menuExitPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuExitPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuExitPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuExitPanelMouseExited(evt);
            }
        });
        menuExitPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuExitLabel.setForeground(new java.awt.Color(255, 255, 255));
        menuExitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuExitLabel.setText("AVSLUTA");
        menuExitPanel.add(menuExitLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 330, 30));

        mainPanel.add(menuExitPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 330, 30));

        loginButton.setBackground(new java.awt.Color(47, 66, 84));
        loginButton.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Logga in");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        mainPanel.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 40, 10));

        copyrightLabel.setFont(new java.awt.Font("SansSerif", 1, 8)); // NOI18N
        copyrightLabel.setForeground(new java.awt.Color(47, 66, 84));
        copyrightLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyrightLabel.setText("Copyright ©  Team Blue - All rights reserved");
        mainPanel.add(copyrightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 330, 20));

        motionPanel.add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 330, 270));

        getContentPane().add(motionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
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

    private void loginLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginLabelMouseClicked
        startTimeTrack(6);
    }//GEN-LAST:event_loginLabelMouseClicked

    private void userLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLoginMouseClicked
        startTimeTrack(2);
    }//GEN-LAST:event_userLoginMouseClicked

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

    private void menuSignInPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSignInPanelMouseEntered
        menuSignInPanel.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_menuSignInPanelMouseEntered

    private void menuExitPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuExitPanelMouseEntered
        menuExitPanel.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_menuExitPanelMouseEntered

    private void menuSignInPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSignInPanelMouseExited
        menuSignInPanel.setBackground(new java.awt.Color(92,126,162));
    }//GEN-LAST:event_menuSignInPanelMouseExited

    private void menuExitPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuExitPanelMouseExited
        menuExitPanel.setBackground(new java.awt.Color(92,126,162));
    }//GEN-LAST:event_menuExitPanelMouseExited

    private void menuSignInPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSignInPanelMouseClicked
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
    }//GEN-LAST:event_menuSignInPanelMouseClicked

    private void menuExitPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuExitPanelMouseClicked
        this.dispose();
    }//GEN-LAST:event_menuExitPanelMouseClicked

    
    private int loginUser(String email, String pass1){
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel copyrightLabel;
    private javax.swing.JTextField emailInput;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel mainTopPanel;
    private javax.swing.JLabel menuExitLabel;
    private javax.swing.JPanel menuExitPanel;
    private javax.swing.JLabel menuSignInLabel;
    private javax.swing.JPanel menuSignInPanel;
    private javax.swing.JPanel motionPanel;
    private javax.swing.JPasswordField passField;
    private javax.swing.JLabel passLabel;
    private javax.swing.JLabel userLabel;
    private javax.swing.JLabel userLogin;
    // End of variables declaration//GEN-END:variables
}
