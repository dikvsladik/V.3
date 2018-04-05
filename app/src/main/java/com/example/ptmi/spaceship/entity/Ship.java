package com.example.ptmi.spaceship.entity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.ptmi.spaceship.Game;
import com.example.ptmi.spaceship.GameActivity;
import com.example.ptmi.spaceship.MainActivity;
import com.example.ptmi.spaceship.R;

/**
 * Created by ptmi on 2017.03.17..
 */

public class Ship extends Entity {
    public float newX, newY;
    Paint paint = new Paint();
    public int health = 100;

    public Ship(float x, float y) {
        super(x, y);
        newX = x;
        newY = y;
        r = 70;
        paint.setColor(Color.GREEN); // csak az elejen kell beallitani a szint, mert nem valtozik
    }

    @Override
    public void collison(Entity other) {

        if (other instanceof Enemymissiles) {
            health -= 1;

            other.kill();
        }
        if (other instanceof Asteorid) {
            health -= 3;

            other.kill();
        }
        if (other instanceof Enemy) {
            health -= 3;

            other.kill();
        }

    }


    @Override
    public void update() {
        float dx = newX - x;
        float dy = newY - y;
        float d = dx * dx + dy * dy;

        x += dx / 30;
        y += dy / 30;


        if (Game.game.tick % 5 == 0) {
            Entity missile = new Missile(x, y - r);
            Game.game.addEntity(missile);
        }


    }

    @Override
    public void render(Canvas canvas) {
        //canvas.drawCircle(x, y, r, paint);
        Game.ship.draw(canvas, new Rect((int) (x-r), (int)( y-r), (int) (x + r), (int) (y + r)), paint);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

}
