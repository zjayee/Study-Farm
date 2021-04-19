package com.example.innofuel;

import android.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

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


    private Quest(String name, String details, int total, ArrayList<Pair<Rewards, Integer> > rewards){
        this.name = name;
        this.details = details;
        this.completed = 0;
        this.total = total;
        this.rewards = rewards;
    }

    public static Quest generateQuest(){
        int random = (int) (Math.random() * QuestList.size());
        Quest quest = QuestList.get(random);

            while (ActiveQuests.getQuestList().contains(quest)) {
                random = (int) Math.random() * QuestList.size();
                quest = QuestList.get(random);
            }

        return quest;
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
                itemString = "x"+item.second+" "+rewardToString((Rewards) item.first);
                rewardString+= itemString;
            }else{
                itemString = "x"+item.second+" "+rewardToString((Rewards) item.first);
                rewardString+= " + "+ itemString;

            }
        }
        return rewardString;
    }

    public String rewardToString(Rewards rewards){
        String rewardString = rewards.toString();
        while(rewardString.contains("_")){
            int index = rewardString.indexOf("_");
            char[] rewardchar = rewardString.toCharArray();
            rewardchar[index] = ' ';
            rewardString = String.valueOf(rewardchar);
        }
        return rewardString;

    }

    static Pair<Rewards, Integer> woodenItem1 = new Pair<>(Rewards.random_wooden_item, 1);
    static Pair<Rewards, Integer> berryBush2 = new Pair<>(Rewards.berry_bushes, 2);
    static Pair<Rewards,Integer> vegetableCrop1 = new Pair<>(Rewards.random_vegetable_crop,1);
    static Pair<Rewards,Integer> coin2 = new Pair<>(Rewards.coins, 2);
    static Pair<Rewards,Integer> coin3 = new Pair<>(Rewards.coins, 3);

    static ArrayList<Pair<Rewards, Integer> > coin2wood1R = new ArrayList<Pair<Rewards, Integer>>(){{
       add(coin2);
       add(woodenItem1);
    }};

    static ArrayList<Pair<Rewards, Integer> > coin3R = new ArrayList<Pair<Rewards, Integer>>(){{
        add(coin3);
    }};

    static ArrayList<Pair<Rewards, Integer> > coin2berry2R = new ArrayList<Pair<Rewards, Integer>>(){{
        add(coin2);
        add(berryBush2);
    }};

    static ArrayList<Pair<Rewards, Integer> > coin2vegetable1R = new ArrayList<Pair<Rewards, Integer>>(){{
        add(coin2);
        add(vegetableCrop1);
    }};

    public static ArrayList<Quest> QuestList = new ArrayList<Quest>(){{
        add(new Quest("Chop some wood","Study 3 days before your next test", 3, coin2wood1R));
        add(new Quest("Feed the cows","Study 3 days before your next test", 3, coin3R));
        add(new Quest("Farm for berries","Study for a total of 2 hours", 2, coin2berry2R));
        add(new Quest("Water the crop","Study for a total of 2 hours", 2, coin3R));
        add(new Quest("Remove the weeds","Study for 3 consecutive days", 3, coin3R));
        add(new Quest("Plant some seeds","Study for 3 consecutive days", 3, coin2vegetable1R));
    }};

}

