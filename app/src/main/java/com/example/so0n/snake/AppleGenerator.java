package com.example.so0n.snake;
import java.util.ArrayList;
import java.util.Random;

public class AppleGenerator {
    public Apple generate(Field field) {
        ArrayList<Apple> arr = new ArrayList<>();
        int[][] mas = field.getFieldCoordinates();
        for (int i = 0; i < mas.length; i ++) {
            for (int j = 0; j < mas[0].length; j ++) {
                if (mas[i][j] == 0) {
                    arr.add(new Apple(i,j));
                }
            }
        }
        Random rn = new Random();
        int indexApple = rn.nextInt(arr.size());
        return arr.get(indexApple);
    }
}
