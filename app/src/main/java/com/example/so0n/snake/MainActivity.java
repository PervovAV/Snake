package com.example.so0n.snake;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
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

        graphicRenderer = new GraphicRenderer(this, GameSnake.FIELD_SIDE, width, height);
        inputService = new InputService(graphicRenderer);
        gameSnake = new GameSnake(inputService, graphicRenderer);
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
}
