package com.example.sprint1.Models;

import com.example.sprint1.R;
import com.example.sprint1.ViewModels.GameScreen;

import android.widget.ImageView;
public class HealthPowerUp implements PowerUpDecorator{
    private Player decoratedPlayer;
    private boolean active;

    public HealthPowerUp(Player player) {
        decoratedPlayer = player;
        active = true;
    } // HealthPowerUp

    @Override
    public void updatePlayer() {
        decoratedPlayer.setHealth(decoratedPlayer.getHealth() + 50);
    } // getHealth

    @Override
    public int getPowerupID() {
        return R.drawable.health_potion;
    }

    public boolean getActive() {
        return active;
    }
    public void setActive(boolean newActive) {
        active = newActive;
    }
}
