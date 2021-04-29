package com.example.innofuel;

import java.util.ArrayList;
import java.util.Objects;

public class GameItem {

    String name;
    int image;
    boolean placed = false;
    boolean owned = false;

    GameItem (String name, int image){
        this.name = name;
        this.image = image;
    }

    private static ArrayList<GameItem> GameItemList = new ArrayList<GameItem>(){{
        GameItemList.add(new GameItem("cow_ufo", R.drawable.cow_ufo_gif));
        GameItemList.add(new GameItem("cow_pen", R.drawable.cow_pen));
        GameItemList.add(new GameItem("plant", R.drawable.plant));
        GameItemList.add(new GameItem("house", R.drawable.house));
    }};

    public static ArrayList<GameItem> getGameItemList() {
        return GameItemList;
    }

    public static GameItem getRandomItem(){
        int randomNum = (int)(Math.random()*GameItemList.size());
        return GameItemList.get(randomNum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameItem gameItem = (GameItem) o;
        return image == gameItem.image &&
                placed == gameItem.placed &&
                owned == gameItem.owned &&
                name.equals(gameItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, image, placed, owned);
    }
}
