package com.example.innofuel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class Gatcha2Activity extends AppCompatActivity {

    GifImageView gameObjectGif;
    TextView tapToContinueTextview;
    RatingBar ratingBar;
    TextView objectNameTextview;
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gatcha2);

        setupViews();

    }

    void setupViews(){
        gameObjectGif = findViewById(R.id.gameItemGif);
        tapToContinueTextview = findViewById(R.id.continueTextview);
        ratingBar = findViewById(R.id.ratingBar);
        objectNameTextview = findViewById(R.id.objectNameTextview);


        tapToContinueTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(getBaseContext(), GameActivity.class);
                startActivity(intent);

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}