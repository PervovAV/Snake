package com.example.so0n.snake;

public class Settings {
    public static final double EASY_SPEED = 0.0025;
    public static final double NORMAL_SPEED = 0.0032;
    public static final double HARD_SPEED = 0.0039;
    private static double speed = 0;

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }
}
