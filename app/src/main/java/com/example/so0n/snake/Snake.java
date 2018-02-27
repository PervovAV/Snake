package com.example.so0n.snake;

import android.graphics.Point;
import java.util.ArrayList;

public class Snake {
    public Snake() {
        bodySnake.add(new Point(0, 0));
    }

    private ArrayList<Point> bodySnake = new ArrayList<>();
    private double speed = 0.0025;
    private int route = 2;
    private int nextRoute = route;

    public synchronized void move() {
        //1 - up
        //2 - right
        //3 - down
        //4 - left

        switch (nextRoute) {
            case 1:
                if (bodySnake.size() == 1) {
                    bodySnake.get(0).offset(-1, 0);
                } else {
                    changeRingIndex();
                    createHead(-1, 0);
                }
                break;
            case 2:
                if (bodySnake.size() == 1) {
                    bodySnake.get(0).offset(0, 1);
                } else {
                    changeRingIndex();
                    createHead(0, 1);

                }
                break;
            case 3:
                if (bodySnake.size() == 1) {
                    bodySnake.get(0).offset(1, 0);
                } else {
                    changeRingIndex();
                    createHead(1, 0);
                }
                break;
            case 4:
                if (bodySnake.size() == 1) {
                    bodySnake.get(0).offset(0, -1);
                } else {
                    changeRingIndex();
                    createHead(0, -1);
                }
                break;
        }
        route = nextRoute;
    }

    public synchronized void grow(Point backSnake) {
        bodySnake.add(0, backSnake);
    }

    public synchronized void setRoute(int route) {
        if (isProper(route)) {
            this.nextRoute = route;
        }
    }

    private boolean isProper(int route) {
        if (route > 4 || route <=0) return false;
        if ((this.route == 1) && (route == 3)){
            return false;
        }
        if ((this.route == 2) && (route == 4)){
            return false;
        }
        if ((this.route == 3) && (route == 1)){
            return false;
        }
        if ((this.route == 4) && (route == 2)){
            return false;
        } else
            return true;
    }

    public double getSpeed() {
        return speed;
    }

    public ArrayList<Point> getBodySnake() {
        return bodySnake;
    }

    public void changeRingIndex() {
        for (int i = 0; i < bodySnake.size() - 1; i++) {
            bodySnake.set(i, bodySnake.get(i+1));
        }
    }

    private void createHead(int x, int y) {
        bodySnake.remove(bodySnake.size() - 1);
        Point tmpPoint = new Point(bodySnake.get(bodySnake.size()-1).x , bodySnake.get(bodySnake.size()-1).y);
        tmpPoint.offset(x, y);
        bodySnake.add(tmpPoint);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Point point : bodySnake) {
            sb.append(point.toString());
        }
        return sb.toString();
    }

    public boolean eatsItself() {
        if (bodySnake.size() < 3) {
            return false;
        } else {
            for (int i = 0; i < bodySnake.size() - 1; i++) {
                if (bodySnake.get(bodySnake.size() - 1).equals(bodySnake.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}

