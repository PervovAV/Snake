package com.example.so0n.snake;

public class TestActivityDraw {
    private FieldRenderer fieldRenderer;
    private int[][] mas = new int[12][12];

    private void initializationMas() {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                mas[i][j] = 0;
            }
        }
        mas[0][0] = 1;
        mas[6][6] = 2;
        mas[11][11] = 1;
    }

    public TestActivityDraw(FieldRenderer fieldRenderer) {
        this.fieldRenderer = fieldRenderer;
    }

    public void start() {
        initializationMas();
        fieldRenderer.drawField(mas);
    }
}
