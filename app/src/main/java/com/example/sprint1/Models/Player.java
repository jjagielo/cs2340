package com.example.sprint1.Models;

public class Player {
    private String name;
    private int health;
    private float x;
    private float y;
    private Leaderboard leaderboard;

    private static Player player;

    private Player(String name, int health) {
        this.name = name;
        this.health = health;
        this.x = 0.0f;
        this.y = 0.0f;
        this.leaderboard = new Leaderboard();
    }

    public static Player getPlayer(String name, int health) {
        if (player == null) {
            synchronized (Player.class) {
                if (player == null) {
                    player = new Player(name, health);
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
        return x;
    }

    public float getY() {
        return y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}
