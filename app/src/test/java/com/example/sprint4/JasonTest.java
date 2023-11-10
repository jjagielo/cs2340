package com.example.sprint4;


import static com.example.sprint1.Models.EnemyFactory.createEnemy;

import static org.junit.Assert.assertEquals;

import com.example.sprint1.Models.Enemy;
import com.example.sprint1.Models.EnemyNecromancer;
import com.example.sprint1.Models.EnemyPumpkin;
import com.example.sprint1.Models.EnemySkeleton;
import com.example.sprint1.Models.EnemySlug;
import com.example.sprint1.R;

import org.junit.Test;

public class JasonTest {

    @Test
    public void enemyFactoryTestEnemyType() {
        // Instantiate 4 enemies from enemyFactory
        // Each should instantiate a different type of enemy
        Enemy enemyTest1 = createEnemy(1, 1, null);
        Enemy enemyTest2 = createEnemy(2, 1, null);
        Enemy enemyTest3 = createEnemy(3, 1, null);
        Enemy enemyTest4 = createEnemy(4, 1, null);

        // Test creation of first type of enemy through EnemyFactory.java
        // Makes sure unique attributes align with the specific enemy
        assertEquals(enemyTest1.getCharacterID(), R.drawable.necromancer_anim_f0);
        assertEquals(enemyTest1.getMovementSpeed(), 0.5f, 0);

        // Test creation of second type of enemy through EnemyFactory.java
        // Makes sure unique attributes align with the specific enemy
        assertEquals(enemyTest2.getCharacterID(), R.drawable.pumpkin_dude_idle_anim_f0);
        assertEquals(enemyTest2.getMovementSpeed(), 1f, 0);

        // Test creation of third type of enemy through EnemyFactory.java
        // Makes sure unique attributes align with the specific enemy
        assertEquals(enemyTest3.getCharacterID(), R.drawable.skelet_idle_anim_f0);
        assertEquals(enemyTest3.getMovementSpeed(), 1.5f, 0);

        // Test creation of fourth type of enemy through EnemyFactory.java
        // Makes sure unique attributes align with the specific enemy
        assertEquals(enemyTest4.getCharacterID(), R.drawable.slug_anim_f0);
        assertEquals(enemyTest4.getMovementSpeed(), 2f, 0);
    }

    @Test
    public void enemyFactoryTestInstance() {
        // Instantiate enemies
        Enemy enemyTest1 = createEnemy(1, 1, null);
        Enemy enemyTest2 = createEnemy(2, 1, null);
        Enemy enemyTest3 = createEnemy(3, 1, null);
        Enemy enemyTest4 = createEnemy(4, 1, null);

        // Check if enemies are an instance of their specific class that they intended to be.
        // Will pass if they are the correct type
        assertEquals(enemyTest1.getClass().getName(), EnemyNecromancer.class.getName());
        assertEquals(enemyTest2.getClass().getName(), EnemyPumpkin.class.getName());
        assertEquals(enemyTest3.getClass().getName(), EnemySkeleton.class.getName());
        assertEquals(enemyTest4.getClass().getName(), EnemySlug.class.getName());
    }
}
