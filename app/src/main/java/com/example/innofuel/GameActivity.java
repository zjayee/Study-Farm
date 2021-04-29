package com.example.innofuel;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import pl.droidsonroids.gif.GifImageView;

public class GameActivity extends BaseActivity {

    BottomNavigationView navigationView;

    Button editFarmButton;
    CardView getNewItemCard;
    GifImageView farm1l2b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_rewards);
        navigationView = findViewById(R.id.navigation);
        navigationView.setBackgroundColor(getResources().getColor(R.color.translucentgreen,null));
        setupViews();



    }

    void setupViews(){
        editFarmButton = findViewById(R.id.editFarmButton);
        getNewItemCard = findViewById(R.id.getNewItemCard);
        farm1l2b = findViewById(R.id.farm1l2b);

        getNewItemCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), GatchaActivity.class);
                startActivity(intent);

            }
        });

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