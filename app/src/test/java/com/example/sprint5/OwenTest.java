package com.example.sprint5;

import static com.example.sprint1.Models.EnemyFactory.createEnemy;
import static junit.framework.TestCase.assertTrue;

import com.example.sprint1.Models.Collision;
import com.example.sprint1.Models.Enemy;
import com.example.sprint1.Models.EnemyFactory;
import com.example.sprint1.Models.EnemyNecromancer;
import com.example.sprint1.Models.EnemyPumpkin;
import com.example.sprint1.Models.EnemySkeleton;
import com.example.sprint1.Models.EnemySlug;
import com.example.sprint1.Models.Player;

import org.junit.Assert;
import org.junit.Test;

public class OwenTest {
    @Test
    public void testNoDamage() {
        Enemy enemy1 = createEnemy(1, 1, null);
        Enemy enemy2 = createEnemy(1, 1, null);
        Player player = Player.getPlayer("test", 1.0, null);
        player.setAttacking(true);

        Collision.checkCollision(null, player, enemy1, enemy2);

        Assert.assertTrue(player.getHealth() == 100);

        Enemy enemy3 = createEnemy(1, 1, null);
        Enemy enemy4 = createEnemy(1, 1, null);

        player.setAttacking(false);

        Collision.checkCollision(null, player, enemy3, enemy4);

        Assert.assertTrue(player.getHealth() < 100);
    }

    @Test
    public void testEnemyBecomesActive() {
        Enemy enemy1 = new EnemyNecromancer(0.5, null);
        Enemy enemy2 = new EnemyPumpkin(0.5, null);


        assertTrue(enemy1.getActive());
        assertTrue(enemy2.getActive());

        Player player = Player.getPlayer("test", 1.0, null);
        player.setAttacking(true);

        Collision.checkCollision(null, player, enemy1, enemy2);

        Assert.assertTrue(player.getHealth() == 100);

        enemy1 = EnemyFactory.createEnemy(4, 0.5, null);
        enemy2 = EnemyFactory.createEnemy(1, 0.5, null);

        enemy1.setActive(true);
        enemy2.setActive(true);
        player.setAttacking(false);

        Collision.checkCollision(null, player, enemy1, enemy2);

        Assert.assertTrue(player.getHealth() < 100);
    }
}
