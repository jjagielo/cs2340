package com.example.sprint1.ViewModels;

import java.util.Calendar;
import java.text.SimpleDateFormat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.widget.Button;
import android.util.DisplayMetrics;
import android.graphics.Bitmap;
import android.graphics.Canvas;

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
    // Door Coordinates
    private float doorX;
    private float doorY;
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

        attempt++;

        initPlayer();

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

        //Door
        door = (ImageView) findViewById(R.id.doorImage);
        door.setImageResource(R.drawable.door_removebg_preview__1_);
        doorX = 0;
        doorY = 0;

        // Run function for movement
        Handler handlerMovement = new Handler();
        Runnable runnableMovement = new Runnable() {
            @Override
            public void run() {
                if (attempt == 1) {
                    if (player.getX() > door.getX() - 80 && player.getX() < door.getX() + 80
                            && player.getY() > door.getY() - 140 && player.getY() < door.getY()
                            + 140) {
                        if (room.getCurrentTileIndex() == 3) {
                            isUpPressed = false;
                            isDownPressed = false;
                            isLeftPressed = false;
                            isRightPressed = false;
                            handler.removeCallbacks(runnable);
                            Intent end = new Intent(GameScreen.this, EndScreen.class);
                            startActivity(end);
                            finish();
                        }
                        room.nextTile();
                        player.notifyPlayer(350, player.getY());
                        player.notifyPlayer(player.getX(), 500);
                        drawRoomBackground();
                    }

                    if (isUpPressed && player.getY() > 10) {
                        player.changePos(player.getX(), player.getY() - 20);
                    }
                    if (isLeftPressed && player.getX() > 250) {
                        player.changePos(player.getX() - 20, player.getY());
                    }
                    if (isDownPressed && player.getY() < screenHeight - 270) {
                        player.changePos(player.getX(), player.getY() + 20);
                    }
                    if (isRightPressed && player.getX() < screenWidth - 300) {
                        player.changePos(player.getX() + 20, player.getY());
                    }
                } else {
                    if (character.getX() > door.getX() - 80 && character.getX() < door.getX() + 80
                            && character.getY() > door.getY() - 140 && character.getY()
                            < door.getY()
                            + 140) {
                        if (room.getCurrentTileIndex() == 3) {
                            isUpPressed = false;
                            isDownPressed = false;
                            isLeftPressed = false;
                            isRightPressed = false;
                            handler.removeCallbacks(runnable);
                            Intent end = new Intent(GameScreen.this, EndScreen.class);
                            startActivity(end);
                            finish();
                        }
                        room.nextTile();
                        character.setX(350);
                        character.setY(500);
                        player.changePos(350, player.getY());
                        player.changePos(player.getX(), 500);
                        drawRoomBackground();
                    }

                    if (isUpPressed && character.getY() > 10) {
                        player.changePos(player.getX(), player.getY() - 20);
                        character.setY(character.getY() - 20);
                    }
                    if (isLeftPressed && character.getX() > 250) {
                        player.changePos(player.getX() - 20, player.getY());
                        character.setX(character.getX() - 20);
                    }
                    if (isDownPressed && character.getY() < screenHeight - 270) {
                        player.changePos(player.getX(), player.getY() + 20);
                        character.setY(character.getY() + 20);
                    }
                    if (isRightPressed && character.getX() < screenWidth - 300) {
                        player.changePos(player.getX() + 20, player.getY());
                        character.setX(character.getX() + 20);
                    }
                }

                handlerMovement.postDelayed(this, 80);
            }
        };
        handlerMovement.postDelayed(runnableMovement, 0);

        movementButtons();
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

    // initialize player's attributes and how they are displayed
    private void initPlayer() {
        // Initialize difficultyText to display difficulty user selected
        TextView difficultyText = (TextView) findViewById(R.id.difficultyTextView);

        // Initialize nameText to display name user inputted
        TextView nameText = (TextView) findViewById(R.id.nameTextView);
        name = getIntent().getStringExtra("playerName");

        // Displays the difficulty user selected as well as health associated with chosen difficulty
        difficulty = getIntent().getDoubleExtra("difficulty", 0.5);


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

        player = Player.getPlayer(name, difficulty, character);

        // Displays health based on difficulty
        TextView healthText = (TextView) findViewById(R.id.healthTextView);
        healthText.setText("Health: " + player.getHealth());
        nameText.setText("Name: " + player.getName());

        if (difficulty == 1) {
            difficultyText.setText("Difficulty: Hard");
        } else if (difficulty == 0.75) {
            difficultyText.setText("Difficulty: Medium");
        } else if (difficulty == 0.5) {
            difficultyText.setText("Difficulty: Easy");
        } // if

    }

    private void movementButtons() {
        //Movement Buttons
        Button upButton = findViewById(R.id.upButton);
        upButton.setOnClickListener(v -> {
            isUpPressed = !isUpPressed;
            if (isDownPressed) {
                isDownPressed = false;
            }
        });
        Button downButton = findViewById(R.id.downButton);
        downButton.setOnClickListener(v -> {
            isDownPressed = !isDownPressed;
            if (isUpPressed) {
                isUpPressed = false;
            }
        });
        Button leftButton = findViewById(R.id.leftButton);
        leftButton.setOnClickListener(v -> {
            isLeftPressed = !isLeftPressed;
            if (isRightPressed) {
                isRightPressed = false;
            }
        });
        Button rightButton = findViewById(R.id.rightButton);
        rightButton.setOnClickListener(v -> {
            isRightPressed = !isRightPressed;
            if (isLeftPressed) {
                isLeftPressed = false;
            }
        });
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
    public float getDoorX() {
        return doorX;
    }

<<<<<<< HEAD
    public float getDoorY() {
        return doorY;
    }
=======
    public float getDoorY() { return doorY;}
>>>>>>> 1f5c174a901b20cdd96883f9c03b18e2b005fc29
  
    public Player getPlayer() {
        return Player.getPlayer(name, difficulty, character);
    }
} // GameScreen
