
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetrack.model;

/**
 *
 * @author aquar
 */
public class Project {
    
    private int ID;
    private String name;
    private String description;
    private int userID;

    public Project() {
        
    }
    
    public Project(int ID, String name, String description, int userID) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.userID = userID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
      
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    
    
}
