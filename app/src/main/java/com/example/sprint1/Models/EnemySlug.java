package com.example.sprint1.Models;
import com.example.sprint1.R;
import com.example.sprint1.ViewModels.GameScreen;

import android.widget.ImageView;
import java.util.Random;

// Need to implement "Enemy" as an interface first
public class EnemySlug implements Enemy, EntityMovement {
    private int health;
    private double difficulty;
    private ImageView character;
    private float movementSpeed;
    private int timer = 0;
    private Random direction = new Random();
    private int dir = direction.nextInt(4);
    private boolean active;

    public EnemySlug(double diff, ImageView character) {
        this.difficulty = diff;
        this.movementSpeed = 2;
        this.character = character;
        this.active = true;

        if (diff == 0.5) {
            health = 200;
        } else if (diff == 0.75) {
            health = 150;
        } else {
            health = 100;
        }
    }

    // Methods implemented from EntityMovement interface

    /*
     * Method to change the position of the enemy
     *
     * @param currX the new x position to set the enemy to
     * @param currY the new y position to set the enemy to
     */
    @Override
    public void changePos(float currX, float currY) {
        setX(currX);
        setY(currY);
    }

    /*
     * Method to randomly move the enemy based on a timer
     */
    @Override
    public void move() {

        if (timer <= 0) {
            direction = new Random();
            dir = direction.nextInt(4);

            timer = 40;
        } else {
            if (dir == 0) {
                if (character.getX() < GameScreen.getScreenWidth() - 300) {
                    character.setX(character.getX() + 8);
                } else {
                    timer = 1;
                }
            } else if (dir == 1) {
                if (character.getX() > 250) {
                    character.setX(character.getX() - 8);
                } else {
                    timer = 1;
                }
            } else if (dir == 2) {
                if (character.getY() < GameScreen.getScreenHeight() - 270) {
                    character.setY(character.getY() + 8);
                } else {
                    timer = 1;
                }
            } else if (dir == 3) {
                if (character.getY() > 20) {
                    character.setY(character.getY() - 8);
                } else {
                    timer = 1;
                }
            }
            timer--;
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

    public float getInitX() {
        return 0.0f;
    }

    public float getInitY() {
        return 0.0f;
    }

    @Override
    public float getX() {
        if (character != null) {
            return character.getX();
        } // if
        return getInitX();
    }

    @Override
    public float getY() {
        if (character != null) {
            return character.getY();
        } // if
        return getInitY();
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
    @Override
    public boolean getActive() {
        return active;
    }
    @Override
    public void setActive(boolean active) {
        this.active = active;
    }
}