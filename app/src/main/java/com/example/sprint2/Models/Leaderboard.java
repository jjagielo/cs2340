package com.example.sprint2.Models;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Leaderboard {
    private List<ScoreData> leaderboard;

    private static Leaderboard instance;
    
    private Leaderboard() {
        leaderboard = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            leaderboard.addScore(new ScoreData(null, 0, null));
        }
    }

    public static Leaderboard getLeaderboard() {
        if (leaderboard == null) {
            synchronized(Leaderboard.class) {
                if (leaderboard == null) {
                    leaderboard = new Leaderboard();
                }
            }
        }
        return leaderboard;
    }

    public void addScore(ScoreData newScore) {
        boolean inserted = false;

        for (int i = 0; i < leaderboard.size(); i++) {
            if (newScore.getScore() > leaderboard.get(i).getScore()) {
                leaderboard.add(i, newScore);
                inserted = true;
                break;
            }
        }

        if (!(inserted)) {
            leaderboard.add(newScore);
        }
        
    }

    public ScoreData getScore(int index) {
        return this.leaderboard.get(index);
    }
    
}