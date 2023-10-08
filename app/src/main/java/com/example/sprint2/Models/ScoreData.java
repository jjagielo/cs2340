package com.example.sprint2.Models;

public class ScoreData {

    private String name;
    private int score;
    private String attempt;

    public ScoreData(String name, int score, String attempt) {
        this.name = name;
        this.score = score;
        this.attempt = attempt;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public int getAttempt() {
        return this.attempt;
    }

 }