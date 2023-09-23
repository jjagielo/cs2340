package com.example.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class EndScreen extends Activity {

    Button end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endscreen);

        end = findViewById(R.id.returnButton);

        end.setOnClickListener(v -> {
            Intent start = new Intent(this, LaunchScreen.class);
            startActivity(start);
            finish();
        });
    }
}