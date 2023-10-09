package com.example.sprint2.Models;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Leaderboard {
    private List<ScoreData> leaderboard;

    private static Leaderboard instance;
    
    public Leaderboard() {
        leaderboard = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            leaderboard.add(new ScoreData(null, 0, 0));
        }
    }

    public static Leaderboard getinstance() {
        if (instance == null) {
            synchronized(Leaderboard.class) {
                if (instance == null) {
                    instance = new Leaderboard();
                }
            }
        }
        return instance;
    }

    public List<ScoreData> getLeaderboard(){
        return leaderboard;
    }

    public void addScore(ScoreData newScore) {
        boolean inserted = false;

        for (int i = 0; i < leaderboard.size(); i++) {
            if (newScore.getFinalScore() > leaderboard.get(i).getFinalScore()) {
                leaderboard.add(i, newScore);
                inserted = true;
                break;
            }
        }

        if (!(inserted)) {
            leaderboard.add(newScore);
        }
        
    }

    public int getScore(int index) {
        return this.leaderboard.get(index).getFinalScore();
    }
    
}