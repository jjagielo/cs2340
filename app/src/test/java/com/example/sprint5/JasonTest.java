package com.example.sprint5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.sprint1.ViewModels.GameScreen;

import org.junit.Test;

public class JasonTest {
    @Test
    public void testInitialScore() {
        // Checks if initializing aligns with score factors of:
        // Time in game
        // Difficulty
        // Enemies defeated
        GameScreen gs = new GameScreen();

        gs.resetScore();

        // Easy
        gs.setDiffMultipler(0.5);
        assertEquals(505, gs.getInitScore());

        // Medium
        gs.setDiffMultipler(0.75);
        assertEquals(631, gs.getInitScore());

        // Hard
        gs.setDiffMultipler(1);
        assertEquals(757, gs.getInitScore());
    }

    @Test
    public void testDiffMultiplier() {
        // Tests that harder difficulty rewards players with a higher score
        GameScreen gs = new GameScreen();

        gs.resetScore();

        // Easy
        gs.setDiffMultipler(0.5);
        int initScoreEasy = gs.getInitScore();

        // Medium
        gs.setDiffMultipler(0.75);
        int initScoreMedium = gs.getInitScore();

        // Hard
        gs.setDiffMultipler(1);
        int initScoreHard = gs.getInitScore();

        assertTrue(initScoreEasy < initScoreMedium);
        assertTrue(initScoreMedium < initScoreHard);
    }
}
