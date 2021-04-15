package com.example.innofuel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ActiveTasks {

    private ArrayList<Task> taskList;

    private static ActiveTasks Instance = new ActiveTasks();

    private ActiveTasks(){
        taskList = new ArrayList<>();

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
