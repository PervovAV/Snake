package com.example.so0n.snake;
import android.graphics.Point;

import java.util.ArrayList;

public class Field {
    private int[][] fieldCoordinates;

    public Field (int m, int n) {
        fieldCoordinates = new int[m][n];
        clearField();
    }

    public void clearField() {
        for (int i = 0; i < fieldCoordinates.length; i++) {
            for (int j = 0; j < fieldCoordinates[i].length; j++) {
                fieldCoordinates[i][j] = 0;
            }
        }
    }

    public int[][] getFieldCoordinates() {
        return fieldCoordinates;
    }

    public void addBodySnakeApple(ArrayList<Point> arr, Point pointApple) {
        clearField();
        for (Point chain : arr) {
            fieldCoordinates[(int)chain.x][(int)chain.y] = 1;
        }
        fieldCoordinates[pointApple.x][pointApple.y] = 2;
    }
}
