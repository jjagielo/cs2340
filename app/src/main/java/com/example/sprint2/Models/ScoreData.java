package com.example.sprint2.Models;

public class ScoreData {

    private String name;
    private int finalScore;
    private String attempt;

    public ScoreData(String name, int finalScore, String attempt) {
        this.name = name;
        this.finalScore = finalScore;
        this.attempt = attempt;
    }

    public String getName() {
        return this.name;
    }

    public int getFinalScore() {
        return this.finalScore;
    }

    public String getAttempt() {
        return this.attempt;
    }

 }