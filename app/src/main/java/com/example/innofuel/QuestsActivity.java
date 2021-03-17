package com.example.innofuel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class QuestsActivity extends AppCompatActivity {

    FloatingActionButton addTaskButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quests);

        setupViews();
        setupAddTaskButton();



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