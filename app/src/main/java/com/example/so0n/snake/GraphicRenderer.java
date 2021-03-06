package com.example.so0n.snake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;


public class GraphicRenderer extends View implements FieldRenderer {
    private final static int SIZE_COEFFICIENT = 9;
    private Bitmap bitmapApple;
    private Bitmap bitmapGrass;
    private Bitmap bitmapSnakeCell;
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
        bitmapApple = createCellBitmap(R.drawable.apple);
        bitmapGrass = createCellBitmap(R.drawable.grass);
        bitmapSnakeCell = createCellBitmap(R.drawable.snake_cell);
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

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSnakeAndApple(canvas);
    }

    private Bitmap createCellBitmap(int resourceID) {
        Bitmap resBitmap = BitmapFactory.decodeResource(getResources(), resourceID);
        return Bitmap.createScaledBitmap(resBitmap, step, step, false);
    }

    private synchronized void drawSnakeAndApple(Canvas canvas) {
        for (int i = 0; i < cells.length; i ++) {
            for (int j = 0; j < cells[i].length; j++) {
                canvas.drawBitmap(bitmapGrass, j * step, i * step, null);
                switch (cells[i][j]) {
                    case 1:
                        canvas.drawBitmap(bitmapSnakeCell, j * step, i * step, null);
                        break;
                    case 2:
                        canvas.drawBitmap(bitmapApple, j * step, i * step, null);
                        break;
                }
            }
        }
    }
}
