package com.example.sprint1.Models;

import android.widget.ImageView;

public class Player implements EntityMovement, ScoreObserver, MovementObserver {
    private String name;
    private int health;
    private double difficulty;
    private ImageView character;
    private static Player player;

    private Player(String name, double diff, ImageView charc) {
        this.name = name;
        this.difficulty = diff;
        this.character = charc;
        health = 100;
        if (difficulty == 1) {
            health = 100;
        } else if (difficulty == 0.75) {
            health = 150;
        } else if (difficulty == 0.5) {
            health = 200;
        } // if
    }

    public static Player getPlayer(String name, double difficulty, ImageView charc) {
        if (player == null) {
            synchronized (Player.class) {
                if (player == null) {
                    player = new Player(name, difficulty, charc);
                }
            }
        }
        return player;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public float getX() {
        return character.getX();
    }

    public float getY() {
        return character.getY();
    }

    public float getInitX() {
        return 0.0f;
    }

    public float getInitY() {
        return 0.0f;
    }

    public double getDifficulty() {
        return difficulty;
    }


    public void setDifficulty(double diff) {
        this.difficulty = diff;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setX(float x) {
        character.setX(x);
    }

    public void setY(float y) {
        character.setY(y);
    }

    @Override
    public void changePos(float newX, float newY) {
        character.setY(newY);
        character.setX(newX);
    }


    public void alert(int score) {
        if (score == 10) {
            setHealth(this.health+10);
        }
    }


    public void notifyPlayer(float newX, float newY) {
        player.alertMovement(newX, newY);
    }

    @Override
    public void alertMovement(float newX, float newY) {
        character.setY(newY);
        character.setX(newX);
    }

}
