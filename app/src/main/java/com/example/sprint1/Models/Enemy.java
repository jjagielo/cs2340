package com.example.sprint1.Models;

import android.widget.ImageView;

import java.util.Random;

public class Enemy implements EntityMovement {
    private int health;
    private double difficulty;
    private ImageView character;

    public EnemyClass(double diff, ImageView charc) {
        // Intializes Enemy variables
        this.character = charc;
        this.difficulty = diff;
        health = 100;
        if (difficulty == 1.0) {
            health = 100;
        } else if (difficulty == 0.75) {
            health = 150;
        } else if (difficulty == 0.5) {
            health = 200;
        } // if
    } // Enemy

    // Implement movement method from EntityMovement interface
    @Override
    public void changePos(float newX, float newY) {
        // READ:
        // For now, my idea is to have the parameters be the range of pixels for enemy to move
        // This exact implementation might not work later because we have to check bounds, but since
        // enemy is not in the game yet, this is placeholder code.
        Random direction = new Random();
        int dir = direction.nextInt(4);

        Random move = new Random();
        int rand = move.nextInt(Math.round(newX));

        if (dir == 0) {
            character.setX(character.getX() + rand);
        } else if (dir == 1) {
            character.setX(character.getX() - rand);
        } else if (dir == 2) {
            character.setY(character.getY() + rand);
        } else {
            character.setY(character.getX() - rand);
        } // if
    } // changePos

    public int getHealth() {
        return health;
    } // getHealth

    public double getDifficulty() {
        return difficulty;
    } // getDifficulty

    public ImageView getCharacter() {
        return character;
    } // getCharacter

    public float getX() {
        return character.getX();
    } // getX

    public float getY() {
        return character.getY();
    } // getY

    public void setHealth(int newHealth) {
        health = newHealth;
    } // setHealth

    public void setCharacter(ImageView charc) {
        character = charc;
    } // setCharacter

    public void setX(float x) {
        character.setX(x);
    } // setX

    public void setY(float y) {
        character.setY(y);
    } // setY
}
