package com.example.so0n.snake;
import android.graphics.Point;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;


public class GameSnake implements InputListener {
    Thread gameThread;
    public final static int FIELD_SIDE_M = 16;
    public final static int FIELD_SIDE_N = 9;
    private Snake snake;
    private Apple apple;
    private AppleGenerator appleGenerator;
    private Field field;
    private FieldRenderer fieldRenderer;
    private AtomicBoolean active = new AtomicBoolean(false);

    public GameSnake(InputService inputService, FieldRenderer fieldRenderer) {
        inputService.setInputListener(this);
        this.fieldRenderer = fieldRenderer;
    }

    public void startGame() throws InterruptedException {
        gameThread = new Thread(new Runnable() {
            @Override
            public void run() {
                snake = new Snake();
                appleGenerator = new AppleGenerator();
                field = new Field(FIELD_SIDE_M, FIELD_SIDE_N);
                apple = appleGenerator.generate(field);
                active.set(true);

                while (!isGameEnd() && active.get()) {
                    field.addBodySnakeApple(snake.getBodySnake(), apple.getLocationApple());
                    fieldRenderer.drawField(field);
                    Long start = System.currentTimeMillis();
                    while (snake.getSpeed() * (System.currentTimeMillis() - start) < 1) {
                        Thread.yield();
                    }
                    snake.move();
                    Point backSnake = snake.getBodySnake().get(0);
                    if (snake.getBodySnake().get(snake.getBodySnake().size() - 1).equals(apple.getLocationApple())) {
                        snake.grow(backSnake);
                        apple = appleGenerator.generate(field);
                    }
                }
            }
        });
        gameThread.start();
    }

    public void stop() {
        active.set(false);
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean isGameEnd() {
        return ((snake.getBodySnake().get(snake.getBodySnake().size() - 1).x < 0) ||
                (snake.getBodySnake().get(snake.getBodySnake().size() - 1).x > FIELD_SIDE_M - 1) ||
                (snake.getBodySnake().get(snake.getBodySnake().size() - 1).y < 0) ||
                (snake.getBodySnake().get(snake.getBodySnake().size() - 1).y > FIELD_SIDE_N - 1) ||
                (snake.eatsItself()));
    }

    @Override
    public void onKeyPressed(int key) {
        snake.setRoute(key);
    }
}