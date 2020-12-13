
package timetrack.gui;


import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Arrays;
import javax.swing.JFrame;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.plaf.basic.BasicDatePickerUI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.JList;
import java.awt.Component;

public class TimeTrackGUI extends javax.swing.JFrame {

    //Inloggad användare (ID från databasen)
    //Tilldelas värde med set-metoden setUserID.
    //default = 0 (ingen användare är inloggad).
    int userID = 0;
    //default false (ej admin)
    boolean isAdmin = false;
    //Skapar objekt av guiMethods
    GUIMethods guiM = new GUIMethods();
    ProjectMethods pM = new ProjectMethods();
    //Skapar objekt av TimerThread som är en "inner class" i GUIMethods
    GUIMethods.TimerThread timerThread = guiM.new TimerThread();
    //Boolean array som håller reda på vilket menyval som är aktivt
    Boolean[] menuArray = new Boolean[8];
    JFrame loginJFrame;
    String selectedProject = "";
    //Behöver ett defaultvärde på comboboxen för att den ska fungera. Det byts senare ut
    String[] defaultComboBox = {""};
    boolean dateChangedAllowed = false;
    private boolean shuttingDown = false;
    boolean saveNewProject;   ///true = spara nytt projekt - false = spara redigerat projekt
    boolean projectSaved;   
    

    

    public TimeTrackGUI(JFrame loginJFrame) {
        this.loginJFrame = loginJFrame;
        initComponents();
        timeTrackSettings();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        motionPanel = new MotionPanel(this);
        mainLeftPanel = new javax.swing.JPanel();
        currentUserLabel = new javax.swing.JLabel();
        menuPanel1 = new javax.swing.JPanel();
        menuLabel1 = new javax.swing.JLabel();
        menuLeftPanel1 = new javax.swing.JPanel();
        menuPanel2 = new javax.swing.JPanel();
        menuLabel2 = new javax.swing.JLabel();
        menuLeftPanel2 = new javax.swing.JPanel();
        menuPanel3 = new javax.swing.JPanel();
        menuLabel3 = new javax.swing.JLabel();
        menuLeftPanel3 = new javax.swing.JPanel();
        menuPanel5 = new javax.swing.JPanel();
        menuLeftPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        menuPanel6 = new javax.swing.JPanel();
        menuLeftPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        menuPanel7 = new javax.swing.JPanel();
        menuLabel7 = new javax.swing.JLabel();
        menuLeftPanel7 = new javax.swing.JPanel();
        menuPanel8 = new javax.swing.JPanel();
        menuLabel8 = new javax.swing.JLabel();
        menuLeftPanel8 = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        timePanel = new javax.swing.JPanel();
        timeDateLabel = new javax.swing.JLabel();
        timeStartLabel = new javax.swing.JLabel();
        timeEndLabel = new javax.swing.JLabel();
        timeProjectLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator(javax.swing.JSeparator.VERTICAL);
        jSeparator4 = new javax.swing.JSeparator(javax.swing.JSeparator.VERTICAL);
        jSeparator5 = new javax.swing.JSeparator(javax.swing.JSeparator.VERTICAL);
        timeDateLabelNew = new javax.swing.JLabel();
        timeDatePanel = new javax.swing.JPanel();
        timeChooseProjectCB = new MyComboBox<>(defaultComboBox);
        timeChooseStartTimeCB = new MyComboBox<>(defaultComboBox);
        timeChooseEndTimeCB = new MyComboBox<>(defaultComboBox);
        jPanel1 = new javax.swing.JPanel();
        timeSendButtonPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        menuLeftPanel4 = new javax.swing.JPanel();
        timeSucceededLabel = new javax.swing.JLabel();
        timeStampHeaderLabel = new javax.swing.JLabel();
        timeEditHeaderLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        dp1 = new org.jdesktop.swingx.JXDatePicker();
        dp2 = new org.jdesktop.swingx.JXDatePicker();
        timeEditDateLabelNew = new javax.swing.JLabel();
        timeEditDatePanel = new javax.swing.JPanel();
        timeDateLabel1 = new javax.swing.JLabel();
        timeEditStampPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        timeEditStampTable = new javax.swing.JTable();
        timeLastEditStampPanel = new javax.swing.JPanel();
        timeDateLabel2 = new javax.swing.JLabel();
        timeStartLabel1 = new javax.swing.JLabel();
        timeEndLabel1 = new javax.swing.JLabel();
        timeProjectLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator(javax.swing.JSeparator.VERTICAL);
        jSeparator6 = new javax.swing.JSeparator(javax.swing.JSeparator.VERTICAL);
        jSeparator7 = new javax.swing.JSeparator(javax.swing.JSeparator.VERTICAL);
        timeDateLabelNew1 = new javax.swing.JLabel();
        timeDatePanel1 = new javax.swing.JPanel();
        timeChooseProjectCB1 = new MyComboBox<>(defaultComboBox);
        timeChooseStartTimeCB1 = new MyComboBox<>(defaultComboBox);
        timeChooseEndTimeCB1 = new MyComboBox<>(defaultComboBox);
        jPanel2 = new javax.swing.JPanel();
        timeSendButtonPanel1 = new javax.swing.JPanel();
        timeEditStampSaveLabel = new javax.swing.JLabel();
        menuLeftPanel9 = new javax.swing.JPanel();
        timeSucceededLabel1 = new javax.swing.JLabel();
        dp3 = new org.jdesktop.swingx.JXDatePicker();
        projectPanel = new javax.swing.JPanel();
        projectHeaderLabel1 = new javax.swing.JLabel();
        projectAvailableScrollPane = new javax.swing.JScrollPane();
        projectAvailableTable = new javax.swing.JTable();
        projectTableHeaderLabel = new javax.swing.JLabel();
        projectInfoPanel = new javax.swing.JPanel();
        projectNameLabel = new javax.swing.JLabel();
        projectNameTextField = new javax.swing.JTextField();
        projectCustomerLabel = new javax.swing.JLabel();
        projectCustomerTextField = new javax.swing.JTextField();
        projectContactLabel = new javax.swing.JLabel();
        projectContactTextField = new javax.swing.JTextField();
        projectPhoneLabel = new javax.swing.JLabel();
        projectPhoneTextField = new javax.swing.JTextField();
        projectEmailLabel = new javax.swing.JLabel();
        projectEmailTextField = new javax.swing.JTextField();
        projectColleagueLabel = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        projectDescriptionTextArea = new javax.swing.JTextArea();
        projectDescriptionLabel = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        projectColleagueTable = new javax.swing.JTable();
        jSeparator8 = new javax.swing.JSeparator();
        overviewPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        adminUserPanel1 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        adminProjectPanel = new javax.swing.JPanel();
        pCurrent = new javax.swing.JLabel();
        ProjectsComboBox = new javax.swing.JComboBox<>();
        StatusComboBox = new javax.swing.JComboBox<>();
        CustomerComboBox = new javax.swing.JComboBox<>();
        ProjectTextField1 = new javax.swing.JTextField();
        ProjectTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ProjectTextArea1 = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        newProject = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        SkillBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        sSkillChosenBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        sSkillTable = new javax.swing.JTable();
        sRemoveSelected = new javax.swing.JLabel();
        NewProject = new javax.swing.JButton();
        EditProject = new javax.swing.JButton();
        settingsPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        dateTimeLabel = new javax.swing.JLabel();
        mainTopPanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        closePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        minimizePanel = new javax.swing.JPanel();
        minimizeLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        motionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainLeftPanel.setBackground(new java.awt.Color(210, 219, 228));
        mainLeftPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        currentUserLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        currentUserLabel.setForeground(new java.awt.Color(47, 66, 84));
        currentUserLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainLeftPanel.add(currentUserLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 60));

        menuPanel1.setBackground(new java.awt.Color(47, 66, 84));
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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                menuPanel1MouseReleased(evt);
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
        menuPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuPanel2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                menuPanel2MouseReleased(evt);
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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuPanel3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                menuPanel3MouseReleased(evt);
            }
        });
        menuPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        menuLabel3.setForeground(new java.awt.Color(255, 255, 255));
        menuLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        menuLabel3.setText("Översikt");
        menuPanel3.add(menuLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 140, 30));

        menuLeftPanel3.setBackground(new java.awt.Color(47, 66, 84));
        menuPanel3.add(menuLeftPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        mainLeftPanel.add(menuPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 170, -1));

        menuPanel5.setBackground(new java.awt.Color(92, 126, 162));
        menuPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPanel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuPanel5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuPanel5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                menuPanel5MouseReleased(evt);
            }
        });
        menuPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuLeftPanel5.setBackground(new java.awt.Color(47, 66, 84));
        menuPanel5.add(menuLeftPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText(" Hantera användare");
        menuPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 0, 140, 30));

        mainLeftPanel.add(menuPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 170, 30));

        menuPanel6.setBackground(new java.awt.Color(92, 126, 162));
        menuPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPanel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuPanel6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuPanel6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                menuPanel6MouseReleased(evt);
            }
        });
        menuPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuLeftPanel6.setBackground(new java.awt.Color(47, 66, 84));
        menuPanel6.add(menuLeftPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText(" Hantera projekt");
        menuPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 0, 140, 30));

        mainLeftPanel.add(menuPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 170, 30));

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuPanel7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                menuPanel7MouseReleased(evt);
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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuPanel8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                menuPanel8MouseReleased(evt);
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

        motionPanel.add(mainLeftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 170, 530));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timePanel.setBackground(new java.awt.Color(255, 255, 255));
        timePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timeDateLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        timeDateLabel.setForeground(new java.awt.Color(47, 66, 84));
        timeDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeDateLabel.setText("   Datum");
        timePanel.add(timeDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 130, 30));

        timeStartLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        timeStartLabel.setForeground(new java.awt.Color(47, 66, 84));
        timeStartLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeStartLabel.setText(" Starttid");
        timePanel.add(timeStartLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 140, 30));

        timeEndLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        timeEndLabel.setForeground(new java.awt.Color(47, 66, 84));
        timeEndLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeEndLabel.setText(" Sluttid");
        timePanel.add(timeEndLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 140, 30));

        timeProjectLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        timeProjectLabel.setForeground(new java.awt.Color(47, 66, 84));
        timeProjectLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeProjectLabel.setText(" Projekt");
        timePanel.add(timeProjectLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 150, 30));

        jSeparator2.setBackground(new java.awt.Color(219, 219, 219));
        jSeparator2.setForeground(new java.awt.Color(219, 219, 219));
        timePanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 10, 10));

        jSeparator4.setBackground(new java.awt.Color(219, 219, 219));
        jSeparator4.setForeground(new java.awt.Color(219, 219, 219));
        timePanel.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 10, 10));

        jSeparator5.setBackground(new java.awt.Color(219, 219, 219));
        jSeparator5.setForeground(new java.awt.Color(219, 219, 219));
        timePanel.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 10, 10));

        timeDateLabelNew.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        timeDateLabelNew.setForeground(new java.awt.Color(165, 165, 165));
        timeDateLabelNew.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeDateLabelNew.setText("Välj datum");
        timeDateLabelNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timeDateLabelNewMouseClicked(evt);
            }
        });
        timeDateLabelNew.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                timeDateLabelNewPropertyChange(evt);
            }
        });
        timePanel.add(timeDateLabelNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 120, 30));

        timeDatePanel.setBackground(new java.awt.Color(237, 237, 237));
        timePanel.add(timeDatePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 120, 30));

        timeChooseProjectCB.setBackground(new java.awt.Color(237, 237, 237));
        timeChooseProjectCB.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        timeChooseProjectCB.setForeground(new java.awt.Color(165, 165, 165));
        timeChooseProjectCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj projekt", "Item 2", "Item 3", "Item 4" }));
        timeChooseProjectCB.setBorder(null);
        timeChooseProjectCB.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                timeChooseProjectCBPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                timeChooseProjectCBPopupMenuWillBecomeVisible(evt);
            }
        });
        timePanel.add(timeChooseProjectCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 140, 30));

        timeChooseStartTimeCB.setBackground(new java.awt.Color(237, 237, 237));
        timeChooseStartTimeCB.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        timeChooseStartTimeCB.setForeground(new java.awt.Color(165, 165, 165));
        timeChooseStartTimeCB.setMaximumRowCount(19);
        timeChooseStartTimeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        timeChooseStartTimeCB.setBorder(null);
        timeChooseStartTimeCB.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                timeChooseStartTimeCBPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                timeChooseStartTimeCBPopupMenuWillBecomeVisible(evt);
            }
        });
        timePanel.add(timeChooseStartTimeCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 130, 30));

        timeChooseEndTimeCB.setBackground(new java.awt.Color(237, 237, 237));
        timeChooseEndTimeCB.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        timeChooseEndTimeCB.setForeground(new java.awt.Color(165, 165, 165));
        timeChooseEndTimeCB.setMaximumRowCount(19);
        timeChooseEndTimeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        timeChooseEndTimeCB.setBorder(null);
        timeChooseEndTimeCB.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                timeChooseEndTimeCBPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                timeChooseEndTimeCBPopupMenuWillBecomeVisible(evt);
            }
        });
        timePanel.add(timeChooseEndTimeCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 130, 30));

        jPanel1.setBackground(new java.awt.Color(237, 237, 237));
        timePanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 560, 30));

        timeSendButtonPanel.setBackground(new java.awt.Color(92, 126, 162));
        timeSendButtonPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timeSendButtonPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                timeSendButtonPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                timeSendButtonPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                timeSendButtonPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                timeSendButtonPanelMouseReleased(evt);
            }
        });
        timeSendButtonPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(" Skicka");
        timeSendButtonPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 30));

        menuLeftPanel4.setBackground(new java.awt.Color(47, 66, 84));
        timeSendButtonPanel.add(menuLeftPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        timePanel.add(timeSendButtonPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 90, 30));

        timeSucceededLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        timeSucceededLabel.setForeground(new java.awt.Color(255, 255, 255));
        timeSucceededLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeSucceededLabel.setText("Din tidredovisning har registrerats");
        timePanel.add(timeSucceededLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 780, 30));

        timeStampHeaderLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        timeStampHeaderLabel.setForeground(new java.awt.Color(165, 165, 165));
        timeStampHeaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeStampHeaderLabel.setText("RAPPORTERA TID");
        timePanel.add(timeStampHeaderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 780, 30));

        timeEditHeaderLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        timeEditHeaderLabel.setForeground(new java.awt.Color(165, 165, 165));
        timeEditHeaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeEditHeaderLabel.setText("REDIGERA TIDRAPPORT");
        timePanel.add(timeEditHeaderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 780, 30));

        jSeparator1.setForeground(new java.awt.Color(165, 165, 165));
        timePanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 700, 10));

        dp1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dp1PropertyChange(evt);
            }
        });
        timePanel.add(dp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 0, 20));

        dp2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dp2PropertyChange(evt);
            }
        });
        timePanel.add(dp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 0, 20));

        timeEditDateLabelNew.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        timeEditDateLabelNew.setForeground(new java.awt.Color(165, 165, 165));
        timeEditDateLabelNew.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeEditDateLabelNew.setText("Välj datum");
        timeEditDateLabelNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timeEditDateLabelNewMouseClicked(evt);
            }
        });
        timeEditDateLabelNew.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                timeEditDateLabelNewPropertyChange(evt);
            }
        });
        timePanel.add(timeEditDateLabelNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 120, 30));

        timeEditDatePanel.setBackground(new java.awt.Color(237, 237, 237));
        timePanel.add(timeEditDatePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 120, 30));

        timeDateLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        timeDateLabel1.setForeground(new java.awt.Color(47, 66, 84));
        timeDateLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeDateLabel1.setText("   Datum");
        timePanel.add(timeDateLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 130, 30));

        timeEditStampPanel.setBackground(new java.awt.Color(255, 255, 255));
        timeEditStampPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timeEditStampTable.setForeground(new java.awt.Color(47, 66, 84));
        timeEditStampTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane6.setViewportView(timeEditStampTable);

        timeEditStampPanel.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 680, 100));

        timeLastEditStampPanel.setBackground(new java.awt.Color(255, 255, 255));
        timeLastEditStampPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timeDateLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        timeDateLabel2.setForeground(new java.awt.Color(47, 66, 84));
        timeDateLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeDateLabel2.setText("   Datum");
        timeLastEditStampPanel.add(timeDateLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 130, 30));

        timeStartLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        timeStartLabel1.setForeground(new java.awt.Color(47, 66, 84));
        timeStartLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeStartLabel1.setText(" Starttid");
        timeLastEditStampPanel.add(timeStartLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 140, 30));

        timeEndLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        timeEndLabel1.setForeground(new java.awt.Color(47, 66, 84));
        timeEndLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeEndLabel1.setText(" Sluttid");
        timeLastEditStampPanel.add(timeEndLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 140, 30));

        timeProjectLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        timeProjectLabel1.setForeground(new java.awt.Color(47, 66, 84));
        timeProjectLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeProjectLabel1.setText(" Projekt");
        timeLastEditStampPanel.add(timeProjectLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 150, 30));

        jSeparator3.setBackground(new java.awt.Color(219, 219, 219));
        jSeparator3.setForeground(new java.awt.Color(219, 219, 219));
        timeLastEditStampPanel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 10, 10));

        jSeparator6.setBackground(new java.awt.Color(219, 219, 219));
        jSeparator6.setForeground(new java.awt.Color(219, 219, 219));
        timeLastEditStampPanel.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 10, 10));

        jSeparator7.setBackground(new java.awt.Color(219, 219, 219));
        jSeparator7.setForeground(new java.awt.Color(219, 219, 219));
        timeLastEditStampPanel.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 10, 10));

        timeDateLabelNew1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        timeDateLabelNew1.setForeground(new java.awt.Color(165, 165, 165));
        timeDateLabelNew1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeDateLabelNew1.setText("Välj datum");
        timeDateLabelNew1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timeDateLabelNew1MouseClicked(evt);
            }
        });
        timeDateLabelNew1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                timeDateLabelNew1PropertyChange(evt);
            }
        });
        timeLastEditStampPanel.add(timeDateLabelNew1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 120, 30));

        timeDatePanel1.setBackground(new java.awt.Color(237, 237, 237));
        timeLastEditStampPanel.add(timeDatePanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 120, 30));

        timeChooseProjectCB1.setBackground(new java.awt.Color(237, 237, 237));
        timeChooseProjectCB1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        timeChooseProjectCB1.setForeground(new java.awt.Color(165, 165, 165));
        timeChooseProjectCB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj projekt", "Item 2", "Item 3", "Item 4" }));
        timeChooseProjectCB1.setBorder(null);
        timeChooseProjectCB1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                timeChooseProjectCB1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                timeChooseProjectCB1PopupMenuWillBecomeVisible(evt);
            }
        });
        timeLastEditStampPanel.add(timeChooseProjectCB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 140, 30));

        timeChooseStartTimeCB1.setBackground(new java.awt.Color(237, 237, 237));
        timeChooseStartTimeCB1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        timeChooseStartTimeCB1.setForeground(new java.awt.Color(165, 165, 165));
        timeChooseStartTimeCB1.setMaximumRowCount(19);
        timeChooseStartTimeCB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        timeChooseStartTimeCB1.setBorder(null);
        timeChooseStartTimeCB1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                timeChooseStartTimeCB1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                timeChooseStartTimeCB1PopupMenuWillBecomeVisible(evt);
            }
        });
        timeLastEditStampPanel.add(timeChooseStartTimeCB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 130, 30));

        timeChooseEndTimeCB1.setBackground(new java.awt.Color(237, 237, 237));
        timeChooseEndTimeCB1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        timeChooseEndTimeCB1.setForeground(new java.awt.Color(165, 165, 165));
        timeChooseEndTimeCB1.setMaximumRowCount(19);
        timeChooseEndTimeCB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        timeChooseEndTimeCB1.setBorder(null);
        timeChooseEndTimeCB1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                timeChooseEndTimeCB1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                timeChooseEndTimeCB1PopupMenuWillBecomeVisible(evt);
            }
        });
        timeLastEditStampPanel.add(timeChooseEndTimeCB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 130, 30));

        jPanel2.setBackground(new java.awt.Color(237, 237, 237));
        timeLastEditStampPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 560, 30));

        timeSendButtonPanel1.setBackground(new java.awt.Color(92, 126, 162));
        timeSendButtonPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timeSendButtonPanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                timeSendButtonPanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                timeSendButtonPanel1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                timeSendButtonPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                timeSendButtonPanel1MouseReleased(evt);
            }
        });
        timeSendButtonPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timeEditStampSaveLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        timeEditStampSaveLabel.setForeground(new java.awt.Color(255, 255, 255));
        timeEditStampSaveLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeEditStampSaveLabel.setText("  Uppdatera");
        timeSendButtonPanel1.add(timeEditStampSaveLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 30));

        menuLeftPanel9.setBackground(new java.awt.Color(47, 66, 84));
        timeSendButtonPanel1.add(menuLeftPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        timeLastEditStampPanel.add(timeSendButtonPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 90, 30));

        timeSucceededLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        timeSucceededLabel1.setForeground(new java.awt.Color(255, 255, 255));
        timeSucceededLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeSucceededLabel1.setText("Din tidredovisning har uppdaterats");
        timeLastEditStampPanel.add(timeSucceededLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 780, 30));

        dp3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dp3PropertyChange(evt);
            }
        });
        timeLastEditStampPanel.add(dp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, -130, 0, 20));

        timeEditStampPanel.add(timeLastEditStampPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 780, -1));

        timePanel.add(timeEditStampPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 780, 220));

        mainPanel.add(timePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 510));

        projectPanel.setBackground(new java.awt.Color(255, 255, 255));
        projectPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        projectHeaderLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        projectHeaderLabel1.setForeground(new java.awt.Color(165, 165, 165));
        projectHeaderLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        projectHeaderLabel1.setText("TILLDELADE PROJEKT");
        projectPanel.add(projectHeaderLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 780, 30));

        projectAvailableTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1"
            }
        ));
        projectAvailableTable.setRowHeight(30);
        projectAvailableTable.setTableHeader(null);
        projectAvailableScrollPane.setViewportView(projectAvailableTable);

        projectPanel.add(projectAvailableScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 280, 120));

        projectTableHeaderLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        projectTableHeaderLabel.setForeground(new java.awt.Color(47, 66, 84));
        projectTableHeaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        projectTableHeaderLabel.setText("Välj projekt");
        projectPanel.add(projectTableHeaderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 380, 30));

        projectInfoPanel.setBackground(new java.awt.Color(255, 255, 255));
        projectInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        projectNameLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        projectNameLabel.setForeground(new java.awt.Color(47, 66, 84));
        projectNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        projectNameLabel.setText("Projektnamn");
        projectInfoPanel.add(projectNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 90, -1));

        projectNameTextField.setEditable(false);
        projectNameTextField.setText("Javautbildning");
        projectInfoPanel.add(projectNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 200, 30));

        projectCustomerLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        projectCustomerLabel.setForeground(new java.awt.Color(47, 66, 84));
        projectCustomerLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        projectCustomerLabel.setText("Kund");
        projectInfoPanel.add(projectCustomerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 90, 20));

        projectCustomerTextField.setEditable(false);
        projectCustomerTextField.setText("Malmö Stad");
        projectInfoPanel.add(projectCustomerTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 200, 30));

        projectContactLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        projectContactLabel.setForeground(new java.awt.Color(47, 66, 84));
        projectContactLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        projectContactLabel.setText("Kontakt");
        projectInfoPanel.add(projectContactLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 90, 20));

        projectContactTextField.setEditable(false);
        projectContactTextField.setText("Jan Malmström");
        projectInfoPanel.add(projectContactTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 200, 30));

        projectPhoneLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        projectPhoneLabel.setForeground(new java.awt.Color(47, 66, 84));
        projectPhoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        projectPhoneLabel.setText("Telefon");
        projectInfoPanel.add(projectPhoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 90, 20));

        projectPhoneTextField.setEditable(false);
        projectPhoneTextField.setText("0760445576");
        projectInfoPanel.add(projectPhoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 200, 30));

        projectEmailLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        projectEmailLabel.setForeground(new java.awt.Color(47, 66, 84));
        projectEmailLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        projectEmailLabel.setText("Email");
        projectInfoPanel.add(projectEmailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 90, 20));

        projectEmailTextField.setEditable(false);
        projectEmailTextField.setText("jan.malmstrom@malmostad.se");
        projectInfoPanel.add(projectEmailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 200, 30));

        projectColleagueLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        projectColleagueLabel.setForeground(new java.awt.Color(47, 66, 84));
        projectColleagueLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        projectColleagueLabel.setText("Kollegor i projektet");
        projectInfoPanel.add(projectColleagueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 130, 20));

        projectDescriptionTextArea.setEditable(false);
        projectDescriptionTextArea.setColumns(20);
        projectDescriptionTextArea.setLineWrap(true);
        projectDescriptionTextArea.setRows(5);
        projectDescriptionTextArea.setText("Utbilda två klasser i Java grundkurs, HT 2020 och VT 2021. Kursplan...\n");
        projectDescriptionTextArea.setWrapStyleWord(true);
        jScrollPane7.setViewportView(projectDescriptionTextArea);

        projectInfoPanel.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 260, 90));

        projectDescriptionLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        projectDescriptionLabel.setForeground(new java.awt.Color(47, 66, 84));
        projectDescriptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        projectDescriptionLabel.setText("Projektbeskrivning");
        projectInfoPanel.add(projectDescriptionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 130, 20));

        projectColleagueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane8.setViewportView(projectColleagueTable);

        projectInfoPanel.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 260, 90));

        projectPanel.add(projectInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 780, 230));

        jSeparator8.setForeground(new java.awt.Color(165, 165, 165));
        projectPanel.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 700, 10));

        mainPanel.add(projectPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 510));

        overviewPanel.setBackground(new java.awt.Color(255, 255, 255));
        overviewPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("Översikt");
        overviewPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, -1, -1));

        mainPanel.add(overviewPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 510));

        adminUserPanel1.setBackground(new java.awt.Color(255, 255, 255));
        adminUserPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        adminUserPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 290, 30));
        adminUserPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 290, 30));
        adminUserPanel1.add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 290, 30));
        adminUserPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 290, 30));

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        adminUserPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 30, 30));

        jLabel6.setText("Namn");
        adminUserPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 80, 20));

        jLabel11.setText("Efternamn");
        adminUserPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));

        jLabel12.setText("Lösenord");
        adminUserPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, -1));

        jLabel13.setText("Email");
        adminUserPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel14.setText("Färdigheter");
        adminUserPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jComboBox1.setToolTipText(null);
        jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        adminUserPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 190, 30));

        jLabel15.setText("Admin");
        adminUserPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 80, 30));

        jLabel16.setForeground(new java.awt.Color(0, 51, 153));
        jLabel16.setText("Skapa användare");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        adminUserPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 440, 110, 30));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1"
            }
        ));
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setViewportView(jTable2);

        adminUserPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 290, 120));
        adminUserPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 290, 90));

        jLabel19.setText("Ta bort markerad");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        adminUserPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 110, 30));

        mainPanel.add(adminUserPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 510));

        adminProjectPanel.setBackground(new java.awt.Color(255, 255, 255));
        adminProjectPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        adminProjectPanel.add(pCurrent, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 20));

        ProjectsComboBox.setVisible(false);
        ProjectsComboBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                ProjectsComboBoxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        ProjectsComboBox.setRenderer(new PromptComboBoxRenderer(""));
        ProjectsComboBox.setSelectedIndex(-1);
        adminProjectPanel.add(ProjectsComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 150, -1));

        adminProjectPanel.add(StatusComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 180, -1));

        adminProjectPanel.add(CustomerComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 180, -1));

        ProjectTextField1.setVisible(false);
        ProjectTextField1.setEditable(false);
        adminProjectPanel.add(ProjectTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 40, -1));
        adminProjectPanel.add(ProjectTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 170, 30));

        ProjectTextArea1.setColumns(20);
        ProjectTextArea1.setLineWrap(true);
        ProjectTextArea1.setRows(5);
        ProjectTextArea1.setWrapStyleWord(true);
        jScrollPane2.setViewportView(ProjectTextArea1);

        adminProjectPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, -1));

        jLabel17.setVisible(false);
        jLabel17.setText("ID");
        adminProjectPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel20.setText("Namn");
        adminProjectPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel21.setText("Status");
        adminProjectPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabel22.setText("Kund");
        adminProjectPanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel23.setText("Beskrivning");
        adminProjectPanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        newProject.setText("Spara");
        newProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProjectActionPerformed(evt);
            }
        });
        adminProjectPanel.add(newProject, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, -1, -1));

        jLabel24.setVisible(false);
        jLabel24.setText("Projekt");
        adminProjectPanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        SkillBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                SkillBoxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        SkillBox.setRenderer(new PromptComboBoxRenderer(""));
        SkillBox.setSelectedIndex(-1);
        adminProjectPanel.add(SkillBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 160, -1));

        jLabel4.setText("Färdigheter");
        adminProjectPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, -1));

        jLabel25.setText("Användare");
        adminProjectPanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, -1, -1));

        jLabel26.setText("<html>Användare<br>på projekt</html>");
        adminProjectPanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, -1));

        sSkillChosenBox.setEnabled(false);
        sSkillChosenBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                sSkillChosenBoxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        sSkillChosenBox.setRenderer(new PromptComboBoxRenderer(""));
        sSkillChosenBox.setSelectedIndex(-1);
        adminProjectPanel.add(sSkillChosenBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 160, -1));

        sSkillTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "User ID", "Name"
            }
        ));
        sSkillTable.getColumnModel().getColumn(0).setMaxWidth(60);
        jScrollPane1.setViewportView(sSkillTable);

        adminProjectPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 200, 200));

        sRemoveSelected.setText("Ta bort markerad");
        sRemoveSelected.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sRemoveSelectedMouseClicked(evt);
            }
        });
        adminProjectPanel.add(sRemoveSelected, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, -1, -1));

        NewProject.setText("Skapa Projekt");
        NewProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewProjectActionPerformed(evt);
            }
        });
        adminProjectPanel.add(NewProject, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        EditProject.setText("Redigera Projekt");
        EditProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditProjectActionPerformed(evt);
            }
        });
        adminProjectPanel.add(EditProject, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        mainPanel.add(adminProjectPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 510));

        settingsPanel.setBackground(new java.awt.Color(255, 255, 255));
        settingsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("Inställningar");
        settingsPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, -1, -1));

        mainPanel.add(settingsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 510));

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
        logoLabel.setText("T⌚T");
        mainTopPanel.add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, 70, 60));

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
        closePanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("✕");
        closePanel.add(jLabel1, new java.awt.GridBagConstraints());

        mainTopPanel.add(closePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 50, 50));

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
        minimizePanel.setLayout(new java.awt.GridBagLayout());

        minimizeLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        minimizeLabel.setForeground(new java.awt.Color(255, 255, 255));
        minimizeLabel.setText("—");
        minimizePanel.add(minimizeLabel, new java.awt.GridBagConstraints());

        mainTopPanel.add(minimizePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 50, 50));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 8)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Blue Time Track");
        mainTopPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 90, 20));

        motionPanel.add(mainTopPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 50));

        getContentPane().add(motionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel7MouseEntered
        menuPanel7.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_menuPanel7MouseEntered

    private void menuPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel7MouseExited
        if(!menuArray[6]) {
        menuPanel7.setBackground(new java.awt.Color(92,126,162));
        }
    }//GEN-LAST:event_menuPanel7MouseExited

    private void menuPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel7MouseClicked
        selectedPanel(7);
        menuPanel1.setBackground(new java.awt.Color(92,126,162));
        menuPanel2.setBackground(new java.awt.Color(92,126,162));
        menuPanel3.setBackground(new java.awt.Color(92,126,162));
        menuPanel5.setBackground(new java.awt.Color(92,126,162));
        menuPanel6.setBackground(new java.awt.Color(92,126,162));
        menuPanel8.setBackground(new java.awt.Color(92,126,162));
        Arrays.fill(menuArray, Boolean.FALSE);
        menuArray[6] = true;
    }//GEN-LAST:event_menuPanel7MouseClicked

    private void menuPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel3MouseClicked
        selectedPanel(3);
        menuPanel1.setBackground(new java.awt.Color(92,126,162));
        menuPanel2.setBackground(new java.awt.Color(92,126,162));
        menuPanel5.setBackground(new java.awt.Color(92,126,162));
        menuPanel6.setBackground(new java.awt.Color(92,126,162));
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
        //Array som sköter färgerna för menyn får töms och tilldelar sedan vald meny till true
        Arrays.fill(menuArray, Boolean.FALSE);
        menuArray[0] = true;
        //Kallar på metoden och skickar med vald panel
        selectedPanel(1);
        menuTimeDefaultValues();
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
        selectedPanel(2);
        Arrays.fill(menuArray, Boolean.FALSE);
        menuArray[1] = true;
        availableProjectsToTable(projectAvailableTable);
        projectInfoPanel.setVisible(false);
        
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
        menuPanel5.setBackground(new java.awt.Color(92,126,162));
        menuPanel6.setBackground(new java.awt.Color(92,126,162));
        menuPanel7.setBackground(new java.awt.Color(92,126,162));
        Arrays.fill(menuArray, Boolean.FALSE);
        menuArray[7] = true;
        shuttingDown = true;
        signOut();
    }//GEN-LAST:event_menuPanel8MouseClicked

    private void menuPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel8MouseEntered
        menuPanel8.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_menuPanel8MouseEntered

    private void menuPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel8MouseExited
        if(!menuArray[7]) {
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

    private void menuPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel5MouseClicked
        selectedPanel(5);
        menuPanel1.setBackground(new java.awt.Color(92,126,162));
        menuPanel2.setBackground(new java.awt.Color(92,126,162));
        menuPanel3.setBackground(new java.awt.Color(92,126,162));
        menuPanel6.setBackground(new java.awt.Color(92,126,162));
        menuPanel7.setBackground(new java.awt.Color(92,126,162));
        menuPanel8.setBackground(new java.awt.Color(92,126,162));
        Arrays.fill(menuArray, Boolean.FALSE);
        menuArray[4] = true;
        guiM.getAvailableSkills();
    }//GEN-LAST:event_menuPanel5MouseClicked

    private void menuPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel5MouseEntered
        menuPanel5.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_menuPanel5MouseEntered

    private void menuPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel5MouseExited
        if(!menuArray[4]) {
        menuPanel5.setBackground(new java.awt.Color(92,126,162));
        }
    }//GEN-LAST:event_menuPanel5MouseExited

    private void menuPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel6MouseClicked
        saveNewProject = true;     
        selectedPanel(6);
        menuPanel1.setBackground(new java.awt.Color(92,126,162));
        menuPanel2.setBackground(new java.awt.Color(92,126,162));
        menuPanel3.setBackground(new java.awt.Color(92,126,162));
        menuPanel5.setBackground(new java.awt.Color(92,126,162));
        menuPanel7.setBackground(new java.awt.Color(92,126,162));
        menuPanel8.setBackground(new java.awt.Color(92,126,162));
        Arrays.fill(menuArray, Boolean.FALSE);
        menuArray[5] = true;
        ProjectsComboBox.setVisible(false);
        ProjectTextField1.setVisible(false);
        jLabel24.setVisible(false);
        jLabel17.setVisible(false);
        pM.projectCombobox();
        pM.StatusCombobox();
        pM.CustomerCombobox();
        pM.getAvailableSkillsProject();
        pCurrent.setText("Skapa");
        pM.getProjectInfo1();
        
    }//GEN-LAST:event_menuPanel6MouseClicked

    private void menuPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel6MouseEntered
        menuPanel6.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_menuPanel6MouseEntered

    private void menuPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel6MouseExited
        if(!menuArray[5]) {
        menuPanel6.setBackground(new java.awt.Color(92,126,162));
        }
    }//GEN-LAST:event_menuPanel6MouseExited

    private void timeSendButtonPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeSendButtonPanelMouseEntered
        timeSendButtonPanel.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_timeSendButtonPanelMouseEntered

    private void timeSendButtonPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeSendButtonPanelMouseExited
        timeSendButtonPanel.setBackground(new java.awt.Color(92,126,162));
    }//GEN-LAST:event_timeSendButtonPanelMouseExited

    private void timeSendButtonPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeSendButtonPanelMousePressed
        timeSendButtonPanel.setBackground(new java.awt.Color(56,79,101));
    }//GEN-LAST:event_timeSendButtonPanelMousePressed

    private void timeSendButtonPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeSendButtonPanelMouseReleased
        timeSendButtonPanel.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_timeSendButtonPanelMouseReleased

    private void menuPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel1MousePressed
        menuPanel1.setBackground(new java.awt.Color(56,79,101));
    }//GEN-LAST:event_menuPanel1MousePressed

    private void menuPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel2MousePressed
        menuPanel2.setBackground(new java.awt.Color(56,79,101));
    }//GEN-LAST:event_menuPanel2MousePressed

    private void menuPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel3MousePressed
        menuPanel3.setBackground(new java.awt.Color(56,79,101));
    }//GEN-LAST:event_menuPanel3MousePressed

    private void menuPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel5MousePressed
        menuPanel5.setBackground(new java.awt.Color(56,79,101));
    }//GEN-LAST:event_menuPanel5MousePressed

    private void menuPanel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel6MousePressed
        menuPanel6.setBackground(new java.awt.Color(56,79,101));
    }//GEN-LAST:event_menuPanel6MousePressed

    private void menuPanel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel7MousePressed
        menuPanel7.setBackground(new java.awt.Color(56,79,101));
    }//GEN-LAST:event_menuPanel7MousePressed

    private void menuPanel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel8MousePressed
        menuPanel8.setBackground(new java.awt.Color(56,79,101));
    }//GEN-LAST:event_menuPanel8MousePressed

    private void menuPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel1MouseReleased
        menuPanel1.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_menuPanel1MouseReleased

    private void menuPanel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel2MouseReleased
        menuPanel2.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_menuPanel2MouseReleased

    private void menuPanel3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel3MouseReleased
        menuPanel3.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_menuPanel3MouseReleased

    private void menuPanel5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel5MouseReleased
        menuPanel5.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_menuPanel5MouseReleased

    private void menuPanel6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel6MouseReleased
        menuPanel6.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_menuPanel6MouseReleased

    private void menuPanel7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel7MouseReleased
        menuPanel7.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_menuPanel7MouseReleased

    private void menuPanel8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel8MouseReleased
        menuPanel8.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_menuPanel8MouseReleased

    private void timeSendButtonPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeSendButtonPanelMouseClicked
        sendTimeReport();
    }//GEN-LAST:event_timeSendButtonPanelMouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
       
       if(validTextFieldsInput()) {
           if(guiM.emailIsAvailable(jTextField3.getText())) {
                guiM.createUser(jTextField1.getText(), jTextField2.getText(),jTextField3.getText(), jPasswordField2.getText(), "", jRadioButton1.isSelected());
                guiM.insertUsersHasSkills(jTextField3.getText());
                guiM.clearAllTextFieldsInCreateUser();
           } else {
               jLabel18.setText("Email-Adressen är redan upptagen, välj en ny!");
           }
                
       }
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        
        int row = jTable2.getSelectedRow();
         model.removeRow(row);
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jComboBox1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeInvisible
       guiM.insertSkillValue();
        
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeInvisible

    private void newProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProjectActionPerformed
        pM.saveMethod();
    }//GEN-LAST:event_newProjectActionPerformed

    private void ProjectsComboBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_ProjectsComboBoxPopupMenuWillBecomeInvisible
        pM.setProjectInfo();
        pM.setProjectSkillUsers();
    }//GEN-LAST:event_ProjectsComboBoxPopupMenuWillBecomeInvisible

    private void SkillBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_SkillBoxPopupMenuWillBecomeInvisible
        pM.setSkillUsers();
    }//GEN-LAST:event_SkillBoxPopupMenuWillBecomeInvisible

    private void timeChooseProjectCBPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_timeChooseProjectCBPopupMenuWillBecomeVisible
        timeChooseProjectCB.setForeground(new Color(51,51,51));
        guiM.getAvailableProjects(userID, timeChooseProjectCB, true);
    }//GEN-LAST:event_timeChooseProjectCBPopupMenuWillBecomeVisible

    private void timeChooseProjectCBPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_timeChooseProjectCBPopupMenuWillBecomeInvisible
        //Sätter tillbaka ljusgrå färg på texten om inget prjekt väljs
        setGreyForeground(timeChooseProjectCB, false);
        //Byter fokus till en panel för att inte comboboxen ska vara fokuserad efter val
        timeSendButtonPanel.requestFocus(true);
    }//GEN-LAST:event_timeChooseProjectCBPopupMenuWillBecomeInvisible

    private void timeChooseStartTimeCBPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_timeChooseStartTimeCBPopupMenuWillBecomeVisible
        timeChooseStartTimeCB.setForeground(new Color(51,51,51));
    }//GEN-LAST:event_timeChooseStartTimeCBPopupMenuWillBecomeVisible

    private void timeChooseStartTimeCBPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_timeChooseStartTimeCBPopupMenuWillBecomeInvisible
        //Sätter tillbaka ljusgrå färg på texten om inget prjekt väljs
        setGreyForeground(timeChooseStartTimeCB, false);
        //Byter fokus till en panel för att inte comboboxen ska vara fokuserad efter val
        timeSendButtonPanel.requestFocus(true);
    }//GEN-LAST:event_timeChooseStartTimeCBPopupMenuWillBecomeInvisible

    private void timeChooseEndTimeCBPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_timeChooseEndTimeCBPopupMenuWillBecomeInvisible
        //Sätter tillbaka ljusgrå färg på texten om inget prjekt väljs
        setGreyForeground(timeChooseEndTimeCB, false);
        //Byter fokus till en panel för att inte comboboxen ska vara fokuserad efter val
        timeSendButtonPanel.requestFocus(true);
    }//GEN-LAST:event_timeChooseEndTimeCBPopupMenuWillBecomeInvisible

    private void timeChooseEndTimeCBPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_timeChooseEndTimeCBPopupMenuWillBecomeVisible
        timeChooseEndTimeCB.setForeground(new Color(51,51,51));
    }//GEN-LAST:event_timeChooseEndTimeCBPopupMenuWillBecomeVisible

    private void dp1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dp1PropertyChange
        if(!shuttingDown) {
            if(dateChangedAllowed) {
                Date oDate = dp1.getDate();        
                DateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String newDate = oDateFormat.format(oDate);
                timeDateLabelNew.setForeground(new Color(51,51,51));
                timeDateLabelNew.setText(newDate);
            }
            dp1.setVisible(false);
        }
    }//GEN-LAST:event_dp1PropertyChange

    private void timeDateLabelNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeDateLabelNewMouseClicked
        dp1.setVisible(true);
        dp1.requestFocus();
    }//GEN-LAST:event_timeDateLabelNewMouseClicked

    private void timeDateLabelNewPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_timeDateLabelNewPropertyChange
        timeSendButtonPanel.requestFocus(false);
    }//GEN-LAST:event_timeDateLabelNewPropertyChange

    private void dp2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dp2PropertyChange
        if(!shuttingDown) {
            if(dateChangedAllowed) {
                Date oDate = dp2.getDate();        
                DateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String newDate = oDateFormat.format(oDate);
                timeEditDateLabelNew.setForeground(new Color(51,51,51));
                timeEditDateLabelNew.setText(newDate);
            }
            dp2.setVisible(false);
        }
    }//GEN-LAST:event_dp2PropertyChange

    private void timeEditDateLabelNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeEditDateLabelNewMouseClicked
        //Gör DatePickern synlig
        dp2.setVisible(true);
        //DatePickern begär fokus för det är då den triggas och öppnas upp
        dp2.requestFocus();
    }//GEN-LAST:event_timeEditDateLabelNewMouseClicked

    private void timeEditDateLabelNewPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_timeEditDateLabelNewPropertyChange
        if(!shuttingDown) {
            //Ska inte utföras om texten endast ändras till "välj datum"
            if(!timeEditDateLabelNew.equals("Välj datum")) {
                timeSendButtonPanel.requestFocus(false);
                //Inväntar dateChangedAllowed = true för att inte programmet ska crasha
                //Den sätts till true vid uppstart.
                if(dateChangedAllowed) {
                    //Sparar valt datum från jLabel till String
                    String date = timeEditDateLabelNew.getText();
                    //Kör metoden för att hämta tidsdata baserat på användarnamn och valt datum
                    ResultSet rs = guiM.getTimeStampFromDB(userID, date);
                    timeEditStampTable.setModel(DbUtils.resultSetToTableModel(rs));
                    //Gör panelen med tabellen synlig
                    timeLastEditStampPanel.setVisible(false);
                    timeEditStampPanel.setVisible(true);
                }
                //Centrerar allt i tabellen
                setTableCellsAlignment(timeEditStampTable, SwingConstants.CENTER);
            }
        }
    }//GEN-LAST:event_timeEditDateLabelNewPropertyChange

    private void timeDateLabelNew1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeDateLabelNew1MouseClicked
        dp3.setVisible(true);
        dp3.requestFocus();
    }//GEN-LAST:event_timeDateLabelNew1MouseClicked

    private void timeDateLabelNew1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_timeDateLabelNew1PropertyChange
        timeSendButtonPanel.requestFocus(false);
    }//GEN-LAST:event_timeDateLabelNew1PropertyChange

    private void timeChooseProjectCB1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_timeChooseProjectCB1PopupMenuWillBecomeInvisible
        //Sätter tillbaka ljusgrå färg på texten om inget projekt väljs
        setGreyForeground(timeChooseProjectCB1, false);
        //Byter fokus till en panel för att inte comboboxen ska vara fokuserad efter val
        timeSendButtonPanel.requestFocus(true);
    }//GEN-LAST:event_timeChooseProjectCB1PopupMenuWillBecomeInvisible

    private void timeChooseProjectCB1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_timeChooseProjectCB1PopupMenuWillBecomeVisible
        timeChooseProjectCB1.setForeground(new Color(51,51,51));
        guiM.getAvailableProjects(userID, timeChooseProjectCB1, true);
    }//GEN-LAST:event_timeChooseProjectCB1PopupMenuWillBecomeVisible

    private void timeChooseStartTimeCB1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_timeChooseStartTimeCB1PopupMenuWillBecomeInvisible
        //Sätter tillbaka ljusgrå färg på texten om inget prjekt väljs
        setGreyForeground(timeChooseStartTimeCB1, false);
        //Byter fokus till en panel för att inte comboboxen ska vara fokuserad efter val
        timeSendButtonPanel.requestFocus(true);
    }//GEN-LAST:event_timeChooseStartTimeCB1PopupMenuWillBecomeInvisible

    private void timeChooseStartTimeCB1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_timeChooseStartTimeCB1PopupMenuWillBecomeVisible
        
        timeChooseStartTimeCB1.setForeground(new Color(51,51,51));
    }//GEN-LAST:event_timeChooseStartTimeCB1PopupMenuWillBecomeVisible

    private void timeChooseEndTimeCB1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_timeChooseEndTimeCB1PopupMenuWillBecomeInvisible
        //Sätter tillbaka ljusgrå färg på texten om inget prjekt väljs
        setGreyForeground(timeChooseEndTimeCB1, false);
        //Byter fokus till en panel för att inte comboboxen ska vara fokuserad efter val
        timeSendButtonPanel.requestFocus(true);
    }//GEN-LAST:event_timeChooseEndTimeCB1PopupMenuWillBecomeInvisible

    private void timeChooseEndTimeCB1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_timeChooseEndTimeCB1PopupMenuWillBecomeVisible
        timeChooseEndTimeCB1.setForeground(new Color(51,51,51));
    }//GEN-LAST:event_timeChooseEndTimeCB1PopupMenuWillBecomeVisible

    private void timeSendButtonPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeSendButtonPanel1MouseClicked
        sendUpdateTimeStampToDB();
    }//GEN-LAST:event_timeSendButtonPanel1MouseClicked

    private void timeSendButtonPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeSendButtonPanel1MouseEntered
        timeSendButtonPanel1.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_timeSendButtonPanel1MouseEntered

    private void timeSendButtonPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeSendButtonPanel1MouseExited
        timeSendButtonPanel1.setBackground(new java.awt.Color(92,126,162));
    }//GEN-LAST:event_timeSendButtonPanel1MouseExited

    private void timeSendButtonPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeSendButtonPanel1MousePressed
        timeSendButtonPanel1.setBackground(new java.awt.Color(56,79,101));
    }//GEN-LAST:event_timeSendButtonPanel1MousePressed

    private void timeSendButtonPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeSendButtonPanel1MouseReleased
        timeSendButtonPanel1.setBackground(new java.awt.Color(47,66,84));
    }//GEN-LAST:event_timeSendButtonPanel1MouseReleased

    private void dp3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dp3PropertyChange
        if(!shuttingDown) {
            if(dateChangedAllowed) {
                Date oDate = dp3.getDate();        
                DateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String newDate = oDateFormat.format(oDate);
                timeDateLabelNew1.setForeground(new Color(51,51,51));
                timeDateLabelNew1.setText(newDate);
            }
            dp3.setVisible(false);
        }
    }//GEN-LAST:event_dp3PropertyChange

    private void sSkillChosenBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_sSkillChosenBoxPopupMenuWillBecomeInvisible
        pM.setProjectSkillUsers2();
    }//GEN-LAST:event_sSkillChosenBoxPopupMenuWillBecomeInvisible

    private void NewProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewProjectActionPerformed

        pM.getProjectInfo2();
        pM.compareFields();

        pM.getProjectInfo1();
        saveNewProject = true;
        pM.clearAllProjectFields();
        ProjectsComboBox.setVisible(false);
        ProjectTextField1.setVisible(false);
        jLabel24.setVisible(false);
        jLabel17.setVisible(false);
        pM.projectCombobox();
        pM.StatusCombobox();
        pM.CustomerCombobox();
        pM.getAvailableSkillsProject();
        pCurrent.setText("Skapa");
        pM.resetIsSaved();
        
        pM.printAL();

    }//GEN-LAST:event_NewProjectActionPerformed

    private void EditProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditProjectActionPerformed

        pM.getProjectInfo2();
        pM.compareFields();
        pM.resetIsSaved();
        saveNewProject = false;
        pM.clearAllProjectFields();
        ProjectsComboBox.setVisible(true);
        ProjectTextField1.setVisible(true);
        jLabel24.setVisible(true);
        jLabel17.setVisible(true);
        pM.projectCombobox();
        pM.StatusCombobox();
        pM.CustomerCombobox();
        pM.getAvailableSkillsProject();
        pCurrent.setText("Redigera");
    }//GEN-LAST:event_EditProjectActionPerformed

    private void sRemoveSelectedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sRemoveSelectedMouseClicked
        DefaultTableModel model = (DefaultTableModel)sSkillTable.getModel();
        int row = sSkillTable.getSelectedRow();
        model.removeRow(row);
    }//GEN-LAST:event_sRemoveSelectedMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JComboBox<String> CustomerComboBox;
    protected javax.swing.JButton EditProject;
    protected javax.swing.JButton NewProject;
    protected javax.swing.JTextArea ProjectTextArea1;
    protected javax.swing.JTextField ProjectTextField1;
    protected javax.swing.JTextField ProjectTextField2;
    protected javax.swing.JComboBox<String> ProjectsComboBox;
    protected javax.swing.JComboBox<String> SkillBox;
    protected javax.swing.JComboBox<String> StatusComboBox;
    private javax.swing.JPanel adminProjectPanel;
    private javax.swing.JPanel adminUserPanel1;
    private javax.swing.JPanel closePanel;
    protected javax.swing.JLabel currentUserLabel;
    private static javax.swing.JLabel dateTimeLabel;
    private org.jdesktop.swingx.JXDatePicker dp1;
    private org.jdesktop.swingx.JXDatePicker dp2;
    private org.jdesktop.swingx.JXDatePicker dp3;
    protected javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    protected javax.swing.JLabel jLabel16;
    protected javax.swing.JLabel jLabel17;
    protected javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    protected javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    protected javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    protected javax.swing.JTable jTable2;
    protected javax.swing.JTextField jTextField1;
    protected javax.swing.JTextField jTextField2;
    protected javax.swing.JTextField jTextField3;
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
    private javax.swing.JPanel menuLeftPanel4;
    private javax.swing.JPanel menuLeftPanel5;
    private javax.swing.JPanel menuLeftPanel6;
    private javax.swing.JPanel menuLeftPanel7;
    private javax.swing.JPanel menuLeftPanel8;
    private javax.swing.JPanel menuLeftPanel9;
    private javax.swing.JPanel menuPanel1;
    private javax.swing.JPanel menuPanel2;
    private javax.swing.JPanel menuPanel3;
    private javax.swing.JPanel menuPanel5;
    private javax.swing.JPanel menuPanel6;
    private javax.swing.JPanel menuPanel7;
    private javax.swing.JPanel menuPanel8;
    private javax.swing.JLabel minimizeLabel;
    private javax.swing.JPanel minimizePanel;
    private javax.swing.JPanel motionPanel;
    protected javax.swing.JButton newProject;
    private javax.swing.JPanel overviewPanel;
    protected javax.swing.JLabel pCurrent;
    private javax.swing.JScrollPane projectAvailableScrollPane;
    private javax.swing.JTable projectAvailableTable;
    private javax.swing.JLabel projectColleagueLabel;
    private javax.swing.JTable projectColleagueTable;
    private javax.swing.JLabel projectContactLabel;
    private javax.swing.JTextField projectContactTextField;
    private javax.swing.JLabel projectCustomerLabel;
    private javax.swing.JTextField projectCustomerTextField;
    private javax.swing.JLabel projectDescriptionLabel;
    private javax.swing.JTextArea projectDescriptionTextArea;
    private javax.swing.JLabel projectEmailLabel;
    private javax.swing.JTextField projectEmailTextField;
    private javax.swing.JLabel projectHeaderLabel1;
    private javax.swing.JPanel projectInfoPanel;
    private javax.swing.JLabel projectNameLabel;
    private javax.swing.JTextField projectNameTextField;
    private javax.swing.JPanel projectPanel;
    private javax.swing.JLabel projectPhoneLabel;
    private javax.swing.JTextField projectPhoneTextField;
    private javax.swing.JLabel projectTableHeaderLabel;
    protected javax.swing.JLabel sRemoveSelected;
    protected javax.swing.JComboBox<String> sSkillChosenBox;
    protected javax.swing.JTable sSkillTable;
    private javax.swing.JPanel settingsPanel;
    protected javax.swing.JComboBox<String> timeChooseEndTimeCB;
    protected javax.swing.JComboBox<String> timeChooseEndTimeCB1;
    protected javax.swing.JComboBox<String> timeChooseProjectCB;
    protected javax.swing.JComboBox<String> timeChooseProjectCB1;
    protected javax.swing.JComboBox<String> timeChooseStartTimeCB;
    protected javax.swing.JComboBox<String> timeChooseStartTimeCB1;
    private javax.swing.JLabel timeDateLabel;
    private javax.swing.JLabel timeDateLabel1;
    private javax.swing.JLabel timeDateLabel2;
    private javax.swing.JLabel timeDateLabelNew;
    private javax.swing.JLabel timeDateLabelNew1;
    private javax.swing.JPanel timeDatePanel;
    private javax.swing.JPanel timeDatePanel1;
    protected javax.swing.JLabel timeEditDateLabelNew;
    private javax.swing.JPanel timeEditDatePanel;
    private javax.swing.JLabel timeEditHeaderLabel;
    protected javax.swing.JPanel timeEditStampPanel;
    private javax.swing.JLabel timeEditStampSaveLabel;
    protected javax.swing.JTable timeEditStampTable;
    private javax.swing.JLabel timeEndLabel;
    private javax.swing.JLabel timeEndLabel1;
    protected javax.swing.JPanel timeLastEditStampPanel;
    private javax.swing.JPanel timePanel;
    private javax.swing.JLabel timeProjectLabel;
    private javax.swing.JLabel timeProjectLabel1;
    private javax.swing.JPanel timeSendButtonPanel;
    private javax.swing.JPanel timeSendButtonPanel1;
    private javax.swing.JLabel timeStampHeaderLabel;
    private javax.swing.JLabel timeStartLabel;
    private javax.swing.JLabel timeStartLabel1;
    protected javax.swing.JLabel timeSucceededLabel;
    protected javax.swing.JLabel timeSucceededLabel1;
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
        //Sätter namnet på inloggad användare uppe till vänster i GUI
        currentUserLabel.setText(userLabel);
    }
    
    public void setTimeSucceededLabelColor(Color color) {
        timeSucceededLabel.setForeground(color);
    }
    
    private void sendTimeReport() {
        String projectName = (String) timeChooseProjectCB.getSelectedItem();
        System.out.println(projectName);
        //Metoden tar emot String med porjektnamn och returnerar tillhörande porjektID som en int
        int projectID = guiM.getProjectID(projectName);
        String date = timeDateLabelNew.getText();
        String startTime = (String) timeChooseStartTimeCB.getSelectedItem();
        String endTime = (String) timeChooseEndTimeCB.getSelectedItem();
        
        String missingFieldsMsg = "";
        boolean missingField = false;
        
        if(projectName.equals("Välj projekt")) {
            missingField = true;
            missingFieldsMsg = missingFieldsMsg + "Projekt, ";
        }
        if(date.equals("Välj datum")) {
            missingField = true;
            missingFieldsMsg = missingFieldsMsg + "Datum, ";
        }
        if(startTime.equals("Välj starttid")) {
            missingField = true;
            missingFieldsMsg = missingFieldsMsg + "Starttid, ";
        }
        if(endTime.equals("Välj sluttid")) {
            missingField = true;
            missingFieldsMsg = missingFieldsMsg + "Sluttid, ";
        }
        if(missingField) {
            JOptionPane.showConfirmDialog(this, "Du måste ange " + missingFieldsMsg + "för att rapportera tiden"
                                               , "Missade fält", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
        }
        else{
            //Om inga fält saknas så utförs tidrapporteringen
            guiM.sendTimeToDB(userID, projectID, date, startTime, endTime);
        }
    }
    
    public void selectedPanel(int menuNr) {
        //Sätter först alla peneler till false
        //och sätter sedan vald panel till true via switch
        timePanel.setVisible(false);
        projectPanel.setVisible(false);
        overviewPanel.setVisible(false);
        adminUserPanel1.setVisible(false);
        adminProjectPanel.setVisible(false);
        settingsPanel.setVisible(false);
        
        switch(menuNr) {
            case 1:
                menuPanel2.setBackground(new java.awt.Color(92,126,162));
                menuPanel3.setBackground(new java.awt.Color(92,126,162));
                menuPanel5.setBackground(new java.awt.Color(92,126,162));
                menuPanel6.setBackground(new java.awt.Color(92,126,162));
                menuPanel7.setBackground(new java.awt.Color(92,126,162));
                menuPanel8.setBackground(new java.awt.Color(92,126,162));
                timePanel.setVisible(true);
                break;
            case 2:
                menuPanel1.setBackground(new java.awt.Color(92,126,162));
                menuPanel3.setBackground(new java.awt.Color(92,126,162));
                menuPanel5.setBackground(new java.awt.Color(92,126,162));
                menuPanel6.setBackground(new java.awt.Color(92,126,162));
                menuPanel7.setBackground(new java.awt.Color(92,126,162));
                menuPanel8.setBackground(new java.awt.Color(92,126,162));
                projectPanel.setVisible(true);
                break;
            case 3:
                overviewPanel.setVisible(true);
                break;
            case 4:
                
                break;
            case 5:
                adminUserPanel1.setVisible(true);
                break;
            case 6:
                adminProjectPanel.setVisible(true);
                break;
            case 7:
                settingsPanel.setVisible(true);
                break;
            case 8:
                break;
            default:
                
        }
    }
    
    public void setTimeDefaultValues() {
        //Återställer till default values och färger efter att en rapportering har gjorts
//        guiM.getAvailableProjects(userID, timeChooseProjectCB);
        setGreyForeground(timeChooseProjectCB, true);
        setGreyForeground(timeChooseStartTimeCB, true);
        setTimeValues(timeChooseStartTimeCB, true, 1);
        setTimeValues(timeChooseEndTimeCB, false, 1);
        timeDateLabelNew.setText("Välj datum");
        timeDateLabelNew.setForeground(new Color(165,165,165));
    }
    
    public boolean validTextFieldsInput() {
       boolean sucess = false;
        if(jTextField1.getText().trim().isEmpty() 
                && jTextField2.getText().trim().isEmpty()
                && jTextField3.getText().trim().isEmpty() 
                && jPasswordField2.getText().trim().isEmpty()
                && jTable2.getRowCount() < 1) {
            
            jLabel18.setText("Alla fält är inte ifyllda, fyll i alla fält!");
        }
        else if(jTextField1.getText().trim().isEmpty()){
             jLabel18.setText("Fyll i ett Förnamn");
        } 
         else if(jTextField2.getText().trim().isEmpty()) {
             jLabel18.setText("Fyll i ett Efternamn");
        }
         else if(jTextField3.getText().trim().isEmpty()) {
             jLabel18.setText("Fyll i en Email");
        }
         else if(jPasswordField2.getText().trim().isEmpty()) {
             jLabel18.setText("Fyll i ett Lösenord");
        }
         else if(jTable2.getRowCount() < 1) {
             jLabel18.setText("Vi anställer inga utan skills");
        } else {
             sucess = true;
         }
        return sucess;
    }
    
    class MyComboBox<E> extends JComboBox<E> {
        public MyComboBox(E[] list) {
            super(list);
        }
        @Override public void updateUI() {
            super.updateUI();
            //Tar bort tomrummet där knappen tidigare var samt skapar ny onsynlig border
            UIManager.put("ComboBox.squareButton", Boolean.FALSE);
            setUI(new BasicComboBoxUI() {
                @Override protected JButton createArrowButton() {
                    JButton b = new JButton();
                    b.setBorder(BorderFactory.createEmptyBorder());
                    b.setVisible(false);
                    return b;
                }
            });
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }
    }
    
    private void setComboBoxCenter(JComboBox comboBox) {
        ((JLabel)comboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    private void setTimeValues(JComboBox comboBox, boolean startTime, int title) {
        //Default inställningar till comboboxen för tidrapportering
        setGreyForeground(comboBox, true);
        
        if(startTime==true && title == 1) {
            comboBox.removeAllItems();
            comboBox.addItem("Välj starttid");
        }
        else if(startTime==false && title == 1) {
            comboBox.removeAllItems();
            comboBox.addItem("Välj sluttid");
        }
        comboBox.addItem("05:00");
        comboBox.addItem("06:00");
        comboBox.addItem("07:00");
        comboBox.addItem("08:00");
        comboBox.addItem("09:00");
        comboBox.addItem("10:00");
        comboBox.addItem("11:00");
        comboBox.addItem("12:00");
        comboBox.addItem("13:00");
        comboBox.addItem("14:00");
        comboBox.addItem("15:00");
        comboBox.addItem("16:00");
        comboBox.addItem("17:00");
        comboBox.addItem("18:00");
        comboBox.addItem("19:00");
        comboBox.addItem("20:00");
        comboBox.addItem("21:00");
        comboBox.addItem("22:00");
    }
    
    private void setGreyForeground(JComboBox comboBox, boolean fromMenu) {
        //Sätter tillbaka ljusgrå färg på texten om inget val är gjort
        if(fromMenu){
            comboBox.setForeground(new Color(187,187,187));
        }
        else if(comboBox.getSelectedItem().equals("Välj projekt") ||
                comboBox.getSelectedItem().equals("Välj starttid") ||
                comboBox.getSelectedItem().equals("Välj sluttid")) {
                comboBox.setForeground(new Color(187,187,187));
        }
    }
    
    private void defaultMenuSettings() {
        //Sätter alla paneler (knappar/menyval) till false vid start,
        //förutom Tidrapportering som ska vara default när programmet startar
        selectedPanel(1);
        //Sätter alla booleans i arrayen till false
        Arrays.fill(menuArray, Boolean.FALSE);
//        //Hämtar projekt samt isntällningar för comboboxen til projekt när man klickar på menyn "tidrapportering"
//        guiM.getAvailableProjects(userID, timeChooseProjectCB);
        //Tar bort fokus från comboboxen vid start
        timeSendButtonPanel.requestFocus(true);
    }
    
    private void timeDatePickerSettings() {
        //Override på metoder i JXDatePicker1 för att den ska öppna när den får fokus
        dp1.getEditor().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                BasicDatePickerUI pickerUI = (BasicDatePickerUI) dp1.getUI();
                if (!pickerUI.isPopupVisible() && e.getOppositeComponent() != getRootPane() && e.getOppositeComponent() != dp1.getMonthView()) {
                    pickerUI.toggleShowPopup();
            }
        }
        @Override
        public void focusLost(FocusEvent e) { 
            }
        });
        
        //Override på metoder i JXDatePicker2 för att den ska öppna när den får fokus
        dp2.getEditor().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                BasicDatePickerUI pickerUI = (BasicDatePickerUI) dp2.getUI();
                if (!pickerUI.isPopupVisible() && e.getOppositeComponent() != getRootPane() && e.getOppositeComponent() != dp1.getMonthView()) {
                    pickerUI.toggleShowPopup();
            }
        }
        @Override
        public void focusLost(FocusEvent e) { 
            }
        });
        
        //Override på metoder i JXDatePicker1 för att den ska öppna när den får fokus
        dp3.getEditor().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                BasicDatePickerUI pickerUI = (BasicDatePickerUI) dp3.getUI();
                if (!pickerUI.isPopupVisible() && e.getOppositeComponent() != getRootPane() && e.getOppositeComponent() != dp1.getMonthView()) {
                    pickerUI.toggleShowPopup();
            }
        }
        @Override
        public void focusLost(FocusEvent e) { 
            }
        });
        
        //Ger defaultvärde dagens datum till JXDatePicker
        //dp1.setDate(Calendar.getInstance().getTime());
        
        //Ändrar boolean till true för att det nu går att hämta värdet från JXDatePicker utan crash
        //Crashen beror på att Event Property Change används och har först inget värde vid uppstart av programmet
        dateChangedAllowed = true;
    }
    
    private void availableProjectsToTable(JTable jTable) {
        //Hämtar tilldelade projekt och sparar i rs
        ResultSet rs = guiM.getAvailableProjects(userID, jComboBox1, false);
        //Sätter in resultatet från databasen i tabellen
        jTable.setModel(DbUtils.resultSetToTableModel(rs));
        //Centrerar allt i tabellen
        setTableCellsAlignment(jTable, SwingConstants.CENTER);
    }
    
    private void timeComboBoxSettings() {
        setComboBoxCenter(timeChooseProjectCB);
        setComboBoxCenter(timeChooseStartTimeCB);
        setComboBoxCenter(timeChooseEndTimeCB);
        setComboBoxCenter(timeChooseProjectCB1);
        setComboBoxCenter(timeChooseStartTimeCB1);
        setComboBoxCenter(timeChooseEndTimeCB1);
        setTimeValues(timeChooseStartTimeCB, true, 1);
        setTimeValues(timeChooseEndTimeCB, false, 1);
        setTimeValues(timeChooseStartTimeCB1, true, 1);
        setTimeValues(timeChooseEndTimeCB1, false, 1);
    }
    
    public void setTableCellsAlignment(JTable table, int alignment)
    {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }
    
    protected void sendUpdateTimeStampToDB() {
        //Sparar tidsID från vald rad i tabellen
        int timeID = Integer.parseInt(timeEditStampTable.getValueAt(timeEditStampTable.getSelectedRow(), 0).toString());
        //Sparar projektnamn från combobox
        String projectName = (String) timeChooseProjectCB1.getSelectedItem();
        //Hämtar projectID baserad på projektnamn med metoden getProjectID
        int projectID = guiM.getProjectID(projectName);
        //Sparar datum från jLabel
        String date = timeDateLabelNew1.getText();
        //Sparar starttid fårn combobox
        String startTime = (String) timeChooseStartTimeCB1.getSelectedItem();
        //Sparar sluttid från combobox
        String endTime = (String) timeChooseEndTimeCB1.getSelectedItem();
        //Skickar uppdatering till databasen med metoden sendTimeUpdateToDB()
        
        String missingFieldsMsg = "";
        boolean missingField = false;
        
        if(projectName.equals("Välj projekt")) {
            missingField = true;
            missingFieldsMsg = missingFieldsMsg + "Projekt, ";
        }
        if(date.equals("Välj datum")) {
            missingField = true;
            missingFieldsMsg = missingFieldsMsg + "Datum, ";
        }
        if(startTime.equals("Välj starttid")) {
            missingField = true;
            missingFieldsMsg = missingFieldsMsg + "Starttid, ";
        }
        if(endTime.equals("Välj sluttid")) {
            missingField = true;
            missingFieldsMsg = missingFieldsMsg + "Sluttid, ";
        }
        if(missingField) {
            JOptionPane.showConfirmDialog(this, "Du måste ange " + missingFieldsMsg + " för att uppdatera tidrapporten."
                                               , "Missade fält", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
        }
        else{
            //Om inga fält saknas så utförs tidrapporteringen
            guiM.sendTimeUpdateToDB(userID, timeID, projectID, date, startTime, endTime);
        }
    }
    
    protected void menuTimeDefaultValues() {
        //Hämtar alla tillgängliga projekt för inloggad användare och lägger i comboboxen
        //guiM.getAvailableProjects(userID, );
        setGreyForeground(timeChooseProjectCB, true);
        setGreyForeground(timeChooseStartTimeCB, true);
        setTimeValues(timeChooseStartTimeCB, true, 1);
        setTimeValues(timeChooseEndTimeCB, false, 1);
        timeChooseProjectCB.removeAllItems();
        timeChooseProjectCB.addItem("Välj projekt");
        timeDateLabelNew.setText("Välj datum");
        timeDateLabelNew.setForeground(new Color(165,165,165));
        timeEditDateLabelNew.setText("Välj datum");
        timeEditDateLabelNew.setForeground(new Color(165,165,165));
        //Paneler för redigering av tidrapport döljs
        timeEditStampPanel.setVisible(false);
        timeLastEditStampPanel.setVisible(false);
    }
    
    private void timeEditTableSettings() {
        //Ändrar så att endast en rad åt gången kan väljas på tabellen
        timeEditStampTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Lägger till en listener som triggas direkt när man markerar en rad i tabellen
        timeEditStampTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        @Override
        public void valueChanged(ListSelectionEvent event) {
            //Skriver över värden från den markerade raden i tabellen
            try {
                timeChooseProjectCB1.removeAllItems();
                timeChooseProjectCB1.addItem(timeEditStampTable.getValueAt(timeEditStampTable.getSelectedRow(), 1).toString());
                timeDateLabelNew1.setText(timeEditStampTable.getValueAt(timeEditStampTable.getSelectedRow(), 2).toString());
                timeChooseStartTimeCB1.removeAllItems();
                timeChooseStartTimeCB1.addItem(timeEditStampTable.getValueAt(timeEditStampTable.getSelectedRow(), 3).toString());
                setTimeValues(timeChooseStartTimeCB1, true, 0);
                timeChooseEndTimeCB1.removeAllItems();
                timeChooseEndTimeCB1.addItem(timeEditStampTable.getValueAt(timeEditStampTable.getSelectedRow(), 4).toString());
                setTimeValues(timeChooseEndTimeCB1, true, 0);
                //Sätter färgerna till default ljusgrå
                setGreyForeground(timeChooseProjectCB1, true);
                setGreyForeground(timeChooseStartTimeCB1, true);
                setGreyForeground(timeChooseEndTimeCB1, true);
                timeDateLabelNew1.setForeground(new Color (165,165,165));
                //Gör panelen för att skicka in ändringarna till databasen synlig
                timeLastEditStampPanel.setVisible(true);
            
            } catch (Exception e) {
            }
            
        }
        });
    }
    
    private void projectTableSettings() {
        //Sätter bakgrund på scrollpane till vit (så att tabellen har vit bakgrund där inga rader finns)
        projectAvailableScrollPane.getViewport().setBackground(Color.white);
        //Ändrar så att endast en rad åt gången kan väljas på tabellen
        projectAvailableTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Lägger till en listener som triggas direkt när man markerar en rad i tabellen
        projectAvailableTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        @Override
        public void valueChanged(ListSelectionEvent event) {
            try {
                //Sparar markerat projekt i string projectName
                String projectName = projectAvailableTable.getValueAt(projectAvailableTable.getSelectedRow(), 0).toString();
                System.out.println("Projektnamn: " + projectName);
                //Hämtar markerat projektID med hjälp av projektnamnet
                int projectID = guiM.getProjectID(projectName);
                //Hämtar all info om projektet baserat på projektID och sparar return i en ResultSet
                ResultSet rs = guiM.getAllProjectInfo(projectID);
                //Skriver ut all info på rätt plats i GUI
                setGUIProjectInfo(rs, projectID);
                projectInfoPanel.setVisible(true);
                
            } catch (Exception e) {
                System.err.println("Något gick fel i Override av valueChanged() i metoden projectTableSettings()");
            }
            setTableCellsAlignment(projectColleagueTable, SwingConstants.CENTER);
            
        }
        });
    }
    
    public void setGUIProjectInfo(ResultSet rs, int projectID) {
        //Skriver ut all info på rätt plats i GUI, från ResultSet
        try {
            projectNameTextField.setText(rs.getString(1));
            projectCustomerTextField.setText(rs.getString(2));
            projectContactTextField.setText(rs.getString(3));
            projectPhoneTextField.setText(rs.getString(4));
            projectEmailTextField.setText(rs.getString(5));
            projectDescriptionTextArea.setText(rs.getString(6));
            //Placerar ResultSet i tabellen från return av metoden getColleaguesFromDB()
            projectColleagueTable.setModel(DbUtils.resultSetToTableModel(guiM.getColleaguesFromDB(projectID)));
        } catch (SQLException ex) {
            Logger.getLogger(TimeTrackGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void adminSettings() {
        isAdmin = guiM.getIsAdmin();
        //Slår av funktioner som icke-admin ej ska ha tillgång till
        if(!isAdmin) {
            menuPanel5.setVisible(false);
            menuPanel6.setVisible(false);
        }
    }
    
    private void timeHidePanels() {
        timeEditStampPanel.setVisible(false);
        timeLastEditStampPanel.setVisible(false);
    }
    
    private void timeSettings() {
        timeDatePickerSettings();
        timeComboBoxSettings();
        timeEditTableSettings();
        timeHidePanels();
    }
    
    private void projectColleaguesTableSettings() {
        //inget här
    }
    
    private void projectSettings() {
        projectTableSettings();
        pM.setGuiM(guiM);
        projectColleaguesTableSettings();

    }
    
    private void timeTrackSettings() {
        //Här körs metoden start() som finns i klassen TimerThread som i sin tur finns i klassen GUIMethods
        //Den kommer att starta en ny Thread som kan köras oberoende av det övriga programmet
        //och uppdatera tid och datum via en jLabel längst ner i högra hörnet.
        timerThread.start();
        guiM.setTimeTrackGUI(this);
        pM.setTimeTrackGUI(this);
        guiM.setPm(pM);
        defaultMenuSettings();
        timeSettings();
        projectSettings();
        adminSettings();
        
        DefaultListModel what = new DefaultListModel();
    //    String test = "";
    //    what.addElement(test);

        
    }
}


class PromptComboBoxRenderer extends BasicComboBoxRenderer
{
    private String prompt;

    /*
     *  Set the text to display when no item has been selected.
     */
    public PromptComboBoxRenderer(String prompt)
    {
        this.prompt = "Inget valt";
    }

    /*
     *  Custom rendering to display the prompt text when no item is selected
     */
    public Component getListCellRendererComponent(
            JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value == null)
            setText( prompt );

        return this;
    }
}