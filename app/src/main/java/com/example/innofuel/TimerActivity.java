package com.example.innofuel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.util.concurrent.TimeUnit;

import static android.os.SystemClock.sleep;

public class TimerActivity extends AppCompatActivity {
    //views
    TextView taskNameTextview;
    TextView countdownTextview;
    TextView nextBreakTextview;
    CircularProgressBar progressBar;
    Button finishTaskButton;
    Button pauseButton;
    Button cancelButton;

    //data
    Task currentTask;
    long millisLeft;
    boolean isPaused = false;

    //other
    MediaPlayer mp;
    CountDownTimer countdownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        getIntentInfo();
        setupViews();
        startCountdown(TimeUnit.MINUTES.toMillis(30));

    }

    void getIntentInfo(){
        Intent intent = getIntent();
        currentTask = (Task)intent.getSerializableExtra("currentTask");

    }

    void setupViews(){
        taskNameTextview = findViewById(R.id.taskNameTextview);
        countdownTextview = findViewById(R.id.countdownTextview);
        nextBreakTextview = findViewById(R.id.nextBreakTextview);
        progressBar = findViewById(R.id.progressBar);
        finishTaskButton = findViewById(R.id.finishTaskButton);
        pauseButton = findViewById(R.id.pauseButton);
        cancelButton = findViewById(R.id.cancelButton);

        taskNameTextview.setText(currentTask.getName());
        //TODO: set up timer initial time + break text

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPaused==false){
                    pauseCountdown();
                    pauseButton.setText(R.string.resume);
                    isPaused=true;
                }else if(isPaused==true){
                    resumeCountdown();
                    pauseButton.setText(R.string.pause);
                    isPaused=false;
                }
            }

        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countdownTimer.cancel();
            }
        });

        finishTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: set task as finished
            }
        });

    }

    void startCountdown(long millis){

        Uri alarmSound = RingtoneManager. getDefaultUri (RingtoneManager. TYPE_ALARM);
        mp = MediaPlayer. create (getApplicationContext(), alarmSound);

        countdownTimer = new CountDownTimer(millis, 1000) {

            public void onTick(long millisUntilFinished) {
                millisLeft = millisUntilFinished;

                long minutes = TimeUnit.MILLISECONDS.toMinutes(millisLeft);
                long seconds = TimeUnit.MILLISECONDS.toSeconds(millisLeft);

                countdownTextview.setText(minutes+":"+seconds);
            }

            public void onFinish() {
                mp.start();{
                    sleep(5000);
                    mp.stop();
                }

            }


        }.start();
    }

    void pauseCountdown(){
        countdownTimer.cancel();

    }

    void resumeCountdown(){
        startCountdown(millisLeft);

    }

}