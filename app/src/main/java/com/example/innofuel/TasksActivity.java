package com.example.innofuel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

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
        setupQuestsList();


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
            //TODO: add task fragment


            final Dialog addTaskDialogue = new Dialog(this);
            addTaskDialogue.setContentView(R.layout.fragment_add_task);
            addTaskDialogue.setCancelable(true);
            addTaskDialogue.show();

            Button exitButton = addTaskDialogue.findViewById(R.id.exitButton);
            EditText titleEditText = addTaskDialogue.findViewById(R.id.titleEditText);
            NumberPicker hourNumberPicker = addTaskDialogue.findViewById(R.id.hourNumberPicker);
            NumberPicker minuteNumberPicker = addTaskDialogue.findViewById(R.id.minuteNumberPicker);
            EditText dateEditText = addTaskDialogue.findViewById(R.id.dateEditText);

            

            exitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addTaskDialogue.dismiss();
                }
            });



        } );

    }

    void setupTasksList(){
        activeTasks = ActiveTasks.getInstance().getTaskList();

        for (Task task: activeTasks){
            TaskWidget taskWidget = new TaskWidget(this, task);
            tasksLinearLayout.addView(taskWidget);
        }

    }

    void setupQuestsList(){
        //        QuestWidget questWidget = new QuestWidget(this, null, "quest name", " sfdg"," sdge","3/10");
        //        LinearLayout linearLayout = findViewById(R.id.linearlayout);
        //        linearLayout.addView(questWidget);
        activeQuests = ActiveQuests.getInstance().getQuestList();

        for (Quest quest: activeQuests){
            QuestWidget questWidget = new QuestWidget(this, quest);
            questsLinearLayout.addView(questWidget);
        }


    }


}