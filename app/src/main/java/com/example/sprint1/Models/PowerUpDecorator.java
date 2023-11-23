package com.example.sprint1.Models;

import android.widget.ImageView;

public interface PowerUpDecorator{

    public void updatePlayer();

    public int getPowerupID();
    public boolean getActive();
    public void setActive(boolean newActive);
    public float getX(ImageView powerup);
    public float getY(ImageView powerup);
}
