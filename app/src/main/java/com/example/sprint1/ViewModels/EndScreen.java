package com.example.sprint1.ViewModels;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.sprint1.R;

public class EndScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // displaying the end screen xml file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endscreen);

        // instantiating the return button
        Button end = findViewById(R.id.returnButton);

        // sending the player to the launch screen when the button is pressed
        end.setOnClickListener(v -> {
            Intent start = new Intent(this, LaunchScreen.class);
            startActivity(start);
            finish();
        });
    }
}