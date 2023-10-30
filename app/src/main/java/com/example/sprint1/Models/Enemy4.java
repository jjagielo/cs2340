package com.example.sprint1.Models;
import com.example.sprint1.R;

import android.widget.ImageView;
import java.util.Random;

// Need to implement "Enemy" as an interface first
public class Enemy4 implements Enemy, EntityMovement {
    private int health;
    private double difficulty;
    private ImageView character;
    private float movementSpeed;

    public Enemy4(double diff) {
        this.difficulty = diff;
        this.movementSpeed = 2;

        if (diff == 0.5) {
            health = 200;
        } else if (diff == 0.75) {
            health = 150;
        } else {
            health = 100;
        }
    }

    // Methods implemented from EntityMovement interface

    @Override
    public void changePos(float currX, float currY) {
        Random direction = new Random();
        int dir = direction.nextInt(4);

        // The constant 4 is subject to change
        // Must either implement wall collision recognition in either
        // changePos() or setX()/setY() methods
        if (dir == 0) {
            character.setX(character.getX() + 4);
        } else if (dir == 1) {
            character.setX(character.getX() - 4);
        } else if (dir == 2) {
            character.setY(character.getY() + 4);
        } else if (dir == 3) {
            character.setY(character.getY() - 4);
        }
    }

    // Methods implemented from Enemy interface

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public double getDifficulty() {
        return difficulty;
    }

    @Override
    public int getCharacterID() {
        return R.drawable.slug_anim_f0;
    }

    @Override
    public float getMovementSpeed() {
        return movementSpeed;
    }

    @Override
    public float getX() {
        return character.getX();
    }

    @Override
    public float getY() {
        return character.getY();
    }

    @Override
    public void setHealth(int newHealth) {
        health = newHealth;
    }

    @Override
    public void setCharacter(ImageView charc) {
        character = charc;
    }

    @Override
    public void setX(float x) {
        character.setX(x);
    }

    @Override
    public void setY(float y) {
        character.setY(y);
    }
}