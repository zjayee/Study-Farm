package com.example.innofuel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RewardsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_rewards);
    }

    @Override
    int getLayoutId() {
        return R.layout.activity_rewards;
    }

    @Override
    int getBottomNavigationMenuItemId() {
        return R.id.rewards;
    }
}