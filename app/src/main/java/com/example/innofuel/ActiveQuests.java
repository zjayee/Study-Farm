package com.example.innofuel;

public class ActiveQuests {

    //data


    private static ActiveQuests Instance = new ActiveQuests();

    private ActiveQuests(){};

    public static ActiveQuests getInstance() {
        return(Instance);
    }

}
