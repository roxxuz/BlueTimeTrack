
package timetrack.gui;

import java.awt.Color;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

public class TimeTrackGUI extends javax.swing.JFrame {

    //Inloggad användare (ID från databasen)
    //Tilldelas värde med set-metoden setUserID.
    //default = 0 (ingen användare är inloggad).
    private int userID = 0;
    //Skapar objekt av guiMethods
    GUIMethods guiM = new GUIMethods();
    //Skapar objekt av TimerThread som är en "inner class" i GUIMethods
    GUIMethods.TimerThread timerThread = guiM.new TimerThread();
    Boolean[] menuArray = new Boolean[5];

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
        
        Arrays.fill(menuArray, Boolean.FALSE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new MotionPanel(this);
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        timePanel = new javax.swing.JPanel();
        timePanelTitle = new javax.swing.JLabel();
        projectPanel = new javax.swing.JPanel();
        jXGraph2 = new org.jdesktop.swingx.JXGraph();
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
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(66, 91, 117));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Inställningar");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 190, -1));

        jPanel12.setBackground(new java.awt.Color(47, 66, 84));
        jPanel3.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 190, 40));

        jPanel5.setBackground(new java.awt.Color(66, 91, 117));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Rapporter");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 10, 190, -1));

        jPanel11.setBackground(new java.awt.Color(47, 66, 84));
        jPanel5.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 190, 40));

        jPanel6.setBackground(new java.awt.Color(66, 91, 117));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tidrapportering");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 10, 190, -1));

        jPanel9.setBackground(new java.awt.Color(47, 66, 84));
        jPanel6.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 190, 40));

        jPanel7.setBackground(new java.awt.Color(66, 91, 117));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel7MouseExited(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Projekt");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 10, 190, -1));

        jPanel10.setBackground(new java.awt.Color(47, 66, 84));
        jPanel7.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 190, 40));

        jPanel8.setBackground(new java.awt.Color(66, 91, 117));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel8MouseExited(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Logga ut");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 190, -1));

        jPanel13.setBackground(new java.awt.Color(47, 66, 84));
        jPanel8.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 190, 40));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(81, 116, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ola Svärdh");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 60));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 190, 490));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timePanel.setBackground(new java.awt.Color(255, 255, 255));
        timePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timePanelTitle.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        timePanelTitle.setForeground(new java.awt.Color(255, 255, 255));
        timePanelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timePanelTitle.setText("Tidrapportering");
        timePanel.add(timePanelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 730, -1));

        mainPanel.add(timePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 470));

        projectPanel.setBackground(new java.awt.Color(255, 255, 255));
        projectPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        projectPanel.add(jXGraph2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 540, 280));

        projectPanelTitle.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        projectPanelTitle.setForeground(new java.awt.Color(255, 255, 255));
        projectPanelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        projectPanelTitle.setText("Projekt");
        projectPanel.add(projectPanelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 730, -1));

        mainPanel.add(projectPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 470));

        dateTimeLabel.setForeground(new java.awt.Color(153, 153, 153));
        dateTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mainPanel.add(dateTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 330, 20));

        jPanel2.add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 760, 490));

        jPanel4.setBackground(new java.awt.Color(54, 69, 100));
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
        jPanel4.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 280, 70));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 90));

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

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        jPanel3.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        if(!menuArray[3]) {
        jPanel3.setBackground(new java.awt.Color(66,91,117));
        }
    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        timePanel.setVisible(false);
        projectPanel.setVisible(true);
        jPanel6.setBackground(new java.awt.Color(66,91,117));
        jPanel7.setBackground(new java.awt.Color(66,91,117));
        jPanel5.setBackground(new java.awt.Color(66,91,117));
        jPanel8.setBackground(new java.awt.Color(66,91,117));
        Arrays.fill(menuArray, Boolean.FALSE);
        menuArray[3] = true;
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        jPanel6.setBackground(new java.awt.Color(66,91,117));
        jPanel7.setBackground(new java.awt.Color(66,91,117));
        jPanel3.setBackground(new java.awt.Color(66,91,117));
        jPanel8.setBackground(new java.awt.Color(66,91,117));
        Arrays.fill(menuArray, Boolean.FALSE);
        menuArray[2] = true;
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
        jPanel5.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_jPanel5MouseEntered

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
        if(!menuArray[2]) {
        jPanel5.setBackground(new java.awt.Color(66,91,117));
        }
    }//GEN-LAST:event_jPanel5MouseExited

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        projectPanel.setVisible(false);
        timePanel.setVisible(true);
        jPanel7.setBackground(new java.awt.Color(66,91,117));
        jPanel5.setBackground(new java.awt.Color(66,91,117));
        jPanel3.setBackground(new java.awt.Color(66,91,117));
        jPanel8.setBackground(new java.awt.Color(66,91,117));
        Arrays.fill(menuArray, Boolean.FALSE);
        menuArray[0] = true;
        
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        jPanel6.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        if(!menuArray[0]) {
        jPanel6.setBackground(new java.awt.Color(66,91,117));
        }
    }//GEN-LAST:event_jPanel6MouseExited

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        timePanel.setVisible(false);
        projectPanel.setVisible(true);
        jPanel6.setBackground(new java.awt.Color(66,91,117));
        jPanel5.setBackground(new java.awt.Color(66,91,117));
        jPanel3.setBackground(new java.awt.Color(66,91,117));
        jPanel8.setBackground(new java.awt.Color(66,91,117));
        Arrays.fill(menuArray, Boolean.FALSE);
        menuArray[1] = true;
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered
        jPanel7.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_jPanel7MouseEntered

    private void jPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseExited
        if(!menuArray[1]) {
        jPanel7.setBackground(new java.awt.Color(66,91,117));
        }
    }//GEN-LAST:event_jPanel7MouseExited

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        jPanel6.setBackground(new java.awt.Color(66,91,117));
        jPanel7.setBackground(new java.awt.Color(66,91,117));
        jPanel5.setBackground(new java.awt.Color(66,91,117));
        jPanel3.setBackground(new java.awt.Color(66,91,117));
        Arrays.fill(menuArray, Boolean.FALSE);
        menuArray[4] = true;
        signOut();
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseEntered
        jPanel8.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_jPanel8MouseEntered

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
        if(!menuArray[4]) {
        jPanel8.setBackground(new java.awt.Color(66,91,117));
        }
    }//GEN-LAST:event_jPanel8MouseExited

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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private org.jdesktop.swingx.JXGraph jXGraph2;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel minimiseBtn;
    private javax.swing.JPanel projectPanel;
    private javax.swing.JLabel projectPanelTitle;
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
