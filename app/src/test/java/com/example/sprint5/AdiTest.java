package com.example.sprint5;

import static junit.framework.TestCase.assertTrue;

import com.example.sprint1.Models.Collision;

import com.example.sprint1.Models.HealthPowerUp;
import com.example.sprint1.Models.Player;
import com.example.sprint1.Models.PowerUpDecorator;
import com.example.sprint1.Models.SpeedPowerUp;

import org.junit.Test;

public class AdiTest {
    @Test
    public void testHealthPowerup() {
        Player player = Player.getPlayer("test", 1.0, null);
        PowerUpDecorator powerup = new HealthPowerUp(player);

        assertTrue(player.alertPowerupCollision(player, null, powerup));
        int playerHealthBefore = player.getHealth();

        Collision.checkCollision(null, player, null, powerup);

        assertTrue(playerHealthBefore != player.getHealth());
    } // testHealth Powerup

    @Test
    public void testSpeedPowerup() {
        Player player = Player.getPlayer("test", 1.0, null);
        PowerUpDecorator powerup = new SpeedPowerUp(player);

        assertTrue(player.alertPowerupCollision(player, null, powerup));
        int playerSpeedBefore = player.getSpeed();

        Collision.checkCollision(null, player, null, powerup);

        assertTrue(playerSpeedBefore != player.getSpeed());
    } // testHealth Powerup

}
