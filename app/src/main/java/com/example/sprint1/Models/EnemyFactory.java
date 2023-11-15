package com.example.sprint1.Models;

import android.widget.ImageView;

public class EnemyFactory {
    /*
     * Method utilizing the Factory Method Pattern to return an enemy based on calling
     * method's specification
     *
     * @param enemyNum the type of enemy to create
     * @param diff the difficulty of the game
     * @param character the sprite to place on the enemy
     * @return Enemy the enemy created
     */
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