package com.example.so0n.snake;

import android.graphics.Point;

public class Apple {
    private Point appleLocation = new Point(10, 10);

    public void setAppleLocation(int x, int y) {
        appleLocation.set(x, y);
    }

    public Point getAppleLocation() {
        return appleLocation;
    }
}
