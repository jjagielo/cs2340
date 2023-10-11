package com.example.sprint1;


import static junit.framework.TestCase.assertEquals;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;


import com.example.sprint1.Models.Player;
import com.example.sprint2.Models.Leaderboard;
import com.example.sprint2.Models.ScoreData;

import org.junit.Test;



public class TejaTest {

    @Test
    public void testGetDateTime() {
        Leaderboard leaderboard = Leaderboard.getinstance();

        // create a sample ScoreData with a known date
        ScoreData sampleScore = new ScoreData("TestPlayer", 100, 1, "2023-10-11 14:30:00");

        leaderboard.addScore(sampleScore);

        String leaderboardDate = leaderboard.getDateTime(0); //first entry
        assertNotNull(leaderboardDate);
        assertEquals("2023-10-11 14:30:00", leaderboardDate); // expected date

    }


    @Test
    public void testGetPlayer() {
        // get the player for the first time
        Player firstPlayer = Player.getPlayer("Alice", 100);

        // player is not null
        assertNotNull(firstPlayer);
        assertEquals("Alice", firstPlayer.getName());
        assertEquals(100, firstPlayer.getHealth());

        // get the player again
        Player secondPlayer = Player.getPlayer("Bob", 150);

        // make sure that the second player is the same as the first (singleton)
        assertSame(firstPlayer, secondPlayer);
    }





}
