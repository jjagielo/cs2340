package com.example.sprint1.ViewModels;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.sprint1.R;

public class LaunchScreen extends Activity {

    /*
     * Method to initialize and display the LaunchScreen class and its respective xml file
     * to the user. This xml file is to the user when the app is launched and contains the
     * start and exit buttons.
     *
     * @param savedInstanceState the data being passed into current activity from the previous
     *                           activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // displaying the launch screen xml file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launchscreen);
        System.out.print("created");

        // instantiating the start and quit buttons
        Button start = findViewById(R.id.StartButton);
        Button quit = findViewById(R.id.QuitButton);

        // sends the player to different screens depending on the pressed button
        // to the initial configuration screen
        start.setOnClickListener(v -> {
            System.out.print("start clicked");
            Intent config = new Intent(LaunchScreen.this, InitialConfiguration.class);
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