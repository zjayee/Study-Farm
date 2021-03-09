package com.example.innofuel;

import java.util.Date;

public class Task {

    private String name;
    private Date dueDate; //for regular tasks without due dates, user chooses a date they wish for it to be done
    private Integer timeNeeded; //minutes
    private Boolean important;

    Task(String name, Date dueDate, Integer timeNeeded, Boolean important){
        this.name = name;
        this.dueDate = dueDate;
        this.timeNeeded = timeNeeded;
        this.important = important;
    }



    //get methods
    public String getName() {
        return name;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Boolean getImportant() {
        return important;
    }

    public Integer getTimeNeeded() {
        return timeNeeded;
    }


    //set methods
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setImportant(Boolean important) {
        this.important = important;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeNeeded(Integer timeNeeded) {
        this.timeNeeded = timeNeeded;
    }
}

