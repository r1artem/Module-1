package com.example.androidstudio4_test.Task1.Motion;

import com.example.androidstudio4_test.Task1.Figure;

import java.util.Map;

/**
 * Created by pixel-hunter on 18.07.2020.
 */

public class MotionManager {

    public float DEFAULT_DT=0.1f;

    private float dt=DEFAULT_DT;
    private float t;
    private Map<Figure, BaseMotion> map;

    public float getDt() {
        return dt;
    }

    public void setDt(float dt) {
        this.dt = dt;
    }

    public MotionManager(Map<Figure, BaseMotion> map) {
        this.map=map;
    }

    public void NextIteration(){
        for(Map.Entry<Figure, BaseMotion> item : map.entrySet()){
            Figure tempFigure= item.getKey();
            BaseMotion tempMotion= item.getValue();
            tempFigure.moveTo(tempMotion.getNextPoint(t));
        }
        t+=dt;
    }
}
