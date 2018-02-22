package com.example.so0n.snake;

import android.content.Context;
import android.util.Log;
import android.view.View;

public class TestActivity extends View implements InputListener {
    public TestActivity(Context context) {
        super(context);
    }

    @Override
    public void onKeyPressed(int key) {
        String message = String.valueOf(key);
        Log.d("MyLog", message);
    }
}
