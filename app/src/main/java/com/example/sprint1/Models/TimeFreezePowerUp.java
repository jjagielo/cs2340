package com.example.sprint1.Models;

import android.widget.ImageView;

import com.example.sprint1.R;

public class TimeFreezePowerUp implements PowerUpDecorator {
    private Player decoratedPlayer;
    private boolean active;


    public TimeFreezePowerUp(Player player) {
        decoratedPlayer = player;
        active = true;
    } // HealthPowerUp

    @Override
    public void updatePlayer() {
        if (!decoratedPlayer.getTimeFreeze()) {
            decoratedPlayer.setTimeFreeze(true);
        }
    } // updatePlayer
    @Override
    public int getPowerupID() {
        return R.drawable.sand_clock;
    }

    @Override
    public boolean getActive() {
        return active;
    }
    @Override
    public void setActive(boolean newActive) {
        active = newActive;
    }
    @Override
    public float getX(ImageView powerup) {
        if (powerup != null) {
            return powerup.getX();
        } else {
            return 0f;
        } // if
    } // getX
    @Override
    public float getY(ImageView powerup) {
        if (powerup != null) {
            return powerup.getY();
        } else {
            return 0f;
        } // if
    } // getY
}
