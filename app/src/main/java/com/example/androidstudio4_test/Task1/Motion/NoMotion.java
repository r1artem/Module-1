package com.example.androidstudio4_test.Task1.Motion;

import com.example.androidstudio4_test.Task1.Point;

/**
 * Created by pixel-hunter on 18.07.2020.
 */

public class NoMotion extends BaseMotion {
    public NoMotion(Point startPoint) {
        super(startPoint);
    }
    public NoMotion(){
        super(new Point(0,0));
    }
    @Override
    public Point getNextPoint(float t) {
        return startPoint;
    }
}
