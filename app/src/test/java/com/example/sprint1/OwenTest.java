package com.example.sprint1;

import static junit.framework.TestCase.assertEquals;

import com.example.sprint1.Models.Leaderboard;
import com.example.sprint1.Models.ScoreData;

import org.junit.Test;

public class OwenTest {
    @Test
    public void testArrayAttempts() {
        Leaderboard lbrd = Leaderboard.getinstance();

        ScoreData score1 = new ScoreData("Jason", 75, 1, "");
        ScoreData score2 = new ScoreData("Owen", 35, 2, "");
        ScoreData score3 = new ScoreData("Aden", 100, 3, "");

        lbrd.addScore(score1);
        lbrd.addScore(score2);
        lbrd.addScore(score3);

        assertEquals(3, lbrd.getAttempt(0));
        assertEquals(1, lbrd.getAttempt(1));
        assertEquals(2, lbrd.getAttempt(2));
    }

    @Test
    public void testName() {
        Leaderboard lbrd = Leaderboard.getinstance();

        ScoreData score1 = new ScoreData("Jason", 75, 1, "");
        ScoreData score2 = new ScoreData("Owen", 35, 2, "");
        ScoreData score3 = new ScoreData("Aden", 100, 3, "");

        lbrd.addScore(score1);
        lbrd.addScore(score2);
        lbrd.addScore(score3);

        assertEquals("Aden", lbrd.getName(0));
        assertEquals("Jason", lbrd.getName(1));
        assertEquals("Owen", lbrd.getName(2));
    }
}
