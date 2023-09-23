package com.example.sprint1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioGroup;

public class InitialConfiguration extends Activity {

    EditText name;
    Button continueBtn;
    boolean isAllFieldsChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_config);

        name = findViewById(R.id.editTextName);
        continueBtn = findViewById(R.id.continueBtn);
        isAllFieldsChecked = false;

        continueBtn.setOnClickListener(v -> {
            isAllFieldsChecked = checkAllFields();

            RadioGroup difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup);
            double difficulty = 1;

            int checkedDifficulty = difficultyRadioGroup.getCheckedRadioButtonId();
            if (checkedDifficulty == R.id.radioButton1) {
                difficulty = 0.5;
            } else if (checkedDifficulty == R.id.radioButton2) {
                difficulty = 0.75;
            } else if (checkedDifficulty == R.id.radioHard) {
                difficulty = 1;
            } else {
                difficulty = 0.5;
            }

            RadioGroup characterRadioGroup = findViewById(R.id.characterRadioGroup);
            int character = 1;
            if (characterRadioGroup.getCheckedRadioButtonId() == R.id.character1) {
                character = 1;
            } else if (characterRadioGroup.getCheckedRadioButtonId() == R.id.character2) {
                character = 2;
            } else if (characterRadioGroup.getCheckedRadioButtonId() == R.id.character3) {
                character = 3;
            }


            Log.d("character", "Value: " + Integer.toString(character));

            if (isAllFieldsChecked) {
                Intent game = new Intent(InitialConfiguration.this, GameScreen.class);
                game.putExtra("difficulty", difficulty);
                game.putExtra("character", character);
                game.putExtra("playerName", String.valueOf(name.getText()));
                startActivity(game);
                finish();
            }
        });
    }

    private boolean checkAllFields() {
        if (name.length() == 0 || name == null || !(name.toString().trim().length() > 0)) {
            name.setError("Must input a valid name!");
            return false;
        }

        return true;
    }
}
