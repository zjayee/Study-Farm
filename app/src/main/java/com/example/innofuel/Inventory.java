package com.example.innofuel;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {

    private static ArrayList<GameItem> ownedItemList = new ArrayList<>();
    private static HashMap<GameItem, Integer> itemNumbers = new HashMap<GameItem, Integer>(){{
        for(GameItem item : GameItem.getGameItems()){
            itemNumbers.put(item, 0); //initializes all items with inital value of zero
        }
    }
    };

    private static Integer coins = 0;

    private Inventory(){


    }

    public static ArrayList<GameItem> getOwnedItemList() {
        return ownedItemList;
    }

    public static ArrayList<GameItem> getPlacedItems(){
        ArrayList<GameItem> placedItems = new ArrayList<>();

        for(GameItem item: ownedItemList){
            if(item.isPlaced()){
                placedItems.add(item);
            }
        }

        return placedItems;
    }

    public static ArrayList<GameItem> getNotPlacedItems(){
        ArrayList<GameItem> notPlacedItems = new ArrayList<>();

        for(GameItem item: ownedItemList){
            if(!item.isPlaced()){
                notPlacedItems.add(item);
            }
        }

        return notPlacedItems;
    }

    public static void addToInventory(GameItem item){
        ownedItemList.add(item);
        if(itemNumbers.containsKey(item)){
            int oldValue = itemNumbers.get(item);
            itemNumbers.replace(item, oldValue, oldValue+1);
        }
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
