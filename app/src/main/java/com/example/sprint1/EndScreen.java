package com.example.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class EndScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // displaying the end screen xml file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endscreen);

        // instantiating the retun button
        Button end = findViewById(R.id.returnButton);

        // sending the player to the launch screen when the button is pressed
        end.setOnClickListener(v -> {
            Intent start = new Intent(this, LaunchScreen.class);
            startActivity(start);
            finish();
        });
    }
}