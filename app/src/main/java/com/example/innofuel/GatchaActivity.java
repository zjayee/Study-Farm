package com.example.innofuel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class GatchaActivity extends AppCompatActivity {

    ImageButton backButton;
    GifImageView gatchaMachineGif;
    CardView gatchaCard;
    TextView spendCoinTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gatcha);

        setUpViews();


    }


    void setUpViews(){
        backButton = findViewById(R.id.backButton);
        gatchaMachineGif = findViewById(R.id.gatchaMachineGif);
        gatchaCard = findViewById(R.id.gatchaCard);
        spendCoinTextview = findViewById(R.id.spendCoinTextview);

        ((GifDrawable)gatchaMachineGif.getDrawable()).stop();



        spendCoinTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((GifDrawable)gatchaMachineGif.getDrawable()).start();
                ((GifDrawable)gatchaMachineGif.getDrawable()).setLoopCount(1);
                
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