package com.example.sprint1.Models;

import com.example.sprint1.R;

public class SpeedPowerUp implements PowerUpDecorator{
    Player decoratedPlayer;
    public SpeedPowerUp(Player player) {
        decoratedPlayer = player;
    } // HealthPowerUp

    @Override
    public int getSpeed() {
        decoratedPlayer.setSpeed(decoratedPlayer.getSpeed() + 10);
        return decoratedPlayer.getSpeed();
    } // getSpeed

    @Override
    public int getHealth() {
        return decoratedPlayer.getHealth();
    } // getHealth

    @Override
    public boolean getInvincible() {
        return decoratedPlayer.getInvincible();
    }

    @Override
    public int getPowerupID() {
        return R.drawable.speed_potion;
    }

}
