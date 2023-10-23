package com.example.sprint3;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import android.widget.ImageView;

import com.example.sprint1.Models.Player;
import com.example.sprint1.Models.Room;
import com.example.sprint1.R;
import com.example.sprint1.ViewModels.GameScreen;

import org.junit.Test;

public class OwenTest {
    @Test
    public void test1() {


        int playerX = 0;
        int playerY = 0;
        int doorX = 80;
        int doorY = 140;

        assertFalse(playerX > doorX - 80);
        assertFalse(playerY > doorY - 140);

        playerX = 160;
        playerY = 280;

        assertFalse(playerX < doorX + 80);
        assertFalse(playerY < doorY + 140);


    }

    @Test
    public void test2() {
        int playerX = 500;
        int playerY = 500;
        int doorX = 150;
        int doorY = 250;



        assertFalse(playerX < doorX + 80);
        assertFalse(playerY < doorY + 140);

        playerX = 200;
        playerY = 200;

        assertTrue(playerX > doorX - 80);
        assertTrue(playerX < doorX + 80);
        assertTrue(playerY > doorY - 140);
        assertTrue(playerY < doorY + 140);
    }
}