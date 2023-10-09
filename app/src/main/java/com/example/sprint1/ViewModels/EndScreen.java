package com.example.sprint1.ViewModels;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.util.*;

import com.example.sprint1.R;
import com.example.sprint2.Models.Leaderboard;
import com.example.sprint2.Models.ScoreData;

public class EndScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // displaying the end screen xml file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endscreen);

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
        Leaderboard.getinstance().addScore(new ScoreData(null, GameScreen.getScore(), GameScreen.getAttempt()));


        // Set leaderboard programmatically
        recentScore.setText("Most recent attempt: " + GameScreen.getScore());
        lbrd1.setText("1st: " + getScore(0));
        lbrd2.setText("2nd: " + getScore(1));
        lbrd3.setText("3rd: " + getScore(2));
        lbrd4.setText("4th: " + getScore(3));
        lbrd5.setText("5th: " + getScore(4));

        //Reset Score on game screen for next attempt
        GameScreen.resetScore();


        // sending the player to the launch screen when the button is pressed
        end.setOnClickListener(v -> {
            Intent start = new Intent(this, LaunchScreen.class);
            startActivity(start);
            finish();
        });
    }

    private int getScore(int index){
        return Leaderboard.getinstance().getLeaderboard().get(index).getFinalScore();
    }
}