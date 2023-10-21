package com.example.sprint1.ViewModels;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.sprint1.R;
import com.example.sprint1.Models.Leaderboard;
import com.example.sprint1.Models.ScoreData;

public class EndScreenLoser extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // displaying the end screen xml file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endscreen_loser);

        // instantiating the return button
        Button end = findViewById(R.id.returnButton);

        // Find the TextView by its ID
        TextView recentScore = findViewById(R.id.recentScoreText);
        TextView lbrd1 = findViewById(R.id.leaderboard1Text);
        TextView lbrd2 = findViewById(R.id.leaderboard2Text);
        TextView lbrd3 = findViewById(R.id.leaderboard3Text);
        TextView lbrd4 = findViewById(R.id.leaderboard4Text);
        TextView lbrd5 = findViewById(R.id.leaderboard5Text);


        //Set recent score
        Leaderboard.getinstance().addScore(new ScoreData(GameScreen.getName(),
                GameScreen.getScore(), GameScreen.getAttempt(), GameScreen.getDateTime()));


        // Set leaderboard programmatically
        recentScore.setText("Most recent attempt: " + GameScreen.getName() + ", "
                + GameScreen.getScore() + ", Attempt: " + GameScreen.getAttempt() + ", "
                + GameScreen.getDateTime());
        lbrd1.setText("1st: " + getName(0) + ", " + getScore(0) + ", Attempt: "
                + getAttempt(0) + ", " + getDateTime(0));
        lbrd2.setText("2nd: " + getName(1) + ", " + getScore(1) + ", Attempt: "
                + getAttempt(1) + ", " + getDateTime(1));
        lbrd3.setText("3rd: " + getName(2) + ", " + getScore(2) + ", Attempt: "
                + getAttempt(2) + ", " + getDateTime(2));
        lbrd4.setText("4th: " + getName(3) + ", " + getScore(3) + ", Attempt: "
                + getAttempt(3) + ", " + getDateTime(3));
        lbrd5.setText("5th: " + getName(4) + ", " + getScore(4) + ", Attempt: "
                + getAttempt(4) + ", " + getDateTime(4));

        //Reset Score on game screen for next attempt
        GameScreen.resetScore();


        // sending the player to the launch screen when the button is pressed
        end.setOnClickListener(v -> {
            Intent start = new Intent(EndScreenLoser.this, LaunchScreen.class);
            startActivity(start);
            finish();
        });
    }

    private int getScore(int index) {
        return Leaderboard.getinstance().getLeaderboard().get(index).getFinalScore();
    }
    private int getAttempt(int index) {
        return Leaderboard.getinstance().getLeaderboard().get(index).getAttempt();
    }
    private String getName(int index) {
        return Leaderboard.getinstance().getLeaderboard().get(index).getName();
    }
    private String getDateTime(int index) {
        return Leaderboard.getinstance().getLeaderboard().get(index).getDateTime();
    }
}