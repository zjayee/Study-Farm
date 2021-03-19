package com.example.innofuel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TasksActivity extends BaseActivity {

    FloatingActionButton addTaskButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        setupViews();
        setupAddTaskButton();



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


    }

    void setupAddTaskButton(){
        addTaskButton.setOnClickListener(v ->{
            //TODO: go to add task page

        } );

    }


}