package com.example.innofuel;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class GameActivity extends BaseActivity {

    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_rewards);
        navigationView = findViewById(R.id.navigation);
        navigationView.setBackgroundColor(getResources().getColor(R.color.translucentgreen,null));

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