package com.example.so0n.snake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;


public class GraphicRenderer extends View implements FieldRenderer {
    private final static int SIZE_COEFFICIENT = 9;

    private Bitmap bitmap;
    private Paint paint = new Paint();

    private int width;
    private int height;

    private int step;
    private int[][] cells;


    public GraphicRenderer(Context context, int fieldSide_M, int fieldSide_N, int width, int height) {
        super(context);
        this.width = width;
        this.height = height;
        cells = new int[fieldSide_M][fieldSide_N];
        step = width/SIZE_COEFFICIENT;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBackGround(canvas);
        drawSnakeAndApple(canvas);
    }

    private void drawBitmap(Canvas canvas, int x, int y, int color) {
        bitmap = Bitmap.createBitmap(step, step, Bitmap.Config.ARGB_8888);
        paint.setColor(Color.GREEN);
        bitmap.eraseColor(color);
        canvas.drawBitmap(bitmap, x, y, paint);
    }

    private void drawBackGround(Canvas canvas) {
        canvas.drawColor(Color.BLUE);

/*        Rect rect = new Rect();
        rect.set(0, width, width, height);
        paint.setColor(Color.BLACK);
        canvas.drawRect(rect, paint);*/
    }

    private synchronized void drawSnakeAndApple(Canvas canvas) {
        for (int i = 0; i < cells.length; i ++) {
            for (int j = 0; j < cells[i].length; j++) {
                switch (cells[i][j]) {
                    case 1:
                        drawBitmap(canvas, j * step, i * step, Color.WHITE);
                        break;
                    case 2:
                        drawBitmap(canvas, j * step, i * step, Color.GREEN);
                        break;
                }
            }
        }

    }

    @Override
    public synchronized void drawField(Field field) {
        for (int i = 0; i < field.getFieldCoordinates().length; i++) {
            for (int j = 0; j < field.getFieldCoordinates()[i].length; j++) {
                cells[i][j] = field.getFieldCoordinates()[i][j];
            }
        }
        postInvalidate();
    }
}
