package com.example.androidstudio4_test.Task1;

import android.graphics.Canvas;
import android.graphics.Color;

/**
 * Created by pixel-hunter on 13.07.2020.
 */

public abstract class Figure {
    private Point mCurrentPoint;
    protected int mColor=Color.rgb(64,64,64);

    public int getColor() {
        return mColor;
    }

    public Point getCurrentPoint() {
        return mCurrentPoint;
    }

    public Figure(Point mCurrentPoint) {
        this.mCurrentPoint = mCurrentPoint;
    }

    public void moveTo(Point p) {
        mCurrentPoint = p;
    }

    public abstract void draw(Canvas canvas);
}
