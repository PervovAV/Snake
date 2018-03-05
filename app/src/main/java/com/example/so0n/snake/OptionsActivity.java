package com.example.so0n.snake;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;

public class OptionsActivity extends AppCompatActivity {
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_options);
        rg = (RadioGroup) findViewById(R.id.rgDifficult);
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        switch (rg.getCheckedRadioButtonId()) {
            case R.id.rbEasy:
                intent.putExtra("settings", Settings.EASY_SPEED);
                break;
            case R.id.rbNormal:
                intent.putExtra("settings", Settings.NORMAL_SPEED);
                break;
            case R.id.rbHard:
                intent.putExtra("settings", Settings.HARD_SPEED);
                break;
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}
