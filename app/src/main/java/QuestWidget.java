import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.innofuel.R;



public class QuestWidget extends LinearLayout implements View.OnClickListener
{


    public QuestWidget(Context context, @Nullable AttributeSet attrs, String questName, String questDescription, String questRewards, String completion) {
        super(context, attrs);

        //inflate layout
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.quest_widget,this, true);

        TextView questNameTextview = findViewById(R.id.questName);
        TextView questDescriptionTextview = findViewById(R.id.questDescription);
        TextView questRewardsTextview = findViewById(R.id.rewardsText);
        TextView completionTextview = findViewById(R.id.completionText);

        questNameTextview.setText(questName);
        questDescriptionTextview.setText(questDescription);
        questRewardsTextview.setText(questRewards);
        completionTextview.setText(completion);

        
    }

    @Override
    public void onClick(View v) {

    }
}
