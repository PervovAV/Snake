package com.example.so0n.snake;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

public class GameActivity extends AppCompatActivity {
    GraphicRenderer graphicRenderer;
    InputService inputService;
    GameSnake gameSnake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();

        graphicRenderer = new GraphicRenderer(this, GameSnake.FIELD_SIDE_M, GameSnake.FIELD_SIDE_N, width, height);
        inputService = new InputService(width, height, graphicRenderer);
        gameSnake = new GameSnake(inputService, graphicRenderer);
        gameSnake.setGameEndHandler(new GameEndHandler() {
            @Override
            public void onGameEnd() {
                callEndActivity();
            }
        });
        setContentView(graphicRenderer);
        try {
            gameSnake.startGame();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        gameSnake.stop();
    }

    private void callEndActivity() {
        Intent intent = new Intent(this, EndActivity.class);
        startActivity(intent);
    }
}