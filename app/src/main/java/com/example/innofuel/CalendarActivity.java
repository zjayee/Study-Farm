package com.example.innofuel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CalendarActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        setupNavigationView();
    }

    @Override
    int getLayoutId() {
        return R.layout.activity_calendar;
    }

    @Override
    int getBottomNavigationMenuItemId() {
        return R.id.calendar;
    }
}