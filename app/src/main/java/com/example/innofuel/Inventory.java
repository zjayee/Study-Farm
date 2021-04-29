package com.example.innofuel;

import java.util.ArrayList;

public class Inventory {

    private static ArrayList<GameItem> ownedItemList;
    private static ArrayList<GameItem> placedItemList;
    private static ArrayList<GameItem> notPlacedItemList;

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
}
