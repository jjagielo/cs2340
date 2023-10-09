package com.example.sprint1.Models;

import com.example.sprint2.Models.Leaderboard;

public class Player {
    private String name;
    private int health;
    private Leaderboard leaderboard;

    private static Player player;

    private Player(String name, int health) {
        this.name = name;
        this.health = health;
        this.leaderboard = Leaderboard.getinstance();
    }

    public static Player getPlayer(String name, int health) {
        if (player == null) {
            synchronized(Player.class) {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
