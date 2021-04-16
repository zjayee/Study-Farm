package com.example.innofuel;

import android.util.Pair;

import java.util.ArrayList;

public class Quest {

    //variables

    private String name;
    private String details;
   //completion
    private int completed;
    private int total;
    private String completion;
    //reward
    ArrayList<Pair<Rewards, Integer>> rewards;


    Quest(){



    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public int getCompleted() {
        return completed;
    }

    public int getTotal() {
        return total;
    }

    public String getCompletion() {
        completion = completed +" / "+ total;
        return completion;
    }

    public ArrayList<Pair<Rewards, Integer>> getRewards() {
        return rewards;
    }

    public String getRewardString(){
        String rewardString = "";

        for(int i = 0; i< rewards.size(); i++) {
            Pair item = rewards.get(i);
            String itemString;

            if(i == 0){
                itemString = "x"+item.second+" "+item.first;
                rewardString+= itemString;
            }else{
                itemString = "x"+item.second+" "+item.first;
                rewardString+= " + "+ itemString;

            }
        }
        return rewardString;
    }
}

