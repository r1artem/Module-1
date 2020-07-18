package com.example.androidstudio4_test.Task1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.util.ArrayMap;
import android.view.View;

import com.example.androidstudio4_test.Task1.Motion.BaseMotion;
import com.example.androidstudio4_test.Task1.Motion.CircularMotion;
import com.example.androidstudio4_test.Task1.Motion.MotionManager;
import com.example.androidstudio4_test.Task1.Motion.NoMotion;
import com.example.androidstudio4_test.Task1.Motion.SmoothXAxisLinearMotion;
import com.example.androidstudio4_test.Task1.Motion.SmoothYAxisLinearMotion;

import java.util.Map;

import androidx.annotation.NonNull;

/**
 * Created by pixel-hunter on 18.07.2020.
 */

public class DrawView extends View {
    /*square.moveTo(new Point(x,y));
                        x+=10;*/
    Handler invalidateHandler = new Handler();
    MotionManager motionManager;
    Map<Figure, BaseMotion> map_;


    public DrawView(Context context) {
        super(context);
        map_ = getDemoMap();
        motionManager = new MotionManager(map_);

        invalidateHandler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                invalidate();
            }
        };

        getUpdateThread().start();


    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);

        for (Map.Entry<Figure, BaseMotion> item : map_.entrySet()) {
            item.getKey().draw(canvas);
        }
    }

    private Map<Figure, BaseMotion> getDemoMap() {

        Map<Figure, BaseMotion> map = new ArrayMap<>();

        map.put(new Rectangle(new Point(400, 100), 300, 100),
                new NoMotion(new Point(400, 100)));

        map.put(new Rectangle(new Point(100, 500), 100, 100),
                new SmoothXAxisLinearMotion(new Point(100, 100)));

        for (int i = 0; i < 15; i++) {
            int width = 40;
            Square tempSquare = new Square(new Point(0, width * i), width);
            BaseMotion tempMotion =
                    new SmoothXAxisLinearMotion(tempSquare.getCurrentPoint(),
                            0.5f, 450, i * 0.1f, 450);
            map.put(tempSquare, tempMotion);
        }

        for (int j = 0; j < 15; j++) {
            int radius = 40;
            Figure tempSquare = new Circle(new Point(radius * j, 300), radius);
            BaseMotion tempMotion =
                    new SmoothYAxisLinearMotion(tempSquare.getCurrentPoint(),
                            0.5f, 450, j * 0.1f, 450);
            map.put(tempSquare, tempMotion);
        }

        map.put(
                new Rectangle(new Point(250, 250), 250, 400),
                new CircularMotion(new Point(400, 950), 250, 1.5f));

        map.put(new Ellipse(new Point(450, 500), 100, 200),
                new NoMotion(new Point(450, 500)));
        return map;
    }

    private Thread getUpdateThread() {
        Thread thread = new Thread(
                new Runnable() {

                    double t = 0;

                    @Override
                    public void run() {
                        while (true) {
                            invalidateHandler.sendEmptyMessage(123);
                            motionManager.NextIteration();
                            int i = 0;

                            /*just for colour update*/
                            for (Map.Entry<Figure, BaseMotion> item : map_.entrySet()) {
                                if (item.getKey() instanceof ColorChangeable && i%2== 0) {
                                    ColorChangeable tempColChangeable = (ColorChangeable) item.getKey();
                                    tempColChangeable.changeColor(
                                            Color.rgb(
                                                    (int) (Math.sin(2 * t * 0.01 + i * 0.01) * 100 + 127),
                                                    (int) (Math.cos(3 * t * 0.01 + i * 0.01) * 100 + 127),
                                                    (int) (Math.cos(4 * t * 0.01 + i * 0.01) + Math.sin(5 * t * 0.01) * 100 + 127))
                                    );
                                } else if ((item.getKey() instanceof ColorChangeable)) {
                                    ColorChangeable tempColChangeable = (ColorChangeable) item.getKey();
                                    tempColChangeable.changeColor(
                                            Color.rgb(
                                                    (int) (Math.sin(t) * 100 + 127),
                                                    (int) (Math.cos(t * 0.25 + Math.PI / 2) * 100 + 127),
                                                    0));
                                }
                                i += 1;
                            }
                            try {
                                Thread.sleep(20);
                                t += 0.1;
                            } catch (InterruptedException e) {
                                break;
                            }
                        }
                    }
                });
        return thread;
    }
}
