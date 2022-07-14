package com.example.innofuel;

import java.util.ArrayList;
import java.util.Objects;

public class GameItem {

    String name;
    int image;
    boolean placed = false;

    GameItem (String name, int image){
        this.name = name;
        this.image = image;
    }

    private static ArrayList<GameItem> GAME_ITEMS;

    public static void setGameItems(){
        GAME_ITEMS = new ArrayList<GameItem>();
        GAME_ITEMS.add(new GameItem("cow_ufo", R.drawable.cow_ufo_gif));
        GAME_ITEMS.add(new GameItem("cow_pen", R.drawable.cow_pen));
        GAME_ITEMS.add(new GameItem("plant", R.drawable.plant));
        GAME_ITEMS.add(new GameItem("house", R.drawable.house));
    }

    public static ArrayList<GameItem> getGameItems() {
        return GAME_ITEMS;
    }

    public static GameItem getRandomItem(){
        int randomNum = (int)(Math.random()* GAME_ITEMS.size());
        return GAME_ITEMS.get(randomNum);
    }

    public boolean isPlaced(){
        return placed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameItem gameItem = (GameItem) o;
        return image == gameItem.image &&
                placed == gameItem.placed &&
                name.equals(gameItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, image, placed);
    }
}
