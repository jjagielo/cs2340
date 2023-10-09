package com.example.sprint1.ViewModels;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.util.*;

import com.example.sprint1.R;

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
        TextView lbrd1 = findViewById(R.id.leaderboard1text);
        TextView lbrd2 = findViewById(R.id.leaderboard2text);
        TextView lbrd3 = findViewById(R.id.leaderboard3text);
        TextView lbrd4 = findViewById(R.id.leaderboard4text);
        TextView lbrd5 = findViewById(R.id.leaderboard5text);

        // Set leaderboard programmatically
        recentScore.setText("Most recent attempt: ");
        lbrd1.setText("1st: ");
        lbrd2.setText("2nd: ");
        lbrd3.setText("3rd: ");
        lbrd4.setText("4th: ");
        lbrd5.setText("5th: ");
        


        // sending the player to the launch screen when the button is pressed
        end.setOnClickListener(v -> {
            Intent start = new Intent(this, LaunchScreen.class);
            startActivity(start);
            finish();
        });
    }
}