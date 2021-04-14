package com.example.innofuel;

import java.util.Date;

public class Task implements Comparable{

    private String name;
    private Date dueDate; //for regular tasks without due dates, user chooses a date they wish for it to be done
    private Integer timeNeeded; //minutes




    Task(String name, Date dueDate, Integer timeNeeded){
        this.name = name;
        this.dueDate = dueDate;
        this.timeNeeded = timeNeeded;


    }



    //get methods
    public String getName() {
        return name;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Integer getTimeNeeded() {
        return timeNeeded;
    }



    //set methods
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeNeeded(Integer timeNeeded) {
        this.timeNeeded = timeNeeded;
    }


    @Override


    public int compareTo(Object o) {

        //returns -1 if this is less important, 0 if same, 1 if more important
        //compares for due date
        Task t = (Task)o;

            if(this.getDueDate().after(t.getDueDate())){
                return 1;
            }else if(t.getDueDate().after(this.getDueDate())){
                return -1;
            }else{
            return 0;
            }

    }


    public int getDaysUntilDeadline(){
        //TODO: implement
        return 0;
    }
}

