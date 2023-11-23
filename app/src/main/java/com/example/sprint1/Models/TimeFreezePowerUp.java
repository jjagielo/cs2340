package com.example.sprint1.Models;

import com.example.sprint1.R;

public class TimeFreezePowerUp implements PowerUpDecorator{
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
    }

    @Override
    public int getPowerupID() {
        return R.drawable.sand_clock;
    }

    public boolean getActive() {
        return active;
    }
    public void setActive(boolean newActive) {
        active = newActive;
    }
}
