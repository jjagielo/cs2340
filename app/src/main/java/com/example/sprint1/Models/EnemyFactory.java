package com.example.sprint1.Models;

public class EnemyFactory {
    public Enemy createEnemy(int enemyNum) {
        switch (enemyNum) 
        {
            case 1:
                return new Enemy1();
                break;
            case 2:
                return new Enemy2();
                break;
            case 3:
                return new Enemy3();
                break;
            case 4:
                return new Enemy4();
                break;
            default:
                return null;
        }
    }
}