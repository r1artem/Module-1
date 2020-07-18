package com.example.androidstudio4_test.Task1.Motion;

import com.example.androidstudio4_test.Task1.Point;

/**
 * Created by pixel-hunter on 18.07.2020.
 */

public class SmoothYAxisLinearMotion extends SmoothLinearMotion {
    public SmoothYAxisLinearMotion(Point startPoint) {
        super(startPoint);
    }

    public SmoothYAxisLinearMotion(Point startPoint, float frequency, float amplitude, float phaseShift, float offset) {
        super(startPoint, frequency, amplitude, phaseShift, offset);
    }

    @Override
    public Point getNextPoint(float t) {
        int y = (int) (int) (Math.sin(t * frequency + phaseShift) * amplitude + offset);
        return new Point(this.startPoint.getX(), y);
    }
}
