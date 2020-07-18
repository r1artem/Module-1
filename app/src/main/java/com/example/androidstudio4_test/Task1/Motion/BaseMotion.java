package com.example.androidstudio4_test.Task1.Motion;

import com.example.androidstudio4_test.Task1.Point;

/**
 * Created by pixel-hunter on 18.07.2020.
 */

public abstract class BaseMotion {
    protected Point startPoint;

    public BaseMotion(Point startPoint) {
        this.startPoint = startPoint;
    }

    public abstract Point getNextPoint(float t);
}
