package com.example.androidstudio4_test.Task1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by pixel-hunter on 13.07.2020.
 */

public class Square extends Figure implements ColorChangeable {
    private int width;

    public int getWidth() {
        return width;
    }

    public Square(Point mCurrentPoint, int width) {
        super(mCurrentPoint);
        this.width = width;
    }


    @Override
    public void changeColor(int newColor) {
        mColor = newColor;
    }


    @Override
    public void draw(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(mColor);
        canvas.drawRect(new Rect(
                getCurrentPoint().getX(),
                getCurrentPoint().getY(),
                getCurrentPoint().getX() + width,
                getCurrentPoint().getY() + width
        ), p);
    }
}
