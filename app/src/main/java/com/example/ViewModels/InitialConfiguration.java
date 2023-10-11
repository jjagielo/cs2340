package com.example.ViewModels;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.sprint1.R;

public class InitialConfiguration extends Activity {

    private EditText name;
    private boolean isAllFieldsChecked;

    public InitialConfiguration(EditText name) {
        this.name = name;
    }
    public InitialConfiguration(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // displaying the initial configuration xml file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_config);

        // instantiating the text field and buttons
        name = findViewById(R.id.editTextName);
        Button continueBtn = findViewById(R.id.continueBtn);
        isAllFieldsChecked = false;

        continueBtn.setOnClickListener(v -> {
            isAllFieldsChecked = checkAllFields();

            // instantiating the radio button group
            RadioGroup difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup);
            double difficulty = 1;

            // allowing the player to select their difficulty
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

            // allowing the player to select their character sprite
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

            // if the player inputted a correct name, send them to the game screen
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

    // checks if the user inputted a proper name, else throw an error
    private boolean checkAllFields() {
        if (name.length() == 0 || name == null || !(name.toString().trim().length() > 0)) {
            name.setError("Must input a valid name!");
            return false;
        }

        return true;
    }

    public boolean getIsAllFieldsChecked() {
        return isAllFieldsChecked;
    }
}
