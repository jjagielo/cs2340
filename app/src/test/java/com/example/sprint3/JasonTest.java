package com.example.sprint3;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


import com.example.sprint1.ViewModels.GameScreen;


public class JasonTest {

    @Test
    public void testDoorX() {
        GameScreen gs = new GameScreen();

        float x = gs.getDoorX();

        assertEquals(0f, x, 0f);
    }

    @Test
    public void testDoorY() {
        GameScreen gs = new GameScreen();

        float y = gs.getDoorY();

        assertEquals(0f, y, 0f);
    }
}