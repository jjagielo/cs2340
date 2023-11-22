package com.example.sprint1.Models;

import com.example.sprint1.R;

public class SpeedPowerUp implements PowerUpDecorator{
    private Player decoratedPlayer;
    private boolean active;


    public SpeedPowerUp(Player player) {
        decoratedPlayer = player;
        active = true;
    } // HealthPowerUp

    @Override
    public void updatePlayer() {
        decoratedPlayer.setSpeed(decoratedPlayer.getSpeed() + 10);
    } // getSpeed

    @Override
    public int getPowerupID() {
        return R.drawable.speed_potion;
    }

    public boolean getActive() {
        return active;
    }
    public void setActive(boolean newActive) {
        active = newActive;
    }

}
