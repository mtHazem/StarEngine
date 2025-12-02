package com.example.starengine.utils

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Paint

object Constants {
    // --- Game Loop Timing ---
    private const val TARGET_FPS = 60
    const val FRAME_TIME_MS = (1000.0 / TARGET_FPS).toLong()

    // --- Player Jet ---
    const val JET_WIDTH = 100f
    const val JET_HEIGHT = 100f
    const val JET_MOVE_SPEED = 20f

    // --- Player Bullet ---
    const val BULLET_WIDTH = 20f
    const val BULLET_HEIGHT = 40f
    const val BULLET_SPEED = 30f

    // --- Ammo ---
    const val MAX_AMMO = 20

    // --- Enemy Alien ---
    const val ALIEN_WIDTH = 120f
    const val ALIEN_HEIGHT = 120f
    const val ALIEN_SPEED = 5f
    const val INITIAL_ALIEN_SPAWN_DELAY = 2000L
    const val MIN_ALIEN_SPAWN_DELAY = 500L

    // --- Boss ---
    const val BOSS_WIDTH = 200f
    const val BOSS_HEIGHT = 200f

    // --- Scoring ---
    const val POINTS_PER_ALIEN = 10

    // --- Upgrades ---
    const val FIRE_RATE_UPGRADE_COST = 50
    const val BULLET_POWER_UPGRADE_COST = 100
    const val SHIP_WIDTH_UPGRADE_COST = 75

    // --- GameView Required Constants ---
    var SCREEN_WIDTH: Int = 0
    var SCREEN_HEIGHT: Int = 0

    var JET_BITMAP: Bitmap? = null

    val redPaint: Paint = Paint().apply {
        color = Color.RED
        style = Paint.Style.FILL
    }

    val healthBarPaint: Paint = Paint().apply {
        color = Color.GREEN
        style = Paint.Style.FILL
    }

    val healthBarBackgroundPaint: Paint = Paint().apply {
        color = Color.DKGRAY
        style = Paint.Style.FILL
    }
}