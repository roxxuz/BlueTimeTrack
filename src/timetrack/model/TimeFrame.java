/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor..
 */
package timetrack.model;

/**
 *
 * @author aquar
 */
public class TimeFrame {
    private int ID;
    private int userID;
    private String comment;
    private String startTime;
    private String endTime;
    private int projectID;

    public TimeFrame() {
    }
    
    public TimeFrame(int ID, int userID, String comment, String startTime, String endTime, int projectID) {
        this.ID = ID;
        this.userID = userID;
        this.comment = comment;
        this.startTime = startTime;
        this.endTime = endTime;
        this.projectID = projectID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    

}

    