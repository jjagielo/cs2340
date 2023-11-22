package com.example.sprint1.Models;

import com.example.sprint1.R;

public class InvinciblePowerUp implements PowerUpDecorator{
    private Player decoratedPlayer;
    private boolean active;


    public InvinciblePowerUp(Player player) {
        decoratedPlayer = player;
        active = true;
    } // HealthPowerUp

    @Override
    public void updatePlayer() {
        if (!decoratedPlayer.getInvincible()) {
            decoratedPlayer.setInvincible(true);
        }
    }

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
