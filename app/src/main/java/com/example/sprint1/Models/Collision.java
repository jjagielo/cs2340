package com.example.sprint1.Models;

import android.content.Context;

public class Collision {
    public static void checkCollision(Context context, Player player, Enemy enemy1, Enemy enemy2) {
        if (isColliding(player, enemy1) || isColliding(player, enemy2)) {
            if (player.getDifficulty() == 1) {
                player.setHealth(player.getHealth() - 15);
            } else if (player.getDifficulty() == 0.75) {
                player.setHealth(player.getHealth() - 12);
            } else {
                player.setHealth(player.getHealth() - 10);
            }
        }
    }

    private static boolean isColliding(Player player, Enemy enemy) {
        return player.notifyHealth(player, enemy);
    }


}
