package com.example.sprint1.Models;

public class HealthPowerUp extends PowerUpDecorator{
    public HealthPowerUp(Player player) {
        super(player);
    } // HealthPowerUp

    @Override
    public int getHealth() {
        decoratedPlayer.setHealth(decoratedPlayer.getHealth() + 50);
        return decoratedPlayer.getHealth();
    } // getHealth
}
