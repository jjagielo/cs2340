package com.example.sprint1.Models;

import android.widget.ImageView;

public interface CollisionObserver {
    public boolean alertCollision(Player player, Enemy enemy);

    public boolean alertPowerupCollision(Player player, ImageView powerup);
}
