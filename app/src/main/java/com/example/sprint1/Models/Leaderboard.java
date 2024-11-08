package com.example.sprint1.Models;

import java.util.List;
import java.util.ArrayList;

public class Leaderboard {
    private List<ScoreData> leaderboard;

    private static Leaderboard instance;


    private Leaderboard() {
        leaderboard = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            leaderboard.add(new ScoreData("Default", 0, 0, ""));
        }
    }

    /*
     * Utilizes the singleton design pattern to return the only existing instance of the
     * leaderboard object
     *
     * @return Leaderboard the Leaderboard object
     */
    public static Leaderboard getinstance() {
        if (instance == null) {
            synchronized (Leaderboard.class) {
                if (instance == null) {
                    instance = new Leaderboard();
                }
            }
        }
        return instance;
    }

    public List<ScoreData> getLeaderboard() {
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
    public String getName(int index) {
        return this.leaderboard.get(index).getName();
    }

    public int getAttempt(int index) {
        return this.leaderboard.get(index).getAttempt();
    }

    public String getDateTime(int index) {
        return this.leaderboard.get(index).getDateTime();
    }
    
}