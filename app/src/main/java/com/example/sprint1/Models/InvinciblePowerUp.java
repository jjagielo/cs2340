package com.example.sprint1.Models;

import com.example.sprint1.R;

public class InvinciblePowerUp implements PowerUpDecorator{
    Player decoratedPlayer;
    public InvinciblePowerUp(Player player) {
        decoratedPlayer = player;
    } // HealthPowerUp

    @Override
    public boolean getInvincible() {
        if (!decoratedPlayer.getInvincible()) {
            decoratedPlayer.setInvincible(true);
        }
        return decoratedPlayer.getInvincible();
    }
    @Override
    public int getHealth() {
        return decoratedPlayer.getHealth();
    } // getHealth

    @Override
    public int getSpeed() {
        return decoratedPlayer.getSpeed();
    }

    @Override
    public int getPowerupID() {
        return R.drawable.health_potion;
    }
}
