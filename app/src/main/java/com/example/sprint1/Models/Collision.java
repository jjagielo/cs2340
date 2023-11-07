package com.example.sprint1.Models;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.sprint1.ViewModels.EndScreenLoser;

public class Collision {
    public static void checkCollision(Context context, Player player, Enemy enemy1, Enemy enemy2) {
        if (isColliding(player, enemy1) || isColliding(player, enemy2)) {
            player.setHealth(player.getHealth()-15);
        }
    }

    private static boolean isColliding(Player player, Enemy enemy) {
        return player.notifyHealth(player, enemy);
    }


}
