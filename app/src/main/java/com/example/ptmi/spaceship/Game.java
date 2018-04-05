package com.example.ptmi.spaceship;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;


import com.example.ptmi.spaceship.entity.Asteorid;
import com.example.ptmi.spaceship.entity.Enemy;
import com.example.ptmi.spaceship.entity.Entity;
import com.example.ptmi.spaceship.entity.Ship;
import com.example.ptmi.spaceship.utils.Sprite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ptmi on 2017.03.17..
 */

public class Game extends Thread {
    public static Game game;
    public final String TAG = Game.class.getSimpleName();
    private final Context context;
    public int width;
    public int height;
    public int tick = 0;
    Paint paint =new Paint();
    public double health=100;
    SurfaceHolder surfaceHolder;
    List<Entity> objects = new ArrayList<>(); // asteorids, bullets...
    Ship player;
    public  static Sprite ship;
    public  static Sprite rocket;
    public  static Sprite rocket2;
    public static Sprite alien1;
    public static Sprite asteroid;
    Random rnd = new Random();


    public Game(Context context, SurfaceHolder surfaceHolder) {

        this.surfaceHolder = surfaceHolder;
        game = this;
        this.context =context;
    }

    @Override
    public void run() {
        super.run();
        init();

        while (true) {


            Canvas canvas = surfaceHolder.lockCanvas();

            if (canvas != null) {
                canvas.drawColor(Color.BLUE);

                update();
                render(canvas);

                surfaceHolder.unlockCanvasAndPost(canvas);
            }


            try {
                sleep(1000 / 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    private void init() {
        // create player obj

        player = new Ship(width / 2, height / 2);
        objects.add(player);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.spaceship);
        ship= new Sprite(bitmap);
        rocket = new Sprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.bullet));
        rocket2 = new Sprite(BitmapFactory.decodeResource(conte     xt.getResources(), R.drawable.bullet2));
        alien1 = new Sprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.alien1));
        asteroid = new Sprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.asteroid));
    }


    private void update() {

        tick++;

        if (tick % 63 == 0) {
            Entity enemy = new Enemy(rnd.nextInt(width + 1), -10);
            addEntity(enemy);

        }
        if (tick % 80 == 0) {
            Entity asteorid = new Asteorid(rnd.nextInt(width + 1), -10);
            addEntity(asteorid);

        }
        // update
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).update();
        }

        // utkozes

        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                Entity e1 = objects.get(i);
                Entity e2 = objects.get(j);
                if (e1.isColliding(e2)) {
                    e2.collison(e1);
                    e1.collison(e2);

                }


            }
        }


        for (int i = 0; i < objects.size(); i++) {
            Entity entity = objects.get(i);



            if (entity.getY() > height + 2 * entity.getR() || entity.isDead()) {
                objects.remove(i);

            }

            if (entity.getY()<0-2*entity.getR()) {
                objects.remove(i);}

        }
    }

    public void addEntity(Entity e) {
        objects.add(e);

    }

    private void render(Canvas canvas) {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).render(canvas);
        }
        paint.setColor(Color.RED);
        paint.setTextSize(48);
        canvas.drawText(String.valueOf(player.health), 10, 70, paint);

    }

    public boolean onTouch(MotionEvent event) { // itt van a jatekhoz kapcsolodo logika
        Log.v(TAG, event.toString());

        if (event.getAction() == MotionEvent.ACTION_MOVE ||
                event.getAction() == MotionEvent.ACTION_DOWN ||
                event.getAction() == MotionEvent.ACTION_POINTER_DOWN) {
            //player.setX(event.getX());
            //   player.setY(event.getY());
            player.newX = event.getX();
            player.newY = event.getY();



            return true; // return true ha lekezeltuk az eventet
        }
        return false; // false ha nem es akkor tovabbadhatja mas view-knak
    }

}
