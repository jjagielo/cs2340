package com.example.sprint1.Models;
import com.example.sprint1.R;
import com.example.sprint1.ViewModels.GameScreen;

import android.widget.ImageView;
import java.util.Random;

// Need to implement "Enemy" as an interface first
public class EnemyNecromancer implements Enemy, EntityMovement {
    private int health;
    private double difficulty;
    private ImageView character;
    private float movementSpeed;

    int timer = 0;
    Random direction = new Random();
    int dir = direction.nextInt(4);

    public EnemyNecromancer(double diff, ImageView character) {
        this.difficulty = diff;
        this.movementSpeed = 0.5f;
        this.character = character;

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
        setX(currX);
        setY(currY);
    }
    @Override
    public void move(){

        if (timer <= 0) {
            direction = new Random();
            dir = direction.nextInt(4);

            timer = 40;
        } else {
            if (dir == 0) {
                if(character.getX() < GameScreen.screenWidth - 300){
                    character.setX(character.getX() + 30);
                } else {
                    timer = 1;
                }
            } else if (dir == 1) {
                if(character.getX() > 250) {
                    character.setX(character.getX() - 30);
                } else {
                    timer = 1;
                }
            } else if (dir == 2 ) {
                if(character.getY() < GameScreen.screenHeight - 270) {
                    character.setY(character.getY() + 30);
                } else {
                    timer = 1;
                }
            } else if (dir == 3) {
                if(character.getY() > 20) {
                    character.setY(character.getY() - 30);
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
        return R.drawable.necromancer_anim_f0;
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
}