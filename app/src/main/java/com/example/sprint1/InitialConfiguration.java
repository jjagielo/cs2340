package com.example.sprint1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;

public class InitialConfiguration extends AppCompatActivity {

    EditText name;
    Button continueBtn;
    int hp, character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_config);

        name = findViewById(R.id.editTextName);
        continueBtn = findViewById(R.id.continueBtn);

        continueBtn.setOnClickListener(v -> {
            Intent game = new Intent(this, GameScreen.class);
            startActivity(game);
            finish();
        });
    }

    //difficulty settings
    public void buttonClicked(View view) {

        if (view.getId() == R.id.button1) {
            hp = 5;
        } else if (view.getId() == R.id.button2) {
            hp = 4;
        } else if (view.getId() == R.id.button3) {
            hp = 3;
        }

        if (view.getId() == R.id.imageButton) {
            character = 1;
        } else if (view.getId() == R.id.imageButton2) {
            character = 2;
        } else if (view.getId() == R.id.imageButton3) {
            character = 3;
        }

    }
}
