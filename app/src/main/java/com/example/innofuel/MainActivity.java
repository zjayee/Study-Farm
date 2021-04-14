package com.example.innofuel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

public class MainActivity extends BaseActivity{

    //Views

    TextView quoteTextview;
    TextView quoteSourceTextview;
    TextView dateDayTextview;
    TextView dateMonthYearTextview;
    TextView dateWeekdayTextview;
    Button reflectButton;
    ImageButton thumbsupButton;
    MaterialCalendarView calendarView;
    CardView calendarCard;
    TextView quest1NameTextview;
    TextView quest1DescriptionTextview;
    TextView quest1CompletionTextview;
    TextView quest2NameTextview;
    TextView quest2DescriptionTextview;
    TextView quest2CompletionTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//       setContentView(R.layout.activity_main);

//        QuestWidget questWidget = new QuestWidget(this, null, "quest name", " sfdg"," sdge","3/10");
//        LinearLayout linearLayout = findViewById(R.id.linearlayout);
//        linearLayout.addView(questWidget);

        setupViews();



    }


    void setupViews(){
        quoteTextview = findViewById(R.id.quoteTextview);
        quoteSourceTextview = findViewById(R.id.quoteSourceTextview);
        dateDayTextview = findViewById(R.id.dateDayTextview);
        dateMonthYearTextview = findViewById(R.id.dateMonthYearTextview);
        dateWeekdayTextview = findViewById(R.id.dateWeekdayTextview);
        reflectButton = findViewById(R.id.reflectButton);
        thumbsupButton = findViewById(R.id.thumbsupButton);
        calendarView = findViewById(R.id.calendarView);
        calendarCard = findViewById(R.id.calendarCard);
        quest1NameTextview = findViewById(R.id.quest1NameTextview);
        quest1DescriptionTextview = findViewById(R.id.quest1DescriptionTextview);
        quest1CompletionTextview = findViewById(R.id.quest1CompletionTextview);
        quest2NameTextview = findViewById(R.id.quest2NameTextview);
        quest2DescriptionTextview = findViewById(R.id.quest2DescriptionTextview);
        quest2CompletionTextview = findViewById(R.id.quest2CompletionTextview);
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