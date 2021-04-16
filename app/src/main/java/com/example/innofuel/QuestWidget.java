package com.example.innofuel;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;





public class QuestWidget extends LinearLayout implements View.OnClickListener
{

    CardView rewardsCard;
    CardView taskCard;

    public QuestWidget(Context context, @Nullable AttributeSet attrs, Quest quest) {
        super(context, attrs);

        //inflate layout
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.quest_widget,this, true);

        TextView questNameTextview = findViewById(R.id.questName);
        TextView questDescriptionTextview = findViewById(R.id.questDescription);
        TextView questRewardsTextview = findViewById(R.id.rewardsText);
        TextView completionTextview = findViewById(R.id.completionText);

        String questName = quest.getName();
        String questDescription = quest.getDetails();
        String questRewards = quest.getRewardString();
        String completion = quest.getCompletion();

        questNameTextview.setText(questName);
        questDescriptionTextview.setText(questDescription);
        questRewardsTextview.setText(questRewards);
        completionTextview.setText(completion);

        rewardsCard = findViewById(R.id.rewardsCard);
        //set as invisible
        rewardsCard.setVisibility(GONE);

        taskCard = findViewById(R.id.taskCard);


        taskCard.setOnClickListener(v -> {

            if (rewardsCard.getVisibility()==GONE){
                rewardsCard.setVisibility(VISIBLE);
            }else if(rewardsCard.getVisibility()==VISIBLE){
                rewardsCard.setVisibility(GONE);
            }
            System.out.println("clicked reward");

        });

    }

    @Override
    public void onClick(View v) {



    }



}
