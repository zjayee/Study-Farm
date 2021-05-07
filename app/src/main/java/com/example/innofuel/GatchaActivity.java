package com.example.innofuel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
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
    TextView coinNumTextview;

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
        coinNumTextview = findViewById(R.id.coinNumTextview);

        coinNumTextview.setText("x"+Inventory.getCoins());


        ((GifDrawable)gatchaMachineGif.getDrawable()).stop();





        spendCoinTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(Inventory.runGatcha()) {
                    ((GifDrawable) gatchaMachineGif.getDrawable()).start();
                    ((GifDrawable) gatchaMachineGif.getDrawable()).setLoopCount(1);


                    new CountDownTimer(5000, 1000) {
                        @Override
                        public void onTick(long arg0) {
                        }

                        @Override
                        public void onFinish() {
                            Intent intent = new Intent(getBaseContext(), Gatcha2Activity.class);
                            startActivity(intent);
                        }
                    }.start();
                }
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