import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.innofuel.R;

public class QuestWidget extends LinearLayout implements View.OnClickListener
{

    public QuestWidget(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.quest_widget,this, true);

        


    }

    @Override
    public void onClick(View v) {

    }
}
