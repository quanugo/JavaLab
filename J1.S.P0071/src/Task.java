/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MacBook
 */
public class Task {
    
    private int id;
    private String name;
    private int typeID;
    private String date;
    private double timeTo;
    private double timeFrom;
    private String assignee;
    private String reviewer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(double timeTo) {
        this.timeTo = timeTo;
    }

    public double getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(double timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
    
    public String getTypeName(){
        switch(typeID){
            case 1:
                return "Code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            case 4:
                return "Reviewer";
        }
        return null;
    }
    
    public double getTime(){
        return getTimeTo() - getTimeFrom();
    }

    @Override
    public String toString() {
        return String.format("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n", id, name, getTypeID(), date, getTime(), assignee, reviewer);
    }
    
    
}
