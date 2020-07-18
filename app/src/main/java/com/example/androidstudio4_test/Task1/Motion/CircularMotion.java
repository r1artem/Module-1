package com.example.androidstudio4_test.Task1.Motion;

import com.example.androidstudio4_test.Task1.Point;

/**
 * Created by pixel-hunter on 18.07.2020.
 */

public class CircularMotion extends BaseMotion {
    private int radius;
    private float speed;

    public CircularMotion(Point startPoint, int radius, float speed) {
        super(startPoint);
        this.radius = radius;
        this.speed = speed;
    }

    @Override
    public Point getNextPoint(float t) {
        int x = (int) (radius * Math.cos(t * speed)) + startPoint.getX();
        int y = (int) (radius * Math.sin(t * speed)) + startPoint.getY();
        return new Point(x, y);
    }
}
