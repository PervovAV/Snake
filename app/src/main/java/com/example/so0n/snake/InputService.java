package com.example.so0n.snake;

import android.view.MotionEvent;
import android.view.View;

public class InputService implements View.OnTouchListener {
    private boolean[] routs = {false, false, false, false};

    public boolean[] getRouts() {
        return routs;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
