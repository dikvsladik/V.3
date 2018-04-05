

package com.example.ptmi.spaceship.entity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.ptmi.spaceship.Game;
import com.example.ptmi.spaceship.R;

import static com.example.ptmi.spaceship.Game.game;


public class Missile extends Entity {


    Paint paint = new Paint();



    public Missile(  float x, float y) {
        super(x, y);
        paint.setColor(Color.RED);
        r = 15;

    }

    public void collison(Entity other) {
        if (other instanceof Enemy) {

            kill();
            other.kill();
        }
        if (other instanceof Asteorid) {


            kill();
            other.kill();
        }
        if (other instanceof Enemymissiles) {


            kill();
            other.kill();
        }
    }


    @Override
    public void update() {
        y -= 20;


    }

    @Override
    public void render(Canvas canvas) {
        //canvas.drawCircle(x, y, r, paint);
        Game.rocket.draw(canvas, new Rect((int) (x-r), (int)( y-r), (int) (x + r), (int) (y + r)), paint);

    }
}
