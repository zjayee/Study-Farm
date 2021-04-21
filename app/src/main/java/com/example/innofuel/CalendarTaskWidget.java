package com.example.innofuel;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.Date;

public class CalendarTaskWidget extends FrameLayout implements View.OnClickListener {


    TextView dateTextview;
    TextView descriptionTextview;
    ImageButton alarmButton;


    public CalendarTaskWidget(@NonNull Context context, Task task) {
        super(context);

        //inflate layout
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.calendar_task,this, true);

        dateTextview = findViewById(R.id.dateTextview);
        descriptionTextview = findViewById(R.id.descriptionTextview);
        alarmButton = findViewById(R.id.alarmButton);

        //set date
        Date date = task.getDueDate();
        String monthString  = (String) DateFormat.format("L",  date);
        String dayString = (String) DateFormat.format("dd",   date);
        String dateString = monthString+" "+dayString;
        dateTextview.setText(dateString);

        //set description
        String description = task.getName();
        descriptionTextview.setText(description);

    }

    @Override
    public void onClick(View v) {

    }
}
