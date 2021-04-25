package com.example.innofuel;

import android.os.Bundle;

public class GameActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_rewards);
    }

    @Override
    int getLayoutId() {
        return R.layout.activity_game;
    }

    @Override
    int getBottomNavigationMenuItemId() {
        return R.id.game;
    }
}