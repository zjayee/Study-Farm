package com.example.innofuel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.util.concurrent.TimeUnit;

public class TimerActivity extends AppCompatActivity {
    //views
    TextView taskNameTextview;
    TextView countdownTextview;
    TextView nextBreakTextview;
    CircularProgressBar progressBar;
    Button finishTaskButton;
    Button pauseButton;

    //data
    Task currentTask;
    long millisLeft;
    boolean isPaused;

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

        taskNameTextview.setText(currentTask.getName());
        //TODO: set up timer initial time + break text
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
                mp.start();

                //TODO: implement button that stops media player
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