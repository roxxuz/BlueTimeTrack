
package timetrack.gui;


import java.util.Arrays;
import javax.swing.JFrame;


public class TimeTrackGUI extends javax.swing.JFrame {

    //Inloggad användare (ID från databasen)
    //Tilldelas värde med set-metoden setUserID.
    //default = 0 (ingen användare är inloggad).
    private int userID = 0;
    //Skapar objekt av guiMethods
    GUIMethods guiM = new GUIMethods();
    //Skapar objekt av TimerThread som är en "inner class" i GUIMethods
    GUIMethods.TimerThread timerThread = guiM.new TimerThread();
    //Boolean array som håller reda på vilket menyval som är aktivt
    Boolean[] menuArray = new Boolean[5];
    JFrame loginJFrame;

    public TimeTrackGUI(JFrame loginJFrame) {
        this.loginJFrame = loginJFrame;
        initComponents();
        //Här körs metoden start() som finns i klassen TimerThread som i sin tur finns i klassen GUIMethods
        //Den kommer att starta en ny Thread som kan köras oberoende av det övriga programmet
        //och uppdatera tid och datum via en jLabel längst ner i högra hörnet.
        timerThread.start();
        //Sätter alla paneler (knappar/menyval) till false vid start,
        //förutom Tidrapportering som ska vara default när programmet startar
        projectPanel.setVisible(false);
        timePanel.setVisible(true);
        //Sätter alla booleans i arrayen till false
        Arrays.fill(menuArray, Boolean.FALSE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        motionPanel = new MotionPanel(this);
        mainLeftPanel = new javax.swing.JPanel();
        menuPanel1 = new javax.swing.JPanel();
        menuLabel1 = new javax.swing.JLabel();
        menuLeftPanel1 = new javax.swing.JPanel();
        menuPanel2 = new javax.swing.JPanel();
        menuLabel2 = new javax.swing.JLabel();
        menuLeftPanel2 = new javax.swing.JPanel();
        menuPanel3 = new javax.swing.JPanel();
        menuLabel3 = new javax.swing.JLabel();
        menuLeftPanel3 = new javax.swing.JPanel();
        menuPanel7 = new javax.swing.JPanel();
        menuLabel7 = new javax.swing.JLabel();
        menuLeftPanel7 = new javax.swing.JPanel();
        menuPanel8 = new javax.swing.JPanel();
        menuLabel8 = new javax.swing.JLabel();
        menuLeftPanel8 = new javax.swing.JPanel();
        currentUserLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        timePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        projectPanel = new javax.swing.JPanel();
        jXGraph2 = new org.jdesktop.swingx.JXGraph();
        dateTimeLabel = new javax.swing.JLabel();
        mainTopPanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        closePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        minimizePanel = new javax.swing.JPanel();
        minimizeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        motionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainLeftPanel.setBackground(new java.awt.Color(210, 219, 228));
        mainLeftPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuPanel1.setBackground(new java.awt.Color(92, 126, 162));
        menuPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuPanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuPanel1MouseExited(evt);
            }
        });
        menuPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        menuLabel1.setForeground(new java.awt.Color(255, 255, 255));
        menuLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        menuLabel1.setText("Tidrapportering");
        menuPanel1.add(menuLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 0, 140, 30));

        menuLeftPanel1.setBackground(new java.awt.Color(47, 66, 84));
        menuPanel1.add(menuLeftPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 30));

        mainLeftPanel.add(menuPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 170, 30));

        menuPanel2.setBackground(new java.awt.Color(92, 126, 162));
        menuPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPanel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuPanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuPanel2MouseExited(evt);
            }
        });
        menuPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        menuLabel2.setForeground(new java.awt.Color(255, 255, 255));
        menuLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        menuLabel2.setText("Projekt");
        menuPanel2.add(menuLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 140, 30));

        menuLeftPanel2.setBackground(new java.awt.Color(47, 66, 84));
        menuPanel2.add(menuLeftPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        mainLeftPanel.add(menuPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 170, 30));

        menuPanel3.setBackground(new java.awt.Color(92, 126, 162));
        menuPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPanel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuPanel3MouseExited(evt);
            }
        });
        menuPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        menuLabel3.setForeground(new java.awt.Color(255, 255, 255));
        menuLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        menuLabel3.setText("Anteckningar");
        menuPanel3.add(menuLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 140, 30));

        menuLeftPanel3.setBackground(new java.awt.Color(47, 66, 84));
        menuPanel3.add(menuLeftPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        mainLeftPanel.add(menuPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 170, -1));

        menuPanel7.setBackground(new java.awt.Color(92, 126, 162));
        menuPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPanel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuPanel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuPanel7MouseExited(evt);
            }
        });
        menuPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuLabel7.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        menuLabel7.setForeground(new java.awt.Color(255, 255, 255));
        menuLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        menuLabel7.setText("Inställningar");
        menuPanel7.add(menuLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 140, 30));

        menuLeftPanel7.setBackground(new java.awt.Color(47, 66, 84));
        menuPanel7.add(menuLeftPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        mainLeftPanel.add(menuPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 170, 30));

        menuPanel8.setBackground(new java.awt.Color(92, 126, 162));
        menuPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPanel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuPanel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuPanel8MouseExited(evt);
            }
        });
        menuPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuLabel8.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        menuLabel8.setForeground(new java.awt.Color(255, 255, 255));
        menuLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        menuLabel8.setText("Logga ut");
        menuPanel8.add(menuLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 140, 30));

        menuLeftPanel8.setBackground(new java.awt.Color(47, 66, 84));
        menuPanel8.add(menuLeftPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 30));

        mainLeftPanel.add(menuPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 170, 30));

        currentUserLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        currentUserLabel.setForeground(new java.awt.Color(47, 66, 84));
        currentUserLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        currentUserLabel.setText("Ola Svärdh");
        mainLeftPanel.add(currentUserLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 60));

        motionPanel.add(mainLeftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 170, 530));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timePanel.setBackground(new java.awt.Color(255, 255, 255));
        timePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nec metus id elit suscipit accumsan eget et lacus. Aliquam a tempus purus, at dapibus elit. Donec sem mi, semper eu enim rhoncus, pretium placerat justo. Proin egestas dictum sagittis. Nam nec consectetur metus, viverra convallis justo. Etiam ut sem sem. Sed mattis purus at placerat placerat.  Nullam molestie nibh leo, id mattis leo porta sit amet. Pellentesque pharetra dui nec aliquet mpus eros. Nunc non metus viverra, eleifend lectus non, cursus orci. Praesent pellentesque sit amet diam non pulvinar. tie, risus urna viverra est, malesuada semper ");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        timePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 640, 100));

        mainPanel.add(timePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 510));

        projectPanel.setBackground(new java.awt.Color(255, 255, 255));
        projectPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        projectPanel.add(jXGraph2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 540, 280));

        mainPanel.add(projectPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 510));

        dateTimeLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        dateTimeLabel.setForeground(new java.awt.Color(47, 66, 84));
        dateTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mainPanel.add(dateTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 510, 360, 20));

        motionPanel.add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 780, 530));

        mainTopPanel.setBackground(new java.awt.Color(47, 66, 84));
        mainTopPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoLabel.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        logoLabel.setForeground(new java.awt.Color(255, 255, 255));
        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setText("》TT");
        mainTopPanel.add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 50));

        closePanel.setBackground(new java.awt.Color(47, 66, 84));
        closePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closePanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closePanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closePanelMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("✕");
        closePanel.add(jLabel1);

        mainTopPanel.add(closePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 30, 30));

        minimizePanel.setBackground(new java.awt.Color(47, 66, 84));
        minimizePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizePanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizePanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizePanelMouseExited(evt);
            }
        });

        minimizeLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        minimizeLabel.setForeground(new java.awt.Color(255, 255, 255));
        minimizeLabel.setText("—");
        minimizePanel.add(minimizeLabel);

        mainTopPanel.add(minimizePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 30, 30));

        motionPanel.add(mainTopPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 50));

        getContentPane().add(motionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel7MouseEntered
        menuPanel7.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_menuPanel7MouseEntered

    private void menuPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel7MouseExited
        if(!menuArray[3]) {
        menuPanel7.setBackground(new java.awt.Color(92,126,162));
        }
    }//GEN-LAST:event_menuPanel7MouseExited

    private void menuPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel7MouseClicked
        timePanel.setVisible(false);
        projectPanel.setVisible(true);
        menuPanel1.setBackground(new java.awt.Color(92,126,162));
        menuPanel2.setBackground(new java.awt.Color(92,126,162));
        menuPanel3.setBackground(new java.awt.Color(92,126,162));
        menuPanel8.setBackground(new java.awt.Color(92,126,162));
        Arrays.fill(menuArray, Boolean.FALSE);
        menuArray[3] = true;
    }//GEN-LAST:event_menuPanel7MouseClicked

    private void menuPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel3MouseClicked
        menuPanel1.setBackground(new java.awt.Color(92,126,162));
        menuPanel2.setBackground(new java.awt.Color(92,126,162));
        menuPanel7.setBackground(new java.awt.Color(92,126,162));
        menuPanel8.setBackground(new java.awt.Color(92,126,162));
        Arrays.fill(menuArray, Boolean.FALSE);
        menuArray[2] = true;
    }//GEN-LAST:event_menuPanel3MouseClicked

    private void menuPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel3MouseEntered
        menuPanel3.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_menuPanel3MouseEntered

    private void menuPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel3MouseExited
        if(!menuArray[2]) {
        menuPanel3.setBackground(new java.awt.Color(92,126,162));
        }
    }//GEN-LAST:event_menuPanel3MouseExited

    private void menuPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel1MouseClicked
        projectPanel.setVisible(false);
        timePanel.setVisible(true);
        menuPanel2.setBackground(new java.awt.Color(92,126,162));
        menuPanel3.setBackground(new java.awt.Color(92,126,162));
        menuPanel7.setBackground(new java.awt.Color(92,126,162));
        menuPanel8.setBackground(new java.awt.Color(92,126,162));
        Arrays.fill(menuArray, Boolean.FALSE);
        menuArray[0] = true;
        
    }//GEN-LAST:event_menuPanel1MouseClicked

    private void menuPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel1MouseEntered
        menuPanel1.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_menuPanel1MouseEntered

    private void menuPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel1MouseExited
        if(!menuArray[0]) {
        menuPanel1.setBackground(new java.awt.Color(92,126,162));
        }
    }//GEN-LAST:event_menuPanel1MouseExited

    private void menuPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel2MouseClicked
        timePanel.setVisible(false);
        projectPanel.setVisible(true);
        menuPanel1.setBackground(new java.awt.Color(92,126,162));
        menuPanel3.setBackground(new java.awt.Color(92,126,162));
        menuPanel7.setBackground(new java.awt.Color(92,126,162));
        menuPanel8.setBackground(new java.awt.Color(92,126,162));
        Arrays.fill(menuArray, Boolean.FALSE);
        menuArray[1] = true;
    }//GEN-LAST:event_menuPanel2MouseClicked

    private void menuPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel2MouseEntered
        menuPanel2.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_menuPanel2MouseEntered

    private void menuPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel2MouseExited
        if(!menuArray[1]) {
        menuPanel2.setBackground(new java.awt.Color(92,126,162));
        }
    }//GEN-LAST:event_menuPanel2MouseExited

    private void menuPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel8MouseClicked
        menuPanel1.setBackground(new java.awt.Color(92,126,162));
        menuPanel2.setBackground(new java.awt.Color(92,126,162));
        menuPanel3.setBackground(new java.awt.Color(92,126,162));
        menuPanel7.setBackground(new java.awt.Color(92,126,162));
        Arrays.fill(menuArray, Boolean.FALSE);
        menuArray[4] = true;
        signOut();
    }//GEN-LAST:event_menuPanel8MouseClicked

    private void menuPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel8MouseEntered
        menuPanel8.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_menuPanel8MouseEntered

    private void menuPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel8MouseExited
        if(!menuArray[4]) {
        menuPanel8.setBackground(new java.awt.Color(92,126,162));
        }
    }//GEN-LAST:event_menuPanel8MouseExited

    private void minimizePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizePanelMouseEntered
        minimizePanel.setBackground(new java.awt.Color(56,79,101));
    }//GEN-LAST:event_minimizePanelMouseEntered

    private void minimizePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizePanelMouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_minimizePanelMouseClicked

    private void minimizePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizePanelMouseExited
        minimizePanel.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_minimizePanelMouseExited

    private void closePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closePanelMouseEntered
        closePanel.setBackground(new java.awt.Color(188,55,55));
    }//GEN-LAST:event_closePanelMouseEntered

    private void closePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closePanelMouseClicked
        //Stänger av visningen av datum och tid via metoden setRunnig()
        //Detta är för att den Thread som körs parallellt ska avslutas
        timerThread.setRunning(false);
        System.exit(0);
    }//GEN-LAST:event_closePanelMouseClicked

    private void closePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closePanelMouseExited
        closePanel.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_closePanelMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel closePanel;
    protected javax.swing.JLabel currentUserLabel;
    private static javax.swing.JLabel dateTimeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private org.jdesktop.swingx.JXGraph jXGraph2;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel mainLeftPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel mainTopPanel;
    private javax.swing.JLabel menuLabel1;
    private javax.swing.JLabel menuLabel2;
    private javax.swing.JLabel menuLabel3;
    private javax.swing.JLabel menuLabel7;
    private javax.swing.JLabel menuLabel8;
    private javax.swing.JPanel menuLeftPanel1;
    private javax.swing.JPanel menuLeftPanel2;
    private javax.swing.JPanel menuLeftPanel3;
    private javax.swing.JPanel menuLeftPanel7;
    private javax.swing.JPanel menuLeftPanel8;
    private javax.swing.JPanel menuPanel1;
    private javax.swing.JPanel menuPanel2;
    private javax.swing.JPanel menuPanel3;
    private javax.swing.JPanel menuPanel7;
    private javax.swing.JPanel menuPanel8;
    private javax.swing.JLabel minimizeLabel;
    private javax.swing.JPanel minimizePanel;
    private javax.swing.JPanel motionPanel;
    private javax.swing.JPanel projectPanel;
    private javax.swing.JPanel timePanel;
    // End of variables declaration//GEN-END:variables

    
    private void signOut(){
        //Stänger uppkopplingen till databasen
        guiM.closeDBConnection();
        //avslutar huvudprogrammet
        this.dispose();
        //Stänger av visningen av datum och tid via metoden setRunnig()
        //Detta är för att den Thread som körs parallellt ska avslutas
        timerThread.setRunning(false);
        //loginJFrame är (this) från LoginGUI.
        ((LoginGUI)loginJFrame).clearPasswordField();
        //Sätter markören i textefältet emailInput (användarnamn)
        ((LoginGUI)loginJFrame).emailInput.grabFocus();
        //Markerar all text i textefältet emailInput (användarnamn)
        ((LoginGUI)loginJFrame).emailInput.selectAll();
        loginJFrame.setVisible(true);
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
    
    public void setCurrentUserLabel(String userLabel) {
        currentUserLabel.setText(userLabel);
    }
    
}
