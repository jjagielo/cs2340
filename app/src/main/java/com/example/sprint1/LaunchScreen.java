package com.example.sprint1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class LaunchScreen extends Activity {

    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launchscreen);

        start = findViewById(R.id.StartButton);

        start.setOnClickListener(v -> {
            Intent config = new Intent(this, InitialConfiguration.class);
            startActivity(config);
            finish();
        });
    }
}