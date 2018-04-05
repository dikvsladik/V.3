package com.example.ptmi.spaceship.entity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.ptmi.spaceship.Game;

import static com.example.ptmi.spaceship.Game.game;

/**
 * Created by Dikvsladik on 2017.03.25..
 */

public class Enemymissiles extends Entity {


    Paint paint = new Paint();


    public Enemymissiles(float x, float y){
        super(x, y);
        paint.setColor(Color.YELLOW);
        r = 10;


    }
    public void collison(Entity other) {


    }



    @Override
    public void update() {
        y += 20;


    }

    @Override
    public void render(Canvas canvas) {
        //canvas.drawCircle(x, y, r, paint);
        Game.rocket2.draw(canvas, new Rect((int) (x-r), (int)( y-r), (int) (x + r), (int) (y + r)), paint);
    }
}

