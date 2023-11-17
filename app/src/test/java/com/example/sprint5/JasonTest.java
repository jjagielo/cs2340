package com.example.sprint5;

import static com.example.sprint1.ViewModels.GameScreen.getScore;
import static org.junit.Assert.assertEquals;

import com.example.sprint1.ViewModels.GameScreen;

import org.junit.Test;

public class JasonTest {
    @Test
    public void testDiffMultiplier() {
        // Code for test1
        GameScreen gs = new GameScreen();

        assertEquals(1815, getScore());
    }

    @Test
    public void test2() {
        // Code for test2
    }
}
