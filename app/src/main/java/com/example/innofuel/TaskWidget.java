package com.example.innofuel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;


public class TaskWidget extends ConstraintLayout implements View.OnClickListener {

    Task task;
    TextView taskTextview;
    TextView timeTextview;



    public TaskWidget(@NonNull Context context, Task task) {
        super(context);

        this.task = task;

        //inflate layout
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.task_widget,this, true);

        //set views
        taskTextview = findViewById(R.id.taskTextview);
        timeTextview = findViewById(R.id.timeTextview);

        String taskName = task.getName();
        String taskTime = task.getTimeString();

        taskTextview.setText(taskName);
        timeTextview.setText(taskTime);


    }

    @Override
    public void onClick(View v) {
        //go to timer screen
//        Intent intent = new Intent(getContext(), TimerActivity.class);
//        intent.putExtra("currentTask",task);
//        getContext().startActivity(intent);

    }
}
