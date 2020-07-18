package com.example.androidstudio4_test.Task1.Motion;

import com.example.androidstudio4_test.Task1.Point;

/**
 * Created by pixel-hunter on 18.07.2020.
 */

public class SmoothXAxisLinearMotion extends SmoothLinearMotion {
    public SmoothXAxisLinearMotion(Point startPoint) {
        super(startPoint);
    }

    public SmoothXAxisLinearMotion(Point startPoint, float frequency, float amplitude, float phaseShift, float offset) {
        super(startPoint, frequency, amplitude, phaseShift, offset);
    }

    @Override
    public Point getNextPoint(float t) {
        int x = (int) (int) (Math.sin(t * frequency + phaseShift) * amplitude + offset);
        return new Point(x, this.startPoint.getY());
    }

}
