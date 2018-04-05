

package com.example.ptmi.spaceship.entity;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.ptmi.spaceship.Game;
import com.example.ptmi.spaceship.GameView;

import java.util.Random;

import static com.example.ptmi.spaceship.Game.game;


public class Enemy extends Entity {

    Paint paint = new Paint();

    public Enemy(float x, float y) {
        super(x, y);
        r = 80;
    }

    @Override
    public void collison(Entity other) {

    }

    @Override
    public void update() {

        y = y + 10;
        if (Game.game.tick % 20 == 0) {
            Entity Enemymissiles = new Enemymissiles(x, y + 2*r);
            Game.game.addEntity(Enemymissiles);
        }
    }


    @Override
    public void render(Canvas canvas) {
      //canvas.drawCircle(x,y,r,paint);
        Game.alien1.draw(canvas, new Rect((int) (x-r), (int)( y-r), (int) (x + r), (int) (y + r)), paint);

    }
}

