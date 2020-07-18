package com.example.androidstudio4_test;

import android.os.Bundle;

import com.example.androidstudio4_test.Task1.DrawView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DrawView t = new DrawView(this);
        setContentView(t);

    }

}