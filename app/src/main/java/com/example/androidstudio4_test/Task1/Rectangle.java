package com.example.androidstudio4_test.Task1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by pixel-hunter on 13.07.2020.
 */

public class Rectangle extends Square {
    private int height;

    public Rectangle(Point mCurrentPoint, int width, int height) {
        super(mCurrentPoint, width);
        this.height = height;
    }

    @Override
    public void changeColor(int newColor) {
        mColor=newColor;
    }

    @Override
    public void draw(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(mColor);
        canvas.drawRect(new Rect(
                getCurrentPoint().getX(),
                getCurrentPoint().getY(),
                getCurrentPoint().getX() + getWidth(),
                getCurrentPoint().getY() + height
        ), p);
    }
}
