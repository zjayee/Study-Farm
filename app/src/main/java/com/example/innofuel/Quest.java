package com.example.innofuel;

public class Quest {

    //variables

    private String name;
    private String details;
   //completion
    private int completed;
    private int total;
    private String completion;
    //reward
    private Rewards rewardType;
    private int quantity;

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

    public int getQuantity() {
        return quantity;
    }

    public Rewards getRewardType() {
        return rewardType;
    }
}

