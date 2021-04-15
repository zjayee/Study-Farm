package com.example.innofuel;

import java.util.ArrayList;

public class ActiveQuests {


    ArrayList<Quest> questList;

    private static ActiveQuests Instance = new ActiveQuests();

    private ActiveQuests(){
        questList = new ArrayList<>();

    };

    public static ActiveQuests getInstance() {
        return(Instance);
    }

    public void addQuest(Quest quest){
        questList.add(quest);
    }

    public void finishQuest(Quest quest){
        questList.remove(quest);
        //TODO: generate new quest
    }

    public ArrayList<Quest> getQuestList() {
        return questList;
    }



}
