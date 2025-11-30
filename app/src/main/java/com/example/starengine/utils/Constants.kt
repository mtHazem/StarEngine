package com.example.starengine.utils

object Constants {
    // --- Game Loop Timing ---
    private const val TARGET_FPS = 60
    const val FRAME_TIME_MS = (1000.0 / TARGET_FPS).toLong()

    // --- Player Jet ---
    const val JET_WIDTH = 150f
    const val JET_HEIGHT = 150f
    const val JET_MOVE_SPEED = 20f

    // --- Player Bullet ---
    const val BULLET_WIDTH = 20f
    const val BULLET_HEIGHT = 40f
    const val BULLET_SPEED = 30f

    // --- Enemy Alien ---
    const val ALIEN_WIDTH = 120f
    const val ALIEN_HEIGHT = 120f
    const val ALIEN_SPEED = 5f
    const val INITIAL_ALIEN_SPAWN_DELAY = 2000L
    const val MIN_ALIEN_SPAWN_DELAY = 500L

    // --- Scoring ---
    const val POINTS_PER_ALIEN = 10

    // --- Upgrades --- // <-- ADD THIS ENTIRE SECTION
    const val FIRE_RATE_UPGRADE_COST = 50
    const val BULLET_POWER_UPGRADE_COST = 100
    const val SHIP_WIDTH_UPGRADE_COST = 75
}
