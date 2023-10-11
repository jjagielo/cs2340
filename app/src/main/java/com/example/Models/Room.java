package com.example.Models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.sprint1.R;

public class Room {
    private Bitmap[] backgrounds;
    private Rect backgroundRect;
    private int currentTileIndex;

    public Room(Context context, int screenWidth, int screenHeight) {
        // Load the TMX background images from assets
        backgrounds = new Bitmap[4];
        backgrounds[0] = loadBackgroundImage(context, R.drawable.tile1);
        backgrounds[1] = loadBackgroundImage(context, R.drawable.tile2);
        backgrounds[2] = loadBackgroundImage(context, R.drawable.tile3);
        backgrounds[3] = loadBackgroundImage(context, R.drawable.tile4);

        // Set the dimensions and position of the initial background (tile1)
        backgroundRect = new Rect(0, 0, screenWidth, screenHeight);
        currentTileIndex = 0; // Start with tile1
    }

    private Bitmap loadBackgroundImage(Context context, int resourceId) {
        // Load the background image from the resources
        return BitmapFactory.decodeResource(context.getResources(), resourceId);
    }

    public void draw(Canvas canvas) {
        // Draw the current background on the canvas
        canvas.drawBitmap(backgrounds[currentTileIndex], null, backgroundRect, null);
    }

    public void nextTile() {
        // Cycle to the next background tile
        currentTileIndex = (currentTileIndex + 1) % backgrounds.length;
    }
}
