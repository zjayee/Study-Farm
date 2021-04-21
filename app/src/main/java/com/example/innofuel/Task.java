package com.example.innofuel;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Task implements Comparable, Serializable {

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

    public String getTimeString(){
        if(timeNeeded<60){
            return timeNeeded + "min";
        }else if(timeNeeded%60 == 0){
            return  timeNeeded/60 + "hr";
        }else{
            int min = timeNeeded%60;
            int hr = timeNeeded/60;

            return hr+" hr "+min+" min";
        }


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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return name.equals(task.name) &&
                dueDate.equals(task.dueDate) &&
                timeNeeded.equals(task.timeNeeded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dueDate, timeNeeded);
    }

    public int getDaysUntilDeadline(){
        //TODO: implement
        return 0;
    }
}

