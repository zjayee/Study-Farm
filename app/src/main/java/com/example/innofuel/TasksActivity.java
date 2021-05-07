package com.example.innofuel;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TasksActivity extends BaseActivity {

    FloatingActionButton addTaskButton;
    LinearLayout tasksLinearLayout;
    LinearLayout questsLinearLayout;

    ArrayList<Quest> activeQuests;
    ArrayList<Task> activeTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_tasks);

        setupViews();
        setupAddTaskButton();
        refreshQuestsList();
        refreshTasksList();

    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshTasksList();
        refreshQuestsList();
    }

    @Override
    int getLayoutId() {
        return R.layout.activity_tasks;
    }

    @Override
    int getBottomNavigationMenuItemId() {
        return R.id.tasks;
    }


    void setupViews(){

        addTaskButton = findViewById(R.id.addTaskButton);
        tasksLinearLayout = findViewById(R.id.tasksLinearLayout);
        questsLinearLayout = findViewById(R.id.activeQuestsLinearLayout);

    }

    void setupAddTaskButton(){
        addTaskButton.setOnClickListener(v ->{

            final Dialog addTaskDialogue = new Dialog(this);
            addTaskDialogue.setContentView(R.layout.fragment_add_task);
            addTaskDialogue.setCancelable(true);
            addTaskDialogue.show();
            addTaskDialogue.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            ImageButton exitButton = addTaskDialogue.findViewById(R.id.exitButton);
            EditText titleEditText = addTaskDialogue.findViewById(R.id.titleEditText);
            NumberPicker hourNumberPicker = addTaskDialogue.findViewById(R.id.hourNumberPicker);
            NumberPicker minuteNumberPicker = addTaskDialogue.findViewById(R.id.minuteNumberPicker);
            EditText dateEditText = addTaskDialogue.findViewById(R.id.dateEditText);
            Button saveButton = addTaskDialogue.findViewById(R.id.saveButton);

            //set up number pickers
            String[] hours = new String[10];
            for(int i=0; i<hours.length; i++) {
               hours[i] = Integer.toString(i);
            }
            hourNumberPicker.setMinValue(0);
            hourNumberPicker.setMaxValue(9);
            hourNumberPicker.setDisplayedValues(hours);

            String[] minutes = new String[]{"0", "15", "30", "45"};
//            for(int i=0; i<minutes.length; i+=15) {
//                minutes[i] = Integer.toString(i);
//            }
            minuteNumberPicker.setMinValue(0);
            minuteNumberPicker.setMaxValue(3);
            minuteNumberPicker.setDisplayedValues(minutes);



            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String title;
                    int hour, minute, timeNeeded;
                    String dateString;
                    Date date;

                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                    title = titleEditText.getText().toString();
                    hour = hourNumberPicker.getValue();
                    minute = minuteNumberPicker.getValue()*15;
                    timeNeeded = hour*60 + minute;

                    try {
                        dateString = dateEditText.getText().toString();
                        date = formatter.parse(dateString);
                        Task newTask = new Task(title, date, timeNeeded);
                        ActiveTasks.getInstance().addTask(newTask);
                        refreshTasksList();
                        addTaskDialogue.dismiss();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                }
            });

            exitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addTaskDialogue.dismiss();
                }
            });



        } );

    }

    void refreshTasksList(){
        activeTasks = ActiveTasks.getInstance().getTaskList();
        tasksLinearLayout.removeAllViews();
        TaskWidget taskWidget;
        for (Task task: activeTasks){
            taskWidget = new TaskWidget(this, task);
            tasksLinearLayout.addView(taskWidget);

            TaskWidget finalTaskWidget = taskWidget;
            taskWidget.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getBaseContext(), TimerActivity.class);
                    intent.putExtra("currentTask", finalTaskWidget.task);
                    startActivity(intent);
                }
            });
        }



    }

    void refreshQuestsList(){

        activeQuests = ActiveQuests.getInstance().getQuestList();
        questsLinearLayout.removeAllViews();;

        for (Quest quest: activeQuests){
            QuestWidget questWidget = new QuestWidget(this, quest);
            questsLinearLayout.addView(questWidget);
        }


    }


}