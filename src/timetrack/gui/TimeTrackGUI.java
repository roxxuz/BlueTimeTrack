
package timetrack.gui;

import java.util.HashSet;
import java.util.Set;

public class TimeTrackGUI extends javax.swing.JFrame {

    //Inloggad användare (ID från databasen)
    //Tilldelas värde med set-metoden setUserID.
    //default = 0 (ingen användare är inloggad).
    private int userID = 0;
    //Skapar objekt av guiMethods
    GUIMethods guiM = new GUIMethods();
    //Skapar objekt av TimerThread som är en "inner class" i GUIMethods
    GUIMethods.TimerThread timerThread = guiM.new TimerThread();

    public TimeTrackGUI() {
        initComponents();
        //Här körs metoden start() som finns i klassen TimerThread som i sin tur finns i klassen GUIMethods
        //Den kommer att starta en ny Thread som kan köras oberoende av det övriga programmet
        //och uppdatera tid och datum via en jLabel längst ner i högra hörnet.
        timerThread.start();
        //Sätter alla paneler (knappar/menyval) till false vid start,
        //förutom Tidrapportering som ska vara default när programmet startar
        projectPanel.setVisible(false);
        timePanel.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new MotionPanel(this);
        jPanel1 = new javax.swing.JPanel();
        loggaUt = new javax.swing.JButton();
        tidRapport = new javax.swing.JButton();
        projekt = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        timePanel = new javax.swing.JPanel();
        timePanelTitle = new javax.swing.JLabel();
        projectPanel = new javax.swing.JPanel();
        projectPanelTitle = new javax.swing.JLabel();
        dateTimeLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        closeBtn = new javax.swing.JLabel();
        minimiseBtn = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(77, 111, 146));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loggaUt.setBackground(new java.awt.Color(34, 43, 61));
        loggaUt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        loggaUt.setForeground(new java.awt.Color(204, 204, 204));
        loggaUt.setText("Logga ut");
        loggaUt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loggaUtActionPerformed(evt);
            }
        });
        jPanel1.add(loggaUt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 200, -1));

        tidRapport.setBackground(new java.awt.Color(34, 43, 61));
        tidRapport.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tidRapport.setForeground(new java.awt.Color(204, 204, 204));
        tidRapport.setText("Tidrapportering");
        tidRapport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidRapportActionPerformed(evt);
            }
        });
        jPanel1.add(tidRapport, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 200, -1));

        projekt.setBackground(new java.awt.Color(34, 43, 61));
        projekt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        projekt.setForeground(new java.awt.Color(204, 204, 204));
        projekt.setText("Projekt");
        projekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projektActionPerformed(evt);
            }
        });
        jPanel1.add(projekt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 200, -1));

        jPanel7.setBackground(new java.awt.Color(79, 100, 144));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ola Svärdh");
        jPanel7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 30, 140, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Inloggad som:");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 10, 140, -1));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 140, 60));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 220, 510));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timePanel.setBackground(new java.awt.Color(255, 255, 255));
        timePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timePanelTitle.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        timePanelTitle.setForeground(new java.awt.Color(242, 242, 242));
        timePanelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timePanelTitle.setText("Tidrapportering");
        timePanel.add(timePanelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 730, -1));

        mainPanel.add(timePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 490));

        projectPanel.setBackground(new java.awt.Color(255, 255, 255));
        projectPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        projectPanelTitle.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        projectPanelTitle.setForeground(new java.awt.Color(242, 242, 242));
        projectPanelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        projectPanelTitle.setText("Projekt");
        projectPanel.add(projectPanelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 730, -1));

        mainPanel.add(projectPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 490));

        dateTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mainPanel.add(dateTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, 330, 20));

        jPanel2.add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 730, 510));

        jPanel4.setBackground(new java.awt.Color(54, 69, 100));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closeBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        closeBtn.setForeground(new java.awt.Color(204, 204, 204));
        closeBtn.setText("X");
        closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeBtnMouseClicked(evt);
            }
        });
        jPanel4.add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 10, -1));

        minimiseBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        minimiseBtn.setForeground(new java.awt.Color(204, 204, 204));
        minimiseBtn.setText("━");
        minimiseBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimiseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimiseBtnMouseClicked(evt);
            }
        });
        jPanel4.add(minimiseBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, 10, -1));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetrack/gui/ic_logo2.jpg"))); // NOI18N
        jPanel4.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 70));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseClicked
        this.dispose();
        //Stänger av visningen av datum och tid via metoden setRunnig()
        //Detta är för att den Thread som körs parallellt ska avslutas
        timerThread.setRunning(false);
    }//GEN-LAST:event_closeBtnMouseClicked

    private void minimiseBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimiseBtnMouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_minimiseBtnMouseClicked

    private void projektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projektActionPerformed
        timePanel.setVisible(false);
        projectPanel.setVisible(true);
    }//GEN-LAST:event_projektActionPerformed

    private void tidRapportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidRapportActionPerformed
        projectPanel.setVisible(false);
        timePanel.setVisible(true);
    }//GEN-LAST:event_tidRapportActionPerformed

    private void loggaUtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loggaUtActionPerformed
        signOut();
    }//GEN-LAST:event_loggaUtActionPerformed

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
            java.util.logging.Logger.getLogger(TimeTrackGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TimeTrackGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TimeTrackGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TimeTrackGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TimeTrackGUI().setVisible(true);
                
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel closeBtn;
    private static javax.swing.JLabel dateTimeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JButton loggaUt;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel minimiseBtn;
    private javax.swing.JPanel projectPanel;
    private javax.swing.JLabel projectPanelTitle;
    private javax.swing.JButton projekt;
    private javax.swing.JButton tidRapport;
    private javax.swing.JPanel timePanel;
    private javax.swing.JLabel timePanelTitle;
    // End of variables declaration//GEN-END:variables

    
    private void signOut(){
        //skapar objekt av LoginGUI innan programmet avslutas (användaren loggas ut)
        LoginGUI loginGUI = new LoginGUI();
        //avslutar huvudprogrammet
        this.dispose();
        //Stänger av visningen av datum och tid via metoden setRunnig()
        //Detta är för att den Thread som körs parallellt ska avslutas
        timerThread.setRunning(false);
        //visar login-ruta igen
        loginGUI.setVisible(true);
    }
    
    //Metod som används för att uppdatera datum och tid i programmet
    public static void updateDateTime(String updatedDateTime) {
        //Eftersom deklarationen av jLabel dateTimeLabel är ändrad till static
        //så kan vi skriva direkt till den från en statisk metod
        dateTimeLabel.setText(updatedDateTime);
    }
    
    ////////
    /////////Get och set metoder längst ner
    ////////
    
    public void setUserID(int userID) {
        this.userID = userID;
      
    }
    
    public int getUserID() {
        return userID;
    }
    
}
