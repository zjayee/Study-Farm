package com.example.innofuel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CalendarActivity extends BaseActivity {

    RadioGroup selectedRadioGroup;
    RadioButton januaryButton;
    RadioButton febuaryButton;
    RadioButton marchButton;
    RadioButton aprilButton;
    RadioButton mayButton;
    RadioButton juneButton;
    RadioButton julyButton;
    RadioButton augustButton;
    RadioButton septemberButton;
    RadioButton octoberButton;
    RadioButton novemberButton;
    RadioButton decemberButton;

    Button january;
    Button febuary;
    Button march;
    Button april;
    Button may;
    Button june;
    Button july;
    Button august;
    Button september;
    Button october;
    Button november;
    Button december;

    MaterialCalendarView calendarView;
    LinearLayout eventsLinearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_calendar);

        setUpViews();



    }

    void refreshCalendarEvents(){
        //get tasks with due date in month
        //add tasks to linear layout
        //add decorator to dates with tasks

        //get tasks/events with date in month
        int currentMonth = calendarView.getCurrentDate().getMonth();
        int currentYear = calendarView.getCurrentDate().getYear();
        ArrayList<Task> tasksInMonth = ActiveTasks.getInstance().getTasksInMonth(currentMonth,currentYear);

        //add to linear layout
        eventsLinearLayout.removeAllViews();
        for (Task task: tasksInMonth){
            CalendarTaskWidget calendarTaskWidget = new CalendarTaskWidget(this, task);
            eventsLinearLayout.addView(calendarTaskWidget);

        }


    }

    void setUpViews() {
        selectedRadioGroup = findViewById(R.id.selectedRadioGroup);
        januaryButton = findViewById(R.id.januaryButton);
        febuaryButton = findViewById(R.id.febuaryButton);
        marchButton = findViewById(R.id.marchButton);
        aprilButton = findViewById(R.id.aprilButton);
        mayButton = findViewById(R.id.mayButton);
        juneButton = findViewById(R.id.juneButton);
        julyButton = findViewById(R.id.julyButton);
        augustButton = findViewById(R.id.augustButton);
        septemberButton = findViewById(R.id.septemberButton);
        octoberButton = findViewById(R.id.octoberButton);
        novemberButton = findViewById(R.id.novemberButton);
        decemberButton = findViewById(R.id.decemberButton);
        calendarView = findViewById(R.id.calendarView);

        january = findViewById(R.id.january);
        febuary = findViewById(R.id.febuary);
        march = findViewById(R.id.march);
        april = findViewById(R.id.april);
        may = findViewById(R.id.may);
        june = findViewById(R.id.june);
        july = findViewById(R.id.july);
        august = findViewById(R.id.august);
        september = findViewById(R.id.september);
        october = findViewById(R.id.october);
        november = findViewById(R.id.november);
        december = findViewById(R.id.december);

        eventsLinearLayout = findViewById(R.id.eventsLinearLayout);

        calendarView.setCurrentDate(CalendarDay.today());
        updateMonthsRadiobutton(calendarView.getCurrentDate().getDate());
        refreshCalendarEvents();

        calendarView.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
                updateMonthsRadiobutton(date.getDate());
                refreshCalendarEvents();
            }
        });

        CalendarDay today = CalendarDay.today();

        january.setOnClickListener(v -> {
            januaryButton.setChecked(true);
            CalendarDay date = CalendarDay.from(today.getYear(), 0, 1);
            calendarView.setCurrentDate(date);
        });

        febuary.setOnClickListener(v -> {
            febuaryButton.setChecked(true);
            CalendarDay date = CalendarDay.from(today.getYear(), 1, 1);
            calendarView.setCurrentDate(date);
        });

        march.setOnClickListener(v -> {
            marchButton.setChecked(true);
            CalendarDay date = CalendarDay.from(today.getYear(), 2, 1);
            calendarView.setCurrentDate(date);
        });

        april.setOnClickListener(v -> {
            aprilButton.setChecked(true);
            CalendarDay date = CalendarDay.from(today.getYear(), 3, 1);
            calendarView.setCurrentDate(date);
        });

        may.setOnClickListener(v -> {
            mayButton.setChecked(true);
            CalendarDay date = CalendarDay.from(today.getYear(), 4, 1);
            calendarView.setCurrentDate(date);
        });

        june.setOnClickListener(v -> {
            juneButton.setChecked(true);
            CalendarDay date = CalendarDay.from(today.getYear(), 5, 1);
            calendarView.setCurrentDate(date);
        });

        july.setOnClickListener(v -> {
            julyButton.setChecked(true);
            CalendarDay date = CalendarDay.from(today.getYear(), 6, 1);
            calendarView.setCurrentDate(date);
        });

        august.setOnClickListener(v -> {
            augustButton.setChecked(true);
            CalendarDay date = CalendarDay.from(today.getYear(), 7, 1);
            calendarView.setCurrentDate(date);
        });

        september.setOnClickListener(v -> {
            septemberButton.setChecked(true);
            CalendarDay date = CalendarDay.from(today.getYear(), 8, 1);
            calendarView.setCurrentDate(date);
        });

        october.setOnClickListener(v -> {
            octoberButton.setChecked(true);
            CalendarDay date = CalendarDay.from(today.getYear(), 9, 1);
            calendarView.setCurrentDate(date);
        });

        november.setOnClickListener(v -> {
            novemberButton.setChecked(true);
            CalendarDay date = CalendarDay.from(today.getYear(), 10, 1);
            calendarView.setCurrentDate(date);
        });

        december.setOnClickListener(v -> {
            decemberButton.setChecked(true);
            CalendarDay date = CalendarDay.from(today.getYear(), 11, 1);
            calendarView.setCurrentDate(date);
        });

    }

    void updateMonthsRadiobutton(Date date){


        int monthNumber  = Integer.parseInt((String)DateFormat.format("MM",  date));

        switch (monthNumber){
            case 1:
                januaryButton.setChecked(true);
                break;
            case 2:
                febuaryButton.setChecked(true);
                break;
            case 3:
                marchButton.setChecked(true);
                break;
            case 4:
                aprilButton.setChecked(true);
                break;
            case 5:
                mayButton.setChecked(true);
                break;
            case 6:
                juneButton.setChecked(true);
                break;
            case 7:
                julyButton.setChecked(true);
                break;
            case 8:
                augustButton.setChecked(true);
                break;
            case 9:
                septemberButton.setChecked(true);
                break;
            case 10:
                octoberButton.setChecked(true);
                break;
            case 11:
                novemberButton.setChecked(true);
                break;
            case 12:
                decemberButton.setChecked(true);
                break;
        }

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