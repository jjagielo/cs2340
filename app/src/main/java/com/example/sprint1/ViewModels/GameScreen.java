package com.example.sprint1.ViewModels;

import java.util.Calendar;
import java.text.SimpleDateFormat;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.widget.Button;
import android.util.DisplayMetrics;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.example.sprint1.Models.Collision;
import com.example.sprint1.Models.Enemy;
import com.example.sprint1.Models.EnemyFactory;
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
    // enemies
    private Enemy enemy1;
    private Enemy enemy2;
    // enemy sprites
    private ImageView enemy1Sprite;
    private ImageView enemy2Sprite;
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
    private static int screenWidth;
    private static int screenHeight;
    private int attackTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Set gamescreen as current screen for user
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen);

        initRoom();
        initPlayer();
        enemy1Sprite = findViewById(R.id.enemyImage1);
        enemy2Sprite = findViewById(R.id.enemyImage2);

        initEnemies();

        attempt++;

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

                if (player.getAttacking()) {
                    attackTimer--;
                    if (attackTimer <= 0) {
                        if (charInt == 1) {
                            character.setImageResource(R.drawable.knight_f_idle_anim_f0);
                        } else if (charInt == 2) {
                            character.setImageResource(R.drawable.elf_f_idle_anim_f0);
                        } else if (charInt == 3) {
                            character.setImageResource(R.drawable.dwarf_f_idle_anim_f3);
                        }

                        player.setAttacking(false);
                    }
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

                TextView healthText = (TextView) findViewById(R.id.healthTextView);
                Collision.checkCollision(GameScreen.this, player, enemy1, enemy2);
                healthText.setText("Health: " + player.getHealth());

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
                        initEnemies();
                        enemy1.changePos(1600, 700);
                        enemy2.changePos(1500, 800);
                        drawRoomBackground();
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
                        initEnemies();
                        enemy1.changePos(1600, 700);
                        enemy2.changePos(1500, 800);
                        drawRoomBackground();
                    }
                }

                if (player.getHealth() <= 0 && player.getActive()) {
                    player.setHealth(100);
                    isUpPressed = false;
                    isDownPressed = false;
                    isLeftPressed = false;
                    isRightPressed = false;
                    handler.removeCallbacks(runnable);
                    Intent end = new Intent(GameScreen.this, EndScreenLoser.class);
                    startActivity(end);
                    finish();
                    player.setActive(false);
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

                updateEnemies();
                enemy1.move();
                enemy2.move();

                handlerMovement.postDelayed(this, 80);
            }
        };
        handlerMovement.postDelayed(runnableMovement, 0);

        movementButtons();
        attackButton();
    } // onCreate

    /*
     * Initializes the room to the size of the device's screen and then calls
     * function to start creating the room onto the screen.
     */
    private void initRoom() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels;
        // Initialize the Room with the screen dimensions
        room = new Room(this, screenWidth, screenHeight);
        // Start drawing the room background
        drawRoomBackground();
    }

    /*
     * Uses the room sprite to create a bitmap. Draws the bitmap to the canvas
     * to visually display to the user.
     */
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

    /*
     * Initialize player's attributes and how they are displayed
     */
    private void initPlayer() {
        player = null;

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

    /*
     * Creates the different enemies for the 3 rooms and initializes how they are displayed
     */
    private void initEnemies() {
        // initialize the type of enemy depending on the current room
        if (room.getCurrentTileIndex() == 0) {
            enemy1 = EnemyFactory.createEnemy(1, difficulty, enemy1Sprite);
            enemy2 = EnemyFactory.createEnemy(2, difficulty, enemy2Sprite);
        } else if (room.getCurrentTileIndex() == 1) {
            enemy1 = EnemyFactory.createEnemy(2, difficulty, enemy1Sprite);
            enemy2 = EnemyFactory.createEnemy(3, difficulty, enemy2Sprite);
        } else if (room.getCurrentTileIndex() == 2) {
            enemy1 = EnemyFactory.createEnemy(3, difficulty, enemy1Sprite);
            enemy2 = EnemyFactory.createEnemy(4, difficulty, enemy2Sprite);
        } else if (room.getCurrentTileIndex() == 3) {
            enemy1 = EnemyFactory.createEnemy(4, difficulty, enemy1Sprite);
            enemy2 = EnemyFactory.createEnemy(1, difficulty, enemy2Sprite);
        }

        enemy1.setActive(true);
        enemy2.setActive(true);

        // display enemies—two per room
        enemy1Sprite.setImageResource(enemy1.getCharacterID());
        enemy2Sprite.setImageResource(enemy2.getCharacterID());
        enemy1Sprite.setAlpha(1f);
        enemy2Sprite.setAlpha(1f);
    }

    private void updateEnemies() {
        if (!enemy1.getActive()) {
            enemy1Sprite.setAlpha(0f);
        }
        if (!enemy2.getActive()) {
            enemy2Sprite.setAlpha(0f);
        }
    }

    /*
     * Implements functionality of the movement buttons on the screen for the user to use
     */
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

    private void attackButton() {
        Button attackButton = findViewById(R.id.attackButton);
        attackButton.setOnClickListener(v -> {
            if (!player.getAttacking()) {
                attackTimer = 1;
                player.setAttacking(true);
                if (charInt == 1) {
                    character.setImageResource(R.drawable.knightsword);
                } else if (charInt == 2) {
                    character.setImageResource(R.drawable.elfsword);
                } else if (charInt == 3) {
                    character.setImageResource(R.drawable.dwarfsword);
                }
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
    public float getDoorY() {
        return doorY;
    } 
    public Player getPlayer() {
        return Player.getPlayer(name, difficulty, character);
    }
    public static int getScreenWidth() {
        return screenWidth;
    }
    public static int getScreenHeight() {
        return screenHeight;
    }
} // GameScreen
