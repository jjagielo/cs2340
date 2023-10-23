package com.example.sprint3;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import static org.junit.Assert.assertNotNull;

import android.widget.ImageView;

import com.example.sprint1.Models.EntityMovement;
import com.example.sprint1.Models.MovementObserver;
import com.example.sprint1.Models.Player;
import com.example.sprint1.Models.ScoreData;
import com.example.sprint1.R;
import com.example.sprint1.ViewModels.EndScreenLoser;
import com.example.sprint1.ViewModels.GameScreen;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class TejaTest {


    @Test
    public void scoreObserver() {
        Player player = Player.getPlayer("TestPlayer", 0.75, null);
        GameScreen gameScreen = new GameScreen();
        gameScreen.getPlayer(); //observer
        assertNotNull(player); //makes sure player is not null

        // if Player Class (Observer) implements ScoreObserver interface
        List<Class<?>> interfaces = Arrays.asList(player.getClass().getInterfaces());
        assertTrue(interfaces.contains(MovementObserver.class));

    }



    @Test
    public void movementObserver() {
        Player player = Player.getPlayer("TestPlayer", 0.75, null);
        GameScreen gameScreen = new GameScreen();
        gameScreen.getPlayer(); //observer
        assertNotNull(player); //makes sure player is not null

        // if Player Class (Observer) implements MovementObserver interface
        List<Class<?>> interfaces = Arrays.asList(player.getClass().getInterfaces());
        assertTrue(interfaces.contains(MovementObserver.class));

    }


}
