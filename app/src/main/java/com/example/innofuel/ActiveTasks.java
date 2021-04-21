package com.example.innofuel;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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


    public void finishTask(Task task){
        taskList.remove(task);

        //Add to finished tasks?
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

}
