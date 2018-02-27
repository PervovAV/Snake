package com.example.so0n.snake;

import android.view.MotionEvent;
import android.view.View;

public class InputService implements View.OnTouchListener {
    private InputListener inputListener;
    private int width;
    private int height;

    public InputService(int width, int height, View view) {
        this.width = width;
        this.height = height;
        view.setOnTouchListener(this);
    }

    public void setInputListener(InputListener inputListener) {
        this.inputListener = inputListener;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getY() < height/3) {
            inputListener.onKeyPressed(1);
        }
        if (event.getY() > height/3 && event.getY() < height*2/3 && event.getX() < width/2) {
            inputListener.onKeyPressed(4);
        }
        if (event.getY() > height/3 && event.getY() < height*2/3 && event.getX() > width/2) {
            inputListener.onKeyPressed(2);
        }
        if (event.getY() > height*2/3) {
            inputListener.onKeyPressed(3);
        }
        return false;
    }
}
