package com.example.sprint4;


import static com.example.sprint1.Models.EnemyFactory.createEnemy;

import static org.junit.Assert.assertEquals;

import com.example.sprint1.Models.Enemy;
import com.example.sprint1.R;

import org.junit.Test;

public class JasonTest {

    @Test
    public void enemyFactoryTest() {
        int enemyNum = 1;
        Enemy enemyTest1 = createEnemy(1, 1);
        Enemy enemyTest2 = createEnemy(2, 1);
        Enemy enemyTest3 = createEnemy(3, 1);
        Enemy enemyTest4 = createEnemy(4, 1);

        // Test creation of first type of enemy through EnemyFactory.java
        assertEquals(enemyTest1.getCharacterID(), R.drawable.necromancer_anim_f0);
        assertEquals(enemyTest1.getMovementSpeed(), 0.5f, 0);

        // Test creation of second type of enemy through EnemyFactory.java
        assertEquals(enemyTest2.getCharacterID(), R.drawable.pumpkin_dude_idle_anim_f0);
        assertEquals(enemyTest2.getMovementSpeed(), 1f, 0);

        // Test creation of third type of enemy through EnemyFactory.java
        assertEquals(enemyTest3.getCharacterID(), R.drawable.skelet_idle_anim_f0);
        assertEquals(enemyTest3.getMovementSpeed(), 1.5f, 0);

        // Test creation of fourth type of enemy through EnemyFactory.java
        assertEquals(enemyTest4.getCharacterID(), R.drawable.slug_anim_f0);
        assertEquals(enemyTest4.getMovementSpeed(), 2f, 0);
    }

    @Test
    public void test2() {

    }
}
