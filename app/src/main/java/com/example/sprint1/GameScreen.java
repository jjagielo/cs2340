package com.example.sprint1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.widget.Button;


public class GameScreen extends Activity {

    //Difficulty Property
    double difficulty;
    // Character Sprite
    ImageView character;
    // Character Selection
    int charInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Set gamescreen as current screen for user
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen);
        // Initialize difficultyText to display difficulty user selected
        TextView difficultyText = (TextView) findViewById(R.id.difficultyTextView);

        // Initialize nameText to display name user inputted
        TextView nameText = (TextView) findViewById(R.id.nameTextView);
        String name = getIntent().getStringExtra("playerName");
        nameText.setText("Name: " + name);

        // Displays the difficulty user selected as well as health associated with chosen difficulty
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

        // Changes the sprite to the one user selected
        character = (ImageView) findViewById(R.id.characterImage);
        charInt = getIntent().getIntExtra("character", 1);
        if (charInt == 1) {
            character.setImageResource(R.drawable.knight_f_idle_anim_f0);
        } else if (charInt == 2) {
            character.setImageResource(R.drawable.elf_f_idle_anim_f0);
        } else if (charInt == 3) {
            character.setImageResource(R.drawable.dwarf_f_idle_anim_f3);
        } // if

        // Displays health based on difficulty
        TextView healthText = (TextView) findViewById(R.id.healthTextView);
        healthText.setText("Health: " + health);

        // Implements endButton functionality to send user to endscreen
        Button endButton = findViewById(R.id.endScreenButton);
        endButton.setOnClickListener(v -> {
            Intent end = new Intent(GameScreen.this, EndScreen.class);
            startActivity(end);
            finish();
        }); // endButton

    } // onCreate
} // GameScreen
