package com.example.innofuel;

import java.util.Date;

public class Task implements Comparable{

    private String name;
    private Date dueDate; //for regular tasks without due dates, user chooses a date they wish for it to be done
    private Integer timeNeeded; //minutes
    private Boolean important;
    private TaskType taskType;


    Task(String name, Date dueDate, Integer timeNeeded, Boolean important, TaskType taskType){
        this.name = name;
        this.dueDate = dueDate;
        this.timeNeeded = timeNeeded;
        this.important = important;
        this.taskType = taskType;
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

    public TaskType getTaskType() {
        return taskType;
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

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    @Override


    public int compareTo(Object o) {
        //compares in terms of importance
        //returns -1 if this is less important, 0 if same, 1 if more important
        //compares for important marker, then due date - estimated work days(from time needed), then task type
        Task t = (Task)o;
        if (this.getImportant() && t.getImportant()){
            if(this.getDueDate().after(t.getDueDate())){
                return -1;
            }else if(t.getDueDate().after(this.getDueDate())){
                return 1;
            }else{



            }
        }
        return 0;
    }

    public int estimateWorkDays(){
        int minutes = this.getTimeNeeded();
        int days = minutes/90 + 1;

        if (this.getDaysUntilDeadline()<days){
            days = getDaysUntilDeadline();
        }

        return days; //estimating 90 minutes of work per day max

    }

    public int getDaysUntilDeadline(){
        //TODO: implement
        return 0;
    }
}

