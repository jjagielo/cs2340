package com.example.sprint2.Models;

public class ScoreData {

    private String name;
    private int finalScore;
    private int attempt;
    private String dateTime;

    public ScoreData(String name, int finalScore, int attempt, String dateTime) {
        this.name = name;
        this.finalScore = finalScore;
        this.attempt = attempt;
        this.dateTime = dateTime;
    }

    public String getName() {
        return this.name;
    }
    public String getDateTime() {
        return this.dateTime;
    }


    public int getFinalScore() {
        return this.finalScore;
    }

    public int getAttempt() {
        return this.attempt;
    }

 }