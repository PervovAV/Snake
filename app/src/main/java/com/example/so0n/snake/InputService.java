package com.example.so0n.snake;

import android.view.MotionEvent;
import android.view.View;

public class InputService implements View.OnTouchListener {
    private InputListener inputListener;

    public InputService(View view) {
        view.setOnTouchListener(this);
    }

    public void setInputListener(InputListener inputListener) {
        this.inputListener = inputListener;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getY() < 640) {
            inputListener.onKeyPressed(1);
        }
        if (event.getY() > 640 && event.getY() < 1280 && event.getX() < 540) {
            inputListener.onKeyPressed(4);
        }
        if (event.getY() > 640 && event.getY() < 1280 && event.getX() > 540) {
            inputListener.onKeyPressed(2);
        }
        if (event.getY() > 1280) {
            inputListener.onKeyPressed(3);
        }
        return false;
    }
}
