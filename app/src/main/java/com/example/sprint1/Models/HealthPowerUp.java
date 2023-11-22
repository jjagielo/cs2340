package com.example.sprint1.Models;

import com.example.sprint1.R;
import com.example.sprint1.ViewModels.GameScreen;

import android.widget.ImageView;
public class HealthPowerUp implements PowerUpDecorator{
    Player decoratedPlayer;

    public HealthPowerUp(Player player) {
        decoratedPlayer = player;
    } // HealthPowerUp

    @Override
    public int getHealth() {
        decoratedPlayer.setHealth(decoratedPlayer.getHealth() + 50);
        return decoratedPlayer.getHealth();
    } // getHealth

    @Override
    public int getSpeed() {
        return decoratedPlayer.getSpeed();
    }

    @Override
    public boolean getInvincible() {
        return decoratedPlayer.getInvincible();
    }

    @Override
    public int getPowerupID() {
        return R.drawable.health_potion;
    }
}
