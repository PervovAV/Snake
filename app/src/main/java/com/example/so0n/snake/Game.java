package com.example.so0n.snake;

/**
 * Created by So0n on 29.01.2018.
 */

public class Game {
    private Field field;
    private Snake snake;
    private Apple apple;

    public void startGame() {
        field = new Field();
        snake = new Snake();
        apple = new Apple();

        while (!isGameEnd()) {

        }
    }

    private boolean isGameEnd() {
        if () {
            return true;
        } else
            return false;
    }
}
