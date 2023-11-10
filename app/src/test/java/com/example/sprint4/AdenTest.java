package com.example.sprint4;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import com.example.sprint1.Models.Enemy;
import com.example.sprint1.Models.EnemyNecromancer;
import com.example.sprint1.Models.EnemyPumpkin;
import com.example.sprint1.Models.EnemySkeleton;
import com.example.sprint1.Models.EnemySlug;
import com.example.sprint1.R;

import org.junit.Test;

public class AdenTest {
    @Test
    public void testEnemySprites() {
        Enemy enemyType1 = new EnemyNecromancer(0.5, null);
        Enemy enemyType2 = new EnemyPumpkin(0.5, null);
        Enemy enemyType3 = new EnemySkeleton(0.5, null);
        Enemy enemyType4 = new EnemySlug(0.5, null);

        assertEquals(enemyType1.getCharacterID(), R.drawable.necromancer_anim_f0);
        assertEquals(enemyType2.getCharacterID(), R.drawable.pumpkin_dude_idle_anim_f0);
        assertEquals(enemyType3.getCharacterID(), R.drawable.skelet_idle_anim_f0);
        assertEquals(enemyType4.getCharacterID(), R.drawable.slug_anim_f0);
    }

    @Test
    public void testEnemyMovementSpeed() {
        Enemy enemyType1 = new EnemyNecromancer(0.5, null);
        Enemy enemyType2 = new EnemyPumpkin(0.5, null);
        Enemy enemyType3 = new EnemySkeleton(0.5, null);
        Enemy enemyType4 = new EnemySlug(0.5, null);

        assertTrue(enemyType4.getMovementSpeed() > enemyType3.getMovementSpeed());
        assertTrue(enemyType3.getMovementSpeed() > enemyType2.getMovementSpeed());
        assertTrue(enemyType2.getMovementSpeed() > enemyType1.getMovementSpeed());
    }
}
