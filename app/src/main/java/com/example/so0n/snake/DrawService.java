package com.example.so0n.snake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import android.view.View;


public class DrawService extends View {

    private Bitmap bitmap;
    private Paint paint = new Paint();

    private int width;
    private int height;


    public DrawService(Context context, int width, int height) {
        super(context);
        this.width = width;
        this.height = height;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);




        Rect rect = new Rect();
        rect.set(0, width, width, height);
        paint.setColor(Color.BLACK);
        canvas.drawRect(rect, paint);

        String message = width + " x " + height;
        Log.d("MyLog", message);
    }

    public void drawBitmap(Canvas canvas, int x, int y) {
        int step = width/12;
        bitmap = Bitmap.createBitmap(step, step, Bitmap.Config.ARGB_8888);
        paint.setColor(Color.GREEN);
        bitmap.eraseColor(Color.WHITE);
        canvas.drawBitmap(bitmap, 0, 0, paint);
    }
}
