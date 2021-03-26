package com.example.innofuel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

//        QuestWidget questWidget = new QuestWidget(this, null, "quest name", " sfdg"," sdge","3/10");
//        LinearLayout linearLayout = findViewById(R.id.linearlayout);
//        linearLayout.addView(questWidget);


    }

    @Override
    int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    int getBottomNavigationMenuItemId() {
        return R.id.home;
    }
}