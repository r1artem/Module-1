package com.example.androidstudio4_test.Task1;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by pixel-hunter on 13.07.2020.
 */

public class Circle extends Figure{
    private int radius;

    public int getRadius() {
        return radius;
    }

    public Circle(Point p, int radius) {
        super(p);
        this.radius = radius;
    }

    @Override
    public void draw(Canvas canvas) {
        Paint p=new Paint();
        p.setColor(mColor);
        canvas.drawCircle(getCurrentPoint().getX(),getCurrentPoint().getY(),radius,p);
    }
}
