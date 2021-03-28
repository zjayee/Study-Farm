package com.example.innofuel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class TimerActivity extends AppCompatActivity {
    //views
    TextView taskNameTextview;
    TextView countdownTextview;
    TextView nextBreakTextview;
    CircularProgressBar progressBar;
    Button finishTaskButton;

    //data
    Task currentTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        getIntentInfo();
        setupViews();


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



}