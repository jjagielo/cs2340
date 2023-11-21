package com.example.sprint1.Models;

import android.widget.ImageView;

public abstract class PowerUpDecorator{
    Player decoratedPlayer;
    public PowerUpDecorator(Player player) {
        this.decoratedPlayer = player;
    } // PowerUpDecorator

    public int getHealth() {
        return decoratedPlayer.getHealth();
    } // getHealth

    public int getSpeed() {
        return decoratedPlayer.getSpeed();
    }

    }
}
