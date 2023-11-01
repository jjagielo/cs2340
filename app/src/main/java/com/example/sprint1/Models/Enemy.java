package com.example.sprint1.Models;

import android.widget.ImageView;

public interface Enemy extends EntityMovement {
    int getHealth();
    double getDifficulty();
    int getCharacterID();
    float getMovementSpeed();
    float getX();
    float getY();
    void setHealth(int newHealth);
    void setCharacter(ImageView charc);
    void setX(float x);
    void setY(float y);
    boolean isAlive = true;
}
