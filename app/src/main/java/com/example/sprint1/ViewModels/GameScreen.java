package com.example.sprint1.ViewModels;

import java.util.Calendar;
import java.text.SimpleDateFormat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.widget.Button;
import android.util.DisplayMetrics;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.KeyEvent;

import androidx.compose.ui.graphics.Outline;

import com.example.sprint1.Models.Player;
import com.example.sprint1.R;
import com.example.sprint1.Models.Room;

public class GameScreen extends Activity {

    //Difficulty Property
    private double difficulty;
    private Boolean isUpPressed = false;
    private Boolean isDownPressed = false;
    private Boolean isLeftPressed = false;
    private Boolean isRightPressed = false;
    // Character Sprite
    private ImageView character;
    private Player player;
    //Door sprite
    private ImageView door;
    // Character Selection
    private int charInt;
    // Player score
    private static int score;
    //number of attempts
    private static int attempt;
    private static String name;
    private int healthInt;
    private static String dateTime;
    private Room room;
    private int screenWidth;
    private int screenHeight;

    public GameScreen() {
        player = Player.getPlayer("playerName", 100);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Set gamescreen as current screen for user
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels;


        // Initialize the Room with the screen dimensions
        room = new Room(this, screenWidth, screenHeight);
        // Start drawing the room background
        drawRoomBackground();

        // Initialize difficultyText to display difficulty user selected
        TextView difficultyText = (TextView) findViewById(R.id.difficultyTextView);
        attempt++;

        // Initialize nameText to display name user inputted
        TextView nameText = (TextView) findViewById(R.id.nameTextView);
        name = getIntent().getStringExtra("playerName");
        nameText.setText("Name: " + name);

        // Displays the difficulty user selected as well as health associated with chosen difficulty
        difficulty = getIntent().getDoubleExtra("difficulty", 0.5);
        String health = "100";
        if (difficulty == 1) {
            difficultyText.setText("Difficulty: Hard");
            health = "100";
            healthInt = 100;
        } else if (difficulty == 0.75) {
            difficultyText.setText("Difficulty: Medium");
            health = "150";
            healthInt = 150;
        } else if (difficulty == 0.5) {
            difficultyText.setText("Difficulty: Easy");
            health = "200";
            healthInt = 200;
        } // if

        //Door
        door = (ImageView) findViewById(R.id.doorImage);
        door.setImageResource(R.drawable.door_removebg_preview__1_);

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

        player = Player.getPlayer(name, healthInt);

        // Displays health based on difficulty
        TextView healthText = (TextView) findViewById(R.id.healthTextView);
        healthText.setText("Health: " + health);

        // displays the score and decrements it every 2 seconds
        TextView scoreText = findViewById(R.id.scoreTextView);
        score = 100;

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                scoreText.setText("Score: " + score);
                if (score > 0) {
                    score -= 5;
                }
                handler.postDelayed(this, 2000);
            }
        };
        handler.postDelayed(runnable, 0);

        // Get the current date and time
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        dateTime = dateFormat.format(calendar.getTime());


        //temporary next button for the tiles
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(v -> {
            // Handle "Next" button click
            room.nextTile();
            character.setX(350);
            character.setY(500);
            drawRoomBackground();
        });

        // Run function for movement
        Handler handlerMovement = new Handler();
        Runnable runnableMovement = new Runnable() {
            @Override
            public void run() {

                if(character.getX() > door.getX()-80 && character.getX() < door.getX()+80 &&
                    character.getY() > door.getY()-140 && character.getY() < door.getY()+140){
                    room.nextTile();
                    character.setX(350);
                    character.setY(500);
                    drawRoomBackground();
                }

                if (isUpPressed && character.getY() > 10) {
                    character.setY(character.getY() - 20);
                }
                if (isLeftPressed && character.getX() > 250) {
                    character.setX(character.getX() - 20);
                }
                if (isDownPressed && character.getY() < screenHeight - 270) {
                    character.setY(character.getY() + 20);
                }
                if (isRightPressed && character.getX() < screenWidth - 300) {
                    character.setX(character.getX() + 20);
                }



                handlerMovement.postDelayed(this, 80);
            }




        };
        handlerMovement.postDelayed(runnableMovement, 0);

        //Movement Buttons
        Button upButton = findViewById(R.id.upButton);
        upButton.setOnClickListener(v -> {
           isUpPressed = !isUpPressed;
           if(isDownPressed){
               isDownPressed = false;
           }
        });
        Button downButton = findViewById(R.id.downButton);
        downButton.setOnClickListener(v -> {
            isDownPressed = !isDownPressed;
            if(isUpPressed){
                isUpPressed = false;
            }
        });
        Button leftButton = findViewById(R.id.leftButton);
        leftButton.setOnClickListener(v -> {
            isLeftPressed = !isLeftPressed;
            if(isRightPressed){
                isRightPressed = false;
            }
        });
        Button rightButton = findViewById(R.id.rightButton);
        rightButton.setOnClickListener(v -> {
            isRightPressed = !isRightPressed;
            if(isLeftPressed){
                isLeftPressed = false;
            }
        });

        //Movement key inputs




        // Implements endButton functionality to send user to endscreen
        Button endButton = findViewById(R.id.endScreenButton);
        endButton.setOnClickListener(v -> {
            handler.removeCallbacks(runnable);
            Intent end = new Intent(GameScreen.this, EndScreen.class);
            startActivity(end);
            finish();
        }); // endButton

    } // onCreate


    private void drawRoomBackground() {
        // Create a Bitmap to draw the room background
        Bitmap roomBitmap = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(roomBitmap);

        // Draw the room on the canvas (Replace with your Room class logic)
        room.draw(canvas);

        // Find the ImageView for the roomCanvas
        ImageView roomCanvas = findViewById(R.id.roomCanvas);

        // Set the Bitmap as the source for the ImageView
        roomCanvas.setImageBitmap(roomBitmap);
    }

    public static int getScore() {
        return score;
    }
    public static void resetScore() {
        score = 100;
    }
    public static int getAttempt() {
        return attempt;
    }
    public static String getName() {
        return name;
    }
    public static String getDateTime() {
        return dateTime;
    }
    public Player getPlayer() {
        return player;
    }



} // GameScreen
