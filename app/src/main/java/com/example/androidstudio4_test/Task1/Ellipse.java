package com.example.androidstudio4_test.Task1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by pixel-hunter on 13.07.2020.
 */

public class Ellipse extends Circle {
    int radius2;

    public Ellipse(Point p, int radius, int radius2) {
        super(p, radius);
        this.radius2=radius2;
    }

    public int getRadius2() {
        return radius2;
    }

    @Override
    public void draw(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(mColor);

        canvas.drawOval(getCurrentPoint().getX(),
                        getCurrentPoint().getY(),
                  getCurrentPoint().getX() + getRadius(),
                getCurrentPoint().getX() + getRadius2(), p);
        //canvas.drawOval(400,100,40,400,p);
    }
}
