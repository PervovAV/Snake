package com.example.so0n.snake;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

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

        Field field = new Field(width, height);

//        setContentView(new GraphicRenderer(this, width, height));




/*        TestActivity testActivity = new TestActivity(this);
        InputService inputService = new InputService(testActivity);
        inputService.setInputListener(testActivity);
        setContentView(testActivity);*/


        GraphicRenderer graphicRenderer = new GraphicRenderer(this, width, height);
        TestActivityDraw testActivityDraw = new TestActivityDraw(graphicRenderer);
        setContentView(graphicRenderer);
        testActivityDraw.start();
    }
}
