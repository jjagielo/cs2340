package com.example.sprint1.Models;

import android.widget.ImageView;

public class EnemyFactory {
    public static Enemy createEnemy(int enemyNum, double diff, ImageView character) {
        switch (enemyNum) {
        case 1:
            return new Enemy1(diff, character);
        case 2:
            return new Enemy2(diff, character);
        case 3:
            return new Enemy3(diff, character);
        case 4:
            return new Enemy4(diff, character);
        default:
            return null;
        }
    }
}