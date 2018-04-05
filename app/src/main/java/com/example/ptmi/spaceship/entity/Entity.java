package com.example.ptmi.spaceship.entity;

import android.graphics.Canvas;

/**
 * Created by ptmi on 2017.03.17..
 */

public abstract class Entity {

    float x, y, r;
    private boolean dead = false;

    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public boolean isDead() {
        return dead;

    }

    public void kill() {
        dead = true;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public abstract void collison(Entity other);

    public abstract void update();

    public abstract void render(Canvas canvas);

    public float getDistanceSquare(Entity other) {
        float dx = other.x - x;
        float dy = other.y - y;
        return dx * dx + dy * dy;
    }



    public boolean isColliding(Entity other) {
        return getDistanceSquare(other) <= (other.r + this.r) * (other.r + this.r);
    }



    public float getR() {
        return r;
    }
}
