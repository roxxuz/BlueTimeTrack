/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetrack.gui;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author Retina
 */
public class ProjectMethods {
    
    Connection cn;
    PreparedStatement pstat;
    ResultSet rs;
    String DBAddress;
    String DBUser;
    String DBPass;
    TimeTrackGUI tGUI;
    ProjectMethods pM;
    GUIMethods guiM;
    ArrayList<Integer> userid = new ArrayList<Integer>();///Skriver in användare till projekt vid öppna projekt.
    ArrayList<Integer> uidSetOnP = new ArrayList<Integer>();  
    ArrayList<Integer> useronproject = new ArrayList<Integer>();
    ArrayList <Integer> uop = new ArrayList <Integer>();

        // booleans uidSetOnP & uop är redan skapade som kan jämföra sparade användare med nuvarande användare.
        String pName1 = ""; 
        String pName2 = "";
        String pDesc1 = "";
        String pDesc2 = "";
        String pStatus1 = "";
        String pStatus2 = "";
        String pCustomer1 = "";
        String pCustomer2 = "";
    boolean compareProjectFields;
    
    public ProjectMethods() {
    

}
    public void setTimeTrackGUI(TimeTrackGUI tGUI) {
        this.tGUI = tGUI;
    }
    
    public void setGuiM(GUIMethods guiM){
        this.guiM = guiM;
    }

    public void setConnection(Connection cn){
        this.cn = cn;
        
    }
    
        protected void readProperties(){
        //Metod som läser in värden från filen db.properties
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
        
        public Connection prepareDBConnection() {
        //Skapar Connection variabel med login info till DB
        //och returnerar den
        Connection con = null;
        try {
            con = DriverManager.getConnection(DBAddress, DBUser, DBPass);
        } catch (SQLException ex) {
            System.err.println("Uppkopplingen till databasen misslyckades. \n Förmodligen p.g.a för många användare aktiva");
        }
        return con;
    }

     ////SÄTTER IN ALLA PROJEKT I EN COMBOBOX///
    public void projectCombobox(){
        tGUI.ProjectsComboBox.removeAllItems();

        try {
            pstat = cn.prepareStatement("select project_name from projects");
            rs = pstat.executeQuery();

            while (rs.next()) {

                tGUI.ProjectsComboBox.addItem(rs.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(GUIMethods.class.getName()).log(Level.SEVERE, null, ex);
        }

        tGUI.ProjectsComboBox.setSelectedItem(null);
    }


    public void StatusCombobox(){
        ///SÄTTER IN VAL AV STATUS I EN COMBOBOX///
        tGUI.StatusComboBox.removeAllItems();
        try {
            pstat = cn.prepareStatement("select status from project_status");
            rs = pstat.executeQuery();

            while (rs.next()) {

                tGUI.StatusComboBox.addItem(rs.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(GUIMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        tGUI.StatusComboBox.setSelectedItem(null);
    }

    public void CustomerCombobox(){
        ///SÄTTER IN LISTA AV KUNDER I COMBOBOX///
        tGUI.CustomerComboBox.removeAllItems();
        try {
            pstat = cn.prepareStatement("select customer from customers");
            rs = pstat.executeQuery();

            while (rs.next()) {

                tGUI.CustomerComboBox.addItem(rs.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(GUIMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        tGUI.CustomerComboBox.setSelectedItem(null);
    }


    ///HÄMTAR INFO OM PROJEKT MAN VÄLJER I COMBOBOX OCH SÄTTER I TEXTFIELDS/COMBOBOX///
    public void setProjectInfo() {

        try {
            String projectName = tGUI.ProjectsComboBox.getSelectedItem().toString();
            try {
                pstat = cn.prepareStatement("select projects_id, project_name, project_description, ps.status, c.customer from projects p\n" +
                        "join project_status ps\n" +
                        "on p.project_status_id = ps.project_status_id \n" +
                        "join customers c\n" +
                        "on p.customer_id=c.customer_id\n" +
                        "where project_name = ?");
                pstat.setString(1, projectName);
                rs = pstat.executeQuery();

                while (rs.next()) {

                    tGUI.ProjectTextField1.setText(rs.getString(1));
                    tGUI.ProjectTextField2.setText(rs.getString(2));
                    tGUI.ProjectTextArea1.setText(rs.getString(3));
                    tGUI.StatusComboBox.setSelectedItem(rs.getString(4));
                    tGUI.CustomerComboBox.setSelectedItem(rs.getString(5));
                }
                        getProjectInfo1();
                        
            } catch (SQLException ex) {
                Logger.getLogger(ProjectMethods.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch (Exception e) {
            System.out.println("blabla");
        }
    }

    public void updateProject() {
        ///SPARAR ÄNDRINGAR MAN GJORT I TEXTFIELDS/COMBOBOX///

        String projectID = tGUI.ProjectTextField1.getText();
        String pn = tGUI.ProjectTextField2.getText();
        String pd = tGUI.ProjectTextArea1.getText();
        String statusID = tGUI.StatusComboBox.getSelectedItem().toString();
        String customerID = tGUI.CustomerComboBox.getSelectedItem().toString();

        ///HÄMTAR/GÖR OM STATUS/CUSTOMER-NAMN TILL ID///
        int sstatusID = getStatusID(statusID);
        int ccustomerID = getCustomerID(customerID);

        try {
            pstat = cn.prepareStatement("update projects set project_name = ?, project_description = ?, project_status_id = ?, customer_id = ? where projects_id = ?");
            pstat.setString(1, pn);
            pstat.setString(2, pd);
            pstat.setInt(3, sstatusID);
            pstat.setInt(4, ccustomerID);
            pstat.setString(5, projectID);
            pstat.executeUpdate();

        }
        catch (SQLException ex) {
            Logger.getLogger(ProjectMethods.class.getName()).log(Level.SEVERE, null, ex);
        } //return;
    }
    
    public void saveMethod(){
                String pname = tGUI.ProjectTextField2.getText();


        if (tGUI.saveNewProject){
            saveNewProject();
            usersHasProject();
            tGUI.ProjectsComboBox.removeAllItems();
            tGUI.CustomerComboBox.removeAllItems();
            tGUI.StatusComboBox.removeAllItems();
            projectCombobox();
            StatusCombobox();
            CustomerCombobox();

            tGUI.ProjectsComboBox.setVisible(true);
            tGUI.ProjectTextField1.setVisible(true);
            tGUI.jLabel24.setVisible(true);
            tGUI.jLabel17.setVisible(true);
            tGUI.ProjectsComboBox.setSelectedItem(pname);
            setProjectInfo();
            tGUI.saveNewProject = false;
            tGUI.pCurrent.setText("Redigera");

        }else{
            updateProject();
            usersHasProject();
            tGUI.ProjectsComboBox.removeAllItems();
            projectCombobox();
            tGUI.ProjectsComboBox.setSelectedItem(pname);
        }
        getProjectInfo1();
    }


    ///HÄMTAR STATUS ID FRÅN STATUS NAMN///
    public int getStatusID(String statusName){

        try {
            pstat = cn.prepareStatement("select project_status_id from project_status where status = ?");
            pstat.setString(1, statusName);
            rs = pstat.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        int statusID = 0;
        try {
            if(rs.next()) {
                statusID = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statusID;
    }


    ///HÄMTAR CUSTOMER ID FRÅN CUSTOMER NAMN///
    public int getCustomerID(String customerName){

        try {
            pstat = cn.prepareStatement("select customer_id from customers where customer = ?");
            pstat.setString(1, customerName);
            rs = pstat.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        int customerID = 0;
        try {
            if(rs.next()) {
                customerID = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customerID;
    }
    ///HÄMTAR USER_ID EFTER FÖR OCH EFTERNAMN///
    public int getUserID(String UserName){

        try {
            pstat = cn.prepareStatement("select user_id from users where FName = ? AND LName = ?");
            pstat.setString(1, UserName);
            rs = pstat.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        int statusID = 0;
        try {
            if(rs.next()) {
                statusID = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statusID;
    }

    public void saveNewProject(){
        ///SKAPAR ETT NYTT PROJEKT///
        String pn = tGUI.ProjectTextField2.getText();
        String pd = tGUI.ProjectTextArea1.getText();
        String statusID = tGUI.StatusComboBox.getSelectedItem().toString();
        String customerID = tGUI.CustomerComboBox.getSelectedItem().toString();

        int sstatusID = getStatusID(statusID);
        int ccustomerID = getCustomerID(customerID);

        try {
            pstat = cn.prepareStatement ("insert into projects (project_name, project_description, project_status_id, customer_id) VALUES (?,?,?,?)");
            pstat.setString(1, pn);
            pstat.setString(2,pd);
            pstat.setInt(3, sstatusID);
            pstat.setInt(4, ccustomerID);
            pstat.executeUpdate();

        }catch (SQLException ex) {
            Logger.getLogger(ProjectMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean question(){
        ///DIALOGRUTA SOM FRÅGAR OM MAN VILL SPARA VAD MAN SKRIVIT I TEXTFIELDS///
        boolean q;
        String pn = tGUI.ProjectTextField2.getText();
        String pd = tGUI.ProjectTextArea1.getText();
        String statusID = tGUI.StatusComboBox.getSelectedItem().toString();
        String customerID = tGUI.CustomerComboBox.getSelectedItem().toString();
        {
            int svar = JOptionPane.showConfirmDialog(null,
                    "Namn - " + pn + "\n"+
                            "Beskrivning - " + pd + "\n"+
                            "Status - " + statusID + "\n"+
                            "Kund - " + customerID + "\n\n"+
                            "Vill du spara?\n", "Spara nytt projekt?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (svar == JOptionPane.YES_OPTION){

                saveNewProject();
                q = true;                                }
            else{
                q = false;
            }
        }
        return q;
    }
    ///LÄGGER IN ALLA SKILLS I EN JCOMBOBOX///
    public void getAvailableSkillsProject() {
        try {
            tGUI.SkillBox.removeAllItems();
            try {
                pstat = cn.prepareStatement("select skill from skills");
                rs = pstat.executeQuery();
                while(rs.next()) {
                    tGUI.SkillBox.addItem(rs.getString(1));
                }
            }catch (SQLException ex) {
                Logger.getLogger(ProjectMethods.class.getName()).log(Level.SEVERE, null, ex);
            }
            tGUI.SkillBox.setSelectedItem(null);
        }
        catch (Exception e){
            System.out.println("haja");
        }
    }
    ///LÄGGER TILL ANVÄNDARE MED VALD SKILL I JCOMBOBOX///
    public void setSkillUsers() {
        tGUI.sSkillChosenBox.removeAllItems();
        try {
            String skill = tGUI.SkillBox.getSelectedItem().toString();
            int sskill = getSkillID(skill);

            try {
                pstat = cn.prepareStatement("select users.user_id, users.FName, users.LName\n" +
                        "from users_has_skills\n" +
                        "join users \n" +
                        "on users_has_skills.user_id=users.user_id\n" +
                        "join skills\n" +
                        "on users_has_skills.skill_id=skills.skill_id\n" +
                        "where users_has_skills.skill_id = ?");

                pstat.setInt(1, sskill);
                rs = pstat.executeQuery();

                while(rs.next()) {

                    userid.add(rs.getInt(1));
                    tGUI.sSkillChosenBox.addItem(rs.getString(2) + " " + (rs.getString(3)));

                }
                tGUI.sSkillChosenBox.setSelectedItem(null);
                tGUI.sSkillChosenBox.setEnabled(true);
            } catch (SQLException ex) {
                Logger.getLogger(ProjectMethods.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        catch (Exception e){
            System.err.println("jaja");
        }

        for (int i : userid) {
            System.out.println(i);
        }

    }



    ///HÄMTAR SKILL ID FRÅN SKILL NAMN///
    public int getSkillID(String skill){
        try {
            pstat = cn.prepareStatement("select skill_id from skills where skill = ?");
            pstat.setString(1, skill);
            rs = pstat.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        int skillID = 0;
        try {
            if(rs.next()) {
                skillID = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        return skillID;
    }




    ///LÄGG TILL ANVÄNDARE SOM ÄR KOPPLADE TILL PROJEKTET I EN JTABLE///
    public void setProjectSkillUsers() {
        try {
            uidSetOnP.clear();
            DefaultTableModel model = (DefaultTableModel)tGUI.sSkillTable.getModel();
            int a = tGUI.sSkillTable.getRowCount();
            for(int i = a; i > 0 ; i--) {
                model.removeRow(i -1);
            }

            int pid = Integer.parseInt(tGUI.ProjectTextField1.getText());

            try {
                pstat = cn.prepareStatement("select users.user_id, users.FName, users.LName\n" +
                        "from users_has_projects\n" +
                        "join users\n" +
                        "on users_has_projects.user_id=users.user_id\n" +
                        "join projects\n" +
                        "on users_has_projects.project_id=projects.projects_id\n" +
                        "where users_has_projects.project_id = ?");

                pstat.setInt(1, pid);
                rs = pstat.executeQuery();


                while(rs.next()) {
                    int id = (rs.getInt(1));
                    String name = (rs.getString(2) + " " + (rs.getString(3)));
                    model.addRow(new Object[]{id, name});
                    uidSetOnP.add(id);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProjectMethods.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
            System.err.println("setprojectskillusers");
        }
    }


    ///LÄGG TILL NYA ANVÄNDARE TILL PROJEKT I EN JTABLE///
    public void setProjectSkillUsers2(){
        try {
            int uid = tGUI.sSkillChosenBox.getSelectedIndex();
            String skill = (String) tGUI.sSkillChosenBox.getSelectedItem();
            DefaultTableModel model = (DefaultTableModel)tGUI.sSkillTable.getModel();


            for(int i = 0; i < tGUI.sSkillTable.getRowCount(); i++) {
                if(tGUI.sSkillTable.getModel().getValueAt(i,1).equals(tGUI.sSkillChosenBox.getSelectedItem())) {
                    return;
                }
            }

            model.addRow(new Object[]{userid.get(uid), skill});
            System.out.println(userid.get(uid));
        }
        catch (Exception e){
            System.out.println("lilo");
        }
    }


    ///HÄMTA PROJEKTID FRÅN PROJEKTNAMN I PROJECTTEXTFIELD2///
    public int getProjectIdFromProjectName(String PName){
        String name = tGUI.ProjectTextField2.getText();
        try {
            pstat = cn.prepareStatement("select projects_id from projects where project_name = ?");
            pstat.setString(1, name);
            rs = pstat.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        int projectID = 0;
        try {
            if(rs.next()) {
                projectID = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projectID;
    }

    ///TAR FRAM VILKA USER_ID SOM ÄR KOPPLAD TILL VALT PROJEKT///
    public void getUserIdFromProject (int pid) {

        try {
            pstat = cn.prepareStatement("select user_id from users_has_projects where project_id = ?");
            pstat.setInt(1, pid);
            rs = pstat.executeQuery();

            while (rs.next()) {
                useronproject.add(rs.getInt(1));

            }
        } catch (Exception e){
            System.out.println("noUIDfromPID");
        }

    }

    ///LÄGG IN DATA I USERS_HAS_PROJECT TABELLEN
    public void usersHasProject() {
        int pid;
        ArrayList <Integer> uop = new ArrayList <Integer>();
        try {
            String name = tGUI.ProjectTextField2.getText();
            pid = getProjectIdFromProjectName(name);
            getUserIdFromProject(pid);
            DefaultTableModel model = (DefaultTableModel)tGUI.sSkillTable.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                int uid = (Integer) tGUI.sSkillTable.getValueAt(i, 0);
                uop.add(uid);


                if (!useronproject.contains(uid)){

                    try {
                        pstat = cn.prepareStatement("insert into users_has_projects (user_id, project_id) values (?,?)");
                        pstat.setInt(1, uid);
                        pstat.setInt(2, pid);
                        pstat.executeUpdate();

                        useronproject.clear();
                    } catch (SQLException ex) {
                        Logger.getLogger(ProjectMethods.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                }

            }
            for (int y : useronproject){
                if (!uop.contains(y)){
                    removeUserFromProject(y,pid);
                }
            }
        } catch (Exception e) {
            System.out.println("nixenpixen");
        }
    }
    ///TAR BORT FRÅN USERS_HAS_PROJECTS///
    public void removeUserFromProject(int uid, int pid){
        try{
            pstat = cn.prepareStatement("delete from users_has_projects where user_id = ? AND project_id = ?");
            pstat.setInt(1, uid);
            pstat.setInt(2, pid);
            pstat.executeUpdate();
        }
        catch(Exception e){

        }
    }
    ///TÖMMER ALLA FÄLT I ADMINPROJECTS///
    public void clearAllProjectFields() {
        tGUI.ProjectTextField1.setText("");
        tGUI.ProjectTextField2.setText("");
        tGUI.ProjectTextArea1.setText("");
        tGUI.ProjectsComboBox.removeAllItems();
        tGUI.CustomerComboBox.removeAllItems();
        tGUI.StatusComboBox.removeAllItems();
        tGUI.sSkillChosenBox.removeAllItems();
        tGUI.SkillBox.removeAllItems();
        DefaultTableModel mod = (DefaultTableModel) tGUI.sSkillTable.getModel();
        mod.setRowCount(0);
    }

        public void getProjectInfo1(){
        // booleans uidSetOnP & uop är redan skapade som kan jämföra sparade användare med nuvarande användare.
        pName1 = tGUI.ProjectTextField2.getText();
        pDesc1 = tGUI.ProjectTextArea1.getText();
        pStatus1 = (String) tGUI.StatusComboBox.getSelectedItem();
        pCustomer1 = (String) tGUI.CustomerComboBox.getSelectedItem();
        
        if (pStatus1 == null){
            pStatus1 = "";
        }
        if (pCustomer1 == null){
            pCustomer1 = "";
        }
            System.out.println("111111");
            System.out.println(pName1);
            System.out.println(pDesc1);
            System.out.println(pStatus1);
            System.out.println(pCustomer1);
            System.out.println("1111111");
        }
    
    public void getProjectInfo2(){
        // booleans uidSetOnP & uop är redan skapade som kan jämföra sparade användare med nuvarande användare.
        pName2 = tGUI.ProjectTextField2.getText();
        pDesc2 = tGUI.ProjectTextArea1.getText();
        pStatus2 = (String) tGUI.StatusComboBox.getSelectedItem();
        pCustomer2 = (String) tGUI.CustomerComboBox.getSelectedItem();
        
        if (pStatus2 == null){
            pStatus2 = "";
        }
        if (pCustomer2 == null){
            pCustomer2 = "";
        }
        System.out.println("22222");
        System.out.println(pName2);
        System.out.println(pDesc2);
        System.out.println(pStatus2);
        System.out.println(pCustomer2);
        System.out.println("222222");
    }

        
        public void compareFields(){
              
            
            if (pName1.equals(pName2)
                    &&
                pDesc1.equals(pDesc2)
                    &&
                pStatus1.equals(pStatus2)
                    &&
                pCustomer1.equals(pCustomer2) )
        //            &&
        //        uidSetOnP.equals(useronproject))  
            {
                System.out.println("\nthe same");
            }
            else {
                System.out.println("Do you want to save changes?");
                 {
            int svar = JOptionPane.showConfirmDialog(null,
                   "Vill du spara ändringar?", "Spara?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (svar == JOptionPane.YES_OPTION){
                saveMethod();
                
            }  else {
                }                            
        }                  
            }
            
        }
        
        public void resetIsSaved(){
        pName1 = ""; 
        pName2 = "";
        pDesc1 = "";
        pDesc2 = "";
        pStatus1 = "";
        pStatus2 = "";
        pCustomer1 = "";
        pCustomer2 = "";
        
        }
        
        public void printAL(){
                for (int i : userid){
                System.out.println("uidSetOnP " + i);
            }
                for (int i :useronproject){
                System.out.println("useronproject " + i);
            }
        }
}
