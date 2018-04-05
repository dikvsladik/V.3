package com.example.ptmi.spaceship;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;


import com.example.ptmi.spaceship.entity.Ship;

import static android.content.ContentValues.TAG;

/**
 * Created by ptmi on 2017.03.17..
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener {


    private final SurfaceHolder surfaceHolder;
    Game game;


    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        //touch
        setFocusable(true);
        setOnTouchListener(this);

        game = new Game(context, surfaceHolder);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        game.width = width;
        game.height = height;

        game.start(); // itt mar tudjuk a kepernyo meretet


    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return game.onTouch(event);

    }


}
