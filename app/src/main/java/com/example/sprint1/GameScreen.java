package com.example.sprint1;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.app.Activity;
import android.widget.EditText;
import android.widget.Button;


public class GameScreen extends Activity {
    //Difficulty Property
    double difficulty;

    private EditText playerDifficulty;
    int screenWidth;
    int screenHeight;

    // Player's Position
    private float playerX, playerY;
    RelativeLayout gameLayout;

    private PlayerView playerView;
    ImageView character;
    int charInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen);
        TextView difficultyText = (TextView) findViewById(R.id.difficultyTextView);

        TextView nameText = (TextView) findViewById(R.id.nameTextView);
        String name = getIntent().getStringExtra("playerName");
        nameText.setText("Name: " + name);

        difficulty = getIntent().getDoubleExtra("difficulty", 0.5);
        String health = "100";
        if (difficulty == 1) {
            difficultyText.setText("Difficulty: Hard");
            health = "100";
        } else if (difficulty == 0.75) {
            difficultyText.setText("Difficulty: Medium");
            health = "150";
        } else if (difficulty == 0.5) {
            difficultyText.setText("Difficulty: Easy");
            health = "200";
        } // if

        character = (ImageView) findViewById(R.id.characterImage);
        charInt = getIntent().getIntExtra("character", 1);
        if (charInt == 1) {
            character.setImageResource(R.drawable.knight_f_idle_anim_f0);
        } else if (charInt == 2) {
            character.setImageResource(R.drawable.elf_f_idle_anim_f0);
        } else if (charInt == 3) {
            character.setImageResource(R.drawable.dwarf_f_idle_anim_f3);
        } // if

        TextView healthText = (TextView) findViewById(R.id.healthTextView);
        healthText.setText("Health: " + health);


        gameLayout = findViewById(R.id.gameScreen);

        playerX = screenWidth / 2;
        playerY = screenHeight / 2;

        difficulty = getIntent().getDoubleExtra("difficulty", 0.5);

        playerView = new PlayerView(this, playerX, playerY, 50);
        gameLayout.addView(playerView);


        Button endButton = findViewById(R.id.endScreenButton);
        endButton.setOnClickListener(v -> {
            Intent end = new Intent(this, EndScreen.class);
            startActivity(end);
            finish();
        }); // endButton

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
