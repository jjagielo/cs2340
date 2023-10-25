package com.example.sprint3;

import com.example.sprint1.Models.Enemy;
import com.example.sprint1.Models.Enemy1;
import com.example.sprint1.Models.EntityMovement;
import com.example.sprint1.Models.Player;
import com.example.sprint1.ViewModels.GameScreen;

import org.junit.Test;
import static junit.framework.TestCase.assertTrue;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

public class AdiTest{

    @Test
    public void testStrategyPatternPlayer() {
        GameScreen gs = new GameScreen();
        Player player = Player.getPlayer("Bob", 1.0, null);

        // Tests if ConcreteStrategy class (Player.class) implements Strategy class (EntityMovement.class)
        List<Class<?>> interfaces = Arrays.asList(player.getClass().getInterfaces());
        assertTrue(interfaces.contains(EntityMovement.class));
    } // testStrategyPatternPlayer

    @Test
    public void testStrategyPatternEnemy() {
        Player player = Player.getPlayer("Bob", 1.0, null);
        Enemy enemy = new Enemy1(player.getDifficulty());

        // Tests Enemy class
        assertEquals(enemy.getHealth(), 100);
        assertEquals(Math.round(enemy.getDifficulty()), 1);

        // Tests if ConcreteStrategy class (Enemy.class) implements Strategy class (EntityMovement.class)
        List<Class<?>> interfaces = Arrays.asList(player.getClass().getInterfaces());
        assertTrue(interfaces.contains(EntityMovement.class));
    } // testStrategyPatternEnemy

} // AdiTest
