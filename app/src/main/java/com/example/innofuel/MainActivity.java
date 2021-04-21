package com.example.innofuel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends BaseActivity{

    //Views

    TextView quoteTextview;
    TextView quoteSourceTextview;
    TextView dateDayTextview;
    TextView dateMonthYearTextview;
    TextView dateWeekdayTextview;
    Button reflectButton;
    CardView reminderCard;
    TextView reminderDescriptionTextview;
    ImageButton thumbsupButton;
    MaterialCalendarView calendarView;
    CardView calendarCard;
    TextView quest1NameTextview;
    TextView quest1DescriptionTextview;
    TextView quest1CompletionTextview;
    TextView quest2NameTextview;
    TextView quest2DescriptionTextview;
    TextView quest2CompletionTextview;
    CardView questCard;

    //data
    int reminderIndex = 0;
    ArrayList<Task> tasks;
    ArrayList<Quest> quests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//       setContentView(R.layout.activity_main);



        setupViews();
        setupCalendarCard();
        setupQuestCard();
        setupDate();
        setupReminder();
        setupSuggestedQuests();

    }


    void setupViews(){
        quoteTextview = findViewById(R.id.quoteTextview);
        quoteSourceTextview = findViewById(R.id.quoteSourceTextview);
        dateDayTextview = findViewById(R.id.dateDayTextview);
        dateMonthYearTextview = findViewById(R.id.dateMonthYearTextview);
        dateWeekdayTextview = findViewById(R.id.dateWeekdayTextview);
        reflectButton = findViewById(R.id.reflectButton);
        reminderCard = findViewById(R.id.reminderCard);
        reminderDescriptionTextview = findViewById(R.id.reminderDescriptionTextview);
        thumbsupButton = findViewById(R.id.thumbsupButton);
        calendarView = findViewById(R.id.calendarView);
        calendarCard = findViewById(R.id.calendarCard);
        quest1NameTextview = findViewById(R.id.quest1NameTextview);
        quest1DescriptionTextview = findViewById(R.id.quest1DescriptionTextview);
        quest1CompletionTextview = findViewById(R.id.quest1CompletionTextview);
        quest2NameTextview = findViewById(R.id.quest2NameTextview);
        quest2DescriptionTextview = findViewById(R.id.quest2DescriptionTextview);
        quest2CompletionTextview = findViewById(R.id.quest2CompletionTextview);
        questCard = findViewById(R.id.questCard);
    }

    void setupCalendarCard(){
        calendarCard.setOnClickListener(v -> {

            Intent intent = new Intent(getBaseContext(), CalendarActivity.class);
            startActivity(intent);
        });
    }

    void setupQuestCard(){
        questCard.setOnClickListener(v ->{

            Intent intent = new Intent(getBaseContext(), TasksActivity.class);
            startActivity(intent);

        });

    }

    void setupDate(){
        Calendar calendar;
        SimpleDateFormat dateFormatd; // day
        SimpleDateFormat dateFormatmy; // month year
        String dated; //day
        String datemy; //month year

        calendar = Calendar.getInstance();
        dateFormatd = new SimpleDateFormat("dd");
        dateFormatmy = new SimpleDateFormat("MM/yyyy");

        //stores date in string
        dated = dateFormatd.format(calendar.getTime());
        datemy = dateFormatmy.format(calendar.getTime());

        //sets textview to date
        dateDayTextview.setText(dated);
        dateMonthYearTextview.setText(datemy);

        //set weekday
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch (day) {
            case Calendar.SUNDAY:
                dateWeekdayTextview.setText(R.string.sun);
                break;
            case Calendar.MONDAY:
                dateWeekdayTextview.setText(R.string.mon);
                break;
            case Calendar.TUESDAY:
                dateWeekdayTextview.setText(R.string.tue);
                break;
            case Calendar.WEDNESDAY:
                dateWeekdayTextview.setText(R.string.wed);
                break;
            case Calendar.THURSDAY:
                dateWeekdayTextview.setText(R.string.thu);
                break;
            case Calendar.FRIDAY:
                dateWeekdayTextview.setText(R.string.fri);
                break;
            case Calendar.SATURDAY:
                dateWeekdayTextview.setText(R.string.sat);
                break;
        }


    }

    void setupReminder(){
        tasks = ActiveTasks.getInstance().getTaskList();
        if(tasks.size()<1){
            reminderCard.setVisibility(View.GONE);
            return;
        }
        Task task = tasks.get(reminderIndex);
        String taskName = task.getName();

        Date dueDate = task.getDueDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String taskDueDate = dateFormat.format(dueDate);

        String taskDetails = taskName + ": " + taskDueDate;
        reminderDescriptionTextview.setText(taskDetails);

        thumbsupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissTask();
            }
        });
    }

    void refreshReminder(){
        Task task = tasks.get(reminderIndex);
        String taskName = task.getName();

        Date dueDate = task.getDueDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String taskDueDate = dateFormat.format(dueDate);

        String taskDetails = taskName + ": " + taskDueDate;
        reminderDescriptionTextview.setText(taskDetails);
    }

    void dismissTask(){
        //increment reminder index and refresh task
        if(reminderIndex<tasks.size()-1){
            reminderIndex++;
            refreshReminder();
        }else{
            //if no more tasks, dismiss card
            reminderCard.setVisibility(View.GONE);
        }
    }

    void setupSuggestedQuests(){
        quests = ActiveQuests.getQuestList();
        Quest quest1 = quests.get(0);
        Quest quest2 = quests.get(1);

        //get names
        String quest1name = quest1.getName();
        String quest2name = quest2.getName();
        //set name textview
        quest1NameTextview.setText(quest1name);
        quest2NameTextview.setText(quest2name);

        //get descriptions
        String quest1details = quest1.getDetails();
        String quest2details = quest2.getDetails();
        //set name textview
        quest2DescriptionTextview.setText(quest1details);
        quest2DescriptionTextview.setText(quest2details);

        //get completion
        String quest1completion = quest1.getCompletion();
        String quest2completion = quest2.getCompletion();
        //set completion
        quest1CompletionTextview.setText(quest1completion);
        quest2CompletionTextview.setText(quest2completion);

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