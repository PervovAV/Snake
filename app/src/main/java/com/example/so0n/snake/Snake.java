package com.example.so0n.snake;

import android.graphics.Point;
import java.util.ArrayList;

/**
 * Created by So0n on 29.01.2018.
 */

public class Snake {
    private ArrayList<Point> bodySnake;
    private int vector = 0;

    public void move() {
        //0 - stop
        //1 - left
        //2 - front
        //3 - right
        //4 - back

        switch (vector) {
            case 0:

                break;
            case 1:
                if (bodySnake.size() == 1) {
                    bodySnake.get(0).offset(-1, 0);
                } else {
                    changeRingIndex();
                    bodySnake.get(bodySnake.size() - 1).offset(-1, 0);
                }
                break;
            case 2:
                if (bodySnake.size() == 1) {
                    bodySnake.get(0).offset(0, 1);
                } else {
                    changeRingIndex();
                    bodySnake.get(bodySnake.size() - 1).offset(0, 1);
                }
                break;
            case 3:
                if (bodySnake.size() == 1) {
                    bodySnake.get(0).offset(1, 0);
                } else {
                    changeRingIndex();
                    bodySnake.get(bodySnake.size() - 1).offset(1, 0);
                }
                break;
            case 4:
                if (bodySnake.size() == 1) {
                    bodySnake.get(0).offset(0, -1);
                } else {
                    changeRingIndex();
                    bodySnake.get(bodySnake.size() - 1).offset(0, -1);
                }
                break;
        }
    }

    public void setVector(int vector) {
        if (vector > 4 || vector <=0) return;
        else
            this.vector = vector;
    }

    public ArrayList<Point> getBodySnake() {
        return bodySnake;
    }

    private void changeRingIndex() {
        for (int i = 0; i <= bodySnake.size() - 2; i++) {
            bodySnake.set(i, bodySnake.get(i+1));
        }
    }
}
