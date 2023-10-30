package com.example.sprint1.Models;

public class EnemyFactory {
    public static Enemy createEnemy(int enemyNum, double diff) {
        switch (enemyNum) {
        case 1:
            return new Enemy1(diff);
        case 2:
            return new Enemy2(diff);
        case 3:
            return new Enemy3(diff);
        case 4:
            return new Enemy4(diff);
        default:
            return null;
        }
    }
}