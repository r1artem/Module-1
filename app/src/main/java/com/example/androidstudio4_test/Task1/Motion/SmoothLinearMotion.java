package com.example.androidstudio4_test.Task1.Motion;

import com.example.androidstudio4_test.Task1.Point;

/**
 * Created by pixel-hunter on 18.07.2020.
 */

public abstract class SmoothLinearMotion extends BaseMotion {
    public float DEFAULT_FREQUENCY=0.1f;
    public float DEFAULT_AMPLITUDE=40f;


    protected float phaseShift;
    protected float frequency;
    protected float amplitude;
    protected float offset;

    public SmoothLinearMotion(Point startPoint) {
        super(startPoint);
        this.phaseShift=0;
        this.frequency=DEFAULT_FREQUENCY;
        this.amplitude=DEFAULT_AMPLITUDE;
        this.offset=DEFAULT_AMPLITUDE;
    }

    public SmoothLinearMotion(Point startPoint, float frequency, float amplitude, float phaseShift, float offset) {
        super(startPoint);
        this.phaseShift = phaseShift;
        this.frequency = frequency;
        this.amplitude = amplitude;
        this.offset=offset;
    }

    @Override
    public abstract Point getNextPoint(float t);
}
