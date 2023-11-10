package com.example.sprint1.Models;

import android.widget.ImageView;

public class EnemyFactory {
    public static Enemy createEnemy(int enemyNum, double diff, ImageView character) {
        switch (enemyNum) {
        case 1:
            return new EnemyNecromancer(diff, character);
        case 2:
            return new EnemyPumpkin(diff, character);
        case 3:
            return new EnemySkeleton(diff, character);
        case 4:
            return new EnemySlug(diff, character);
        default:
            return null;
        }
    }
}