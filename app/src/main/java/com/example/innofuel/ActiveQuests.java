package com.example.innofuel;

import java.util.ArrayList;

public class ActiveQuests {

    //data
    ArrayList<Task> questList;

    private static ActiveQuests Instance = new ActiveQuests();

    private ActiveQuests(){
        questList = new ArrayList<>();

    };

    public static ActiveQuests getInstance() {
        return(Instance);
    }

    public void addQuest(Task task){
        questList.add(task);
    }

    public void finishQuest(Task task){
        questList.remove(task);
    }

    public ArrayList<Task> getQuestList() {
        return questList;
    }



}
