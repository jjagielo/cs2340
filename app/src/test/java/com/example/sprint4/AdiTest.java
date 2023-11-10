package com.example.sprint4;

import static com.example.sprint1.Models.EnemyFactory.createEnemy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.widget.ImageView;

import com.example.sprint1.Models.Collision;
import com.example.sprint1.Models.Enemy;
import com.example.sprint1.Models.Player;
import com.example.sprint1.R;
import com.example.sprint1.ViewModels.GameScreen;

import org.junit.Test;
import org.junit.Assert.*;

public class AdiTest {
    @Test
    public void testCollisionCoordinates() {


        Enemy enemy = createEnemy(1, 1, null);
        Player player = Player.getPlayer("bob", 1.0, null);


        assertTrue(player.alertCollision(player, enemy));
    } // testCollision

    @Test
    public void testCollisionHealth() {
        Enemy enemy = createEnemy(1, 1, null);
        Enemy enemy2 = createEnemy(1, 1, null);
        Player player = Player.getPlayer("bob", 1.0, null);

        int healthBefore = player.getHealth();

        Collision.checkCollision(null, player, enemy, enemy2);

        assertTrue(healthBefore != player.getHealth());
    }
}
