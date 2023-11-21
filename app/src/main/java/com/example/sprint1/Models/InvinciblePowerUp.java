package com.example.sprint1.Models;

public class InvinciblePowerUp extends PowerUpDecorator{
    public InvinciblePowerUp(Player player) {
        super(player);
    } // HealthPowerUp

    @Override
    public boolean getInvincible() {
        if (!decoratedPlayer.getInvincible()) {
            decoratedPlayer.setInvincible(true);
        }
        return decoratedPlayer.getInvincible();
    } // getInvincible
}
