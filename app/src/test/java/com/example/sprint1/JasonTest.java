package com.example.sprint1;

import static junit.framework.TestCase.assertEquals;

import com.example.Models.Leaderboard;
import com.example.Models.ScoreData;

import org.junit.Test;

public class JasonTest {
    @Test
    public void testArrayOrdering() {
        Leaderboard lbrd = Leaderboard.getinstance();

        ScoreData score1 = new ScoreData("Jason", 75, 1, "Att. 1");
        ScoreData score2 = new ScoreData("Jason", 35, 2, "Att. 2");
        ScoreData score3 = new ScoreData("Jason", 100, 3, "Att. 3");

        lbrd.addScore(score1);
        lbrd.addScore(score2);
        lbrd.addScore(score3);

        assertEquals(100, lbrd.getScore(0));
        assertEquals(75, lbrd.getScore(1));
        assertEquals(35, lbrd.getScore(2));
    }

    @Test
    public void testInitLeaderboardSize() {
        Leaderboard lbrd = Leaderboard.getinstance();

        assertEquals(5, lbrd.getLeaderboard().size());
    }
}