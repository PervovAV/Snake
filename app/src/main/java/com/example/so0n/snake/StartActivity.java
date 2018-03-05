package com.example.so0n.snake;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {
    final int REQUEST_CODE_SETTINGS = 1;

    private Settings settings;
    private Button btnStartGame;
    private Button btnOptions;
    private Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_start);

        settings = new Settings();
        settings.setSpeed(Settings.EASY_SPEED);
        btnStartGame = (Button) findViewById(R.id.btnStartGame);
        btnOptions = (Button) findViewById(R.id.btnOptions);
        btnExit = (Button) findViewById(R.id.btnExit);

        btnStartGame.setOnClickListener(this);
        btnOptions.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnStartGame:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("settings", settings.getSpeed());
                startActivity(intent);
                break;
            case R.id.btnOptions:
                intent = new Intent(this, OptionsActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SETTINGS);
                break;
            case R.id.btnExit:
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_SETTINGS:
                    double speed = data.getDoubleExtra("settings", Settings.EASY_SPEED);
                    settings.setSpeed(speed);
                    break;
            }
        }
    }
}
