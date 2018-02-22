package com.example.so0n.snake;
import android.graphics.Point;


public class Apple {
    private Point locationApple;

    public Apple(int x, int y) {
        locationApple = new Point(x, y);
    }

    public Point getLocationApple() {
        return locationApple;
    }
}
