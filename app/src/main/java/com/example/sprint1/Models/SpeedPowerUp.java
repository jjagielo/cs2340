package com.example.sprint1.Models;

public class SpeedPowerUp extends PowerUpDecorator{
    public SpeedPowerUp(Player player) {
        super(player);
    } // HealthPowerUp
    
    @Override
    public int getSpeed() {
        decoratedPlayer.setSpeed(decoratedPlayer.getSpeed() + 10);
        return decoratedPlayer.getSpeed();
    } // getSpeed
}
