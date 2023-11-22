package com.example.sprint1.Models;

public interface PowerUpDecorator{

    public void updatePlayer();

    public int getPowerupID();
    public boolean getActive();
    public void setActive(boolean newActive);
}
