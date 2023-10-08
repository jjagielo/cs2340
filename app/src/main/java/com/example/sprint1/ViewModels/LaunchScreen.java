package com.example.sprint1.ViewModels;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.sprint1.R;
import com.example.sprint1.ViewModels.InitialConfiguration;

public class LaunchScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // displaying the launch screen xml file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launchscreen);

        // instantiating the start and quit buttons
        Button start = findViewById(R.id.StartButton);
        Button quit = findViewById(R.id.QuitButton);

        // sends the player to different screens depending on the pressed button
        // to the initial configuration screen
        start.setOnClickListener(v -> {
            Intent config = new Intent(this, InitialConfiguration.class);
            startActivity(config);
            finish();
        });
        // to quit the game
        quit.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });
    }
}