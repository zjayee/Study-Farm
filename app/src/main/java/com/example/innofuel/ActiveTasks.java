package com.example.innofuel;

import android.text.format.DateFormat;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class ActiveTasks {

    private ArrayList<Task> taskList = new ArrayList<>();

    private static ActiveTasks Instance = new ActiveTasks();

    private ActiveTasks(){
        

    };

    public static ActiveTasks getInstance() {
        return(Instance);
    }

    public void addTask(Task task){
        taskList.add(task);
        //sorts list
        Collections.sort(taskList);

    }

    public ArrayList<Task> getTasksInMonth(int m, int y){

        ArrayList<Task> tasksInMonth = new ArrayList<>();
        m++;

        for(Task task: taskList){
            Date dueDate = task.getDueDate();
            int dueM = Integer.parseInt((String) DateFormat.format("MM",   dueDate));
            int dueY = Integer.parseInt((String) DateFormat.format("yyyy",   dueDate));

            if(dueM==m && dueY == y){
                tasksInMonth.add(task);
            }else if(dueM<m){
                break;
            }
        }

        return tasksInMonth;

    }

    public void finishTask(Task task){
        taskList.remove(task);

        //Add to finished tasks?
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

}
