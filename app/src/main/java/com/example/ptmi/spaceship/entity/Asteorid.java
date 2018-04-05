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

public class Asteorid extends Entity {
    public int width = game.width;
    public int height = game.height;

    Ship player;
    Paint paint = new Paint();

    public Asteorid(float x, float y) {
        super(x, y);
        r = 60;
        paint.setColor(Color.GRAY);
    }

    @Override
    public void collison(Entity other) {

    }

    @Override
    public void update() {

        y = y + 10;

    }


    @Override
    public void render(Canvas canvas) {
        //canvas.drawCircle(x, y, r, paint);
        Game.asteroid.draw(canvas, new Rect((int) (x-r), (int)( y-r), (int) (x + r), (int) (y + r)), paint);

    }
}
