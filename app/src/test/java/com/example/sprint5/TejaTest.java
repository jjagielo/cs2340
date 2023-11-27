package com.example.sprint5;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import android.widget.ImageView;

import com.example.sprint1.Models.Collision;
import com.example.sprint1.Models.CollisionObserver;
import com.example.sprint1.Models.Enemy;
import com.example.sprint1.Models.EnemyFactory;
import com.example.sprint1.Models.EntityMovement;
import com.example.sprint1.Models.HealthPowerUp;
import com.example.sprint1.Models.Leaderboard;
import com.example.sprint1.Models.MovementObserver;
import com.example.sprint1.Models.Player;
import com.example.sprint1.Models.PowerUpDecorator;
import com.example.sprint1.Models.ScoreData;
import com.example.sprint1.Models.SpeedPowerUp;
import com.example.sprint1.Models.TimeFreezePowerUp;
import com.example.sprint1.R;
import com.example.sprint1.ViewModels.EndScreenLoser;
import com.example.sprint1.ViewModels.GameScreen;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class TejaTest {
    @Test
    public void testDecoratorPattern() {
        Player player = Player.getPlayer("TestPlayer", 0.75, null);

        SpeedPowerUp speedObject = new SpeedPowerUp(player);
        TimeFreezePowerUp timeFreezeObject = new TimeFreezePowerUp(player);
        HealthPowerUp healthObject = new HealthPowerUp(player);
        assertNotNull(speedObject); //makes sure SpeedPowerUp instance is not null
        assertNotNull(timeFreezeObject); //makes sure TimeFreezePowerUp instance is not null

        // if these classes implements PowerUpDecorator interface
        List<Class<?>> interfaces = Arrays.asList(speedObject.getClass().getInterfaces());
        assertTrue(interfaces.contains(PowerUpDecorator.class));
        List<Class<?>> interfaces2 = Arrays.asList(timeFreezeObject.getClass().getInterfaces());
        assertTrue(interfaces2.contains(PowerUpDecorator.class));
        List<Class<?>> interfaces3 = Arrays.asList(healthObject.getClass().getInterfaces());
        assertTrue(interfaces3.contains(PowerUpDecorator.class));

    }

    @Test
    public void testCollisionScoreDecrease() {
        GameScreen gameScreen = new GameScreen();

        int initialScore = gameScreen.getInitScore();

        // make sure that the enemy is not null before simulating a collision
        if (gameScreen.getEnemy1() != null) {
            // Simulate a collision
            Collision.checkCollision(null, gameScreen.getPlayer(), gameScreen.getEnemy1(), null);
        }

        // Log initial and new scores for debugging
        int newScore = gameScreen.getInitScore();
        System.out.println("Initial Score: " + initialScore);
        System.out.println("New Score: " + newScore);

        if(Collision.getCollision() == false) {
            assertTrue(newScore == initialScore);
        } else {
            assertTrue(newScore < initialScore);
        }


    }



}
