package com.example.innofuel;

import java.util.ArrayList;

public class Inventory {

    private static ArrayList<GameItem> ownedItemList;
    private static ArrayList<GameItem> placedItemList;
    private static ArrayList<GameItem> notPlacedItemList;

    //for demo use coins starts at 5
    private static Integer coins = 5;

    private Inventory(){


    }

    public static ArrayList<GameItem> getOwnedItemList() {
        return ownedItemList;
    }

    public static void addToInventory(GameItem item){
        ownedItemList.add(item);
    }

    public static void removeFromInventory(GameItem item){
        ownedItemList.remove(item);
    }

    public static Integer getCoins() {
        return coins;
    }

    public static void earnCoins(int num){
        coins+=num;
    }

    public static void spendCoins(int num){
        coins -= num;
    }

    public static boolean runGatcha(){
        if (coins>=5){
            coins-=5;
            return true;
        }else{
            return false;
        }
    }

}
