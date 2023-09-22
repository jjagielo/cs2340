package com.example.sprint1;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.app.Activity;
import android.widget.EditText;
import android.widget.Button;


public class GameScreen extends Activity {
    //Difficulty Property
    private double difficulty;

    private EditText playerName;
    private EditText playerDifficulty;
    int screenWidth;
    int screenHeight;

    // Player's Position
    private float playerX, playerY;
    RelativeLayout gameLayout;

    private PlayerView playerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen);
        TextView difficultyText = (TextView) findViewById(R.id.difficultyTextView);

        if (difficulty == 1) {
            difficultyText.setText("Difficulty: Hard");
        } else if (difficulty == 0.75) {
            difficultyText.setText("Difficulty: Medium");
        } else if (difficulty == 0.5) {
            difficultyText.setText("Difficulty: Easy");
        } // if


        gameLayout = findViewById(R.id.gameScreen);

        playerX = screenWidth / 2;
        playerY = screenHeight / 2;

        difficulty = getIntent().getDoubleExtra("difficulty", 0.5);

        playerView = new PlayerView(this, playerX, playerY, 100);
        gameLayout.addView(playerView);


        Button endButton = findViewById(R.id.endScreenButton);
        endButton.setOnClickListener(v -> {
            Intent end = new Intent(this, EndScreen.class);
            startActivity(end);
            finish();
        });

    } // onCreate

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                playerX += 50;
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                playerX -= 50;
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                playerY -= 50;
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                playerY += 50;
                break;
        } // switch
        playerView.updatePosition(playerX, playerY);
        return true;
    } // OnKeyDown

} // GameScreen
