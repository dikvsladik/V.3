package com.example.ptmi.spaceship.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.ptmi.spaceship.Game;

/**
 * Created by Dikvsladik on 2017.03.31..
 */

public class Sprite {
    Bitmap bitmap;
    Rect rect;

    public Sprite(Bitmap bitmap) {
        this.bitmap = bitmap;
        rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
    }

    public void draw(Canvas canvas, Rect dst, Paint paint){
        canvas.drawBitmap(bitmap, rect, dst, paint);

    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public Rect getRect() {
        return rect;
    }
}
