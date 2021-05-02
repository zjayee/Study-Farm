package com.example.innofuel;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import pl.droidsonroids.gif.GifImageView;

public class GameActivity extends BaseActivity {

    BottomNavigationView navigationView;

    Button editFarmButton;
    CardView getNewItemCard;
    GifImageView farm1l2b;
    View profileFloat;
    TextView coinNumTextview;
    View gameInventoryPopup;
    //for demo
    ImageView cowUFO;

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
        profileFloat = findViewById(R.id.profileFloat);
        coinNumTextview = profileFloat.findViewById(R.id.coinNumTextview);
        gameInventoryPopup = findViewById(R.id.gameInventoryPopup);
        cowUFO = gameInventoryPopup.findViewById(R.id.cowUfo);

        coinNumTextview.setText("x"+Inventory.getCoins());


        getNewItemCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), GatchaActivity.class);
                startActivity(intent);

            }
        });

        editFarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameInventoryPopup.setVisibility(View.VISIBLE);
                editFarmButton.setVisibility(View.INVISIBLE);
            }
        });

        cowUFO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameInventoryPopup.setVisibility(View.INVISIBLE);
                editFarmButton.setVisibility(View.VISIBLE);
            }
        });

        farm1l2b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                farm1l2b.setImageResource(R.drawable.cow_ufo_gif);
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