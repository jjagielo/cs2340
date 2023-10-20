package com.example.sprint3;
import static junit.framework.TestCase.assertEquals;
import com.example.sprint1.ViewModels.GameScreen;

import org.junit.Test;

public class AdenTest {
    @Test
    public void testInitX() {
        GameScreen gc = new GameScreen();

        assertEquals(gc.getPlayer().getX(), 0.0, 0.0f);
    }

    @Test
    public void testInitY() {
        GameScreen gc = new GameScreen();

        assertEquals(gc.getPlayer().getY(), 0.0, 0.0f);
    }
}
