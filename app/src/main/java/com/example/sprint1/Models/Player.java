package com.example.sprint1.Models;

import android.widget.ImageView;

public class Player {
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

    public void changePos(float x, float y) {
        character.setY(y);
        character.setX(x);
    }
}
