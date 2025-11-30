package com.example.starengine.game

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.starengine.R
import com.example.starengine.game.effects.Starfield
import com.example.starengine.game.entities.Alien
import com.example.starengine.game.entities.Bullet
import com.example.starengine.game.entities.Jet
import com.example.starengine.utils.Constants
import java.util.concurrent.CopyOnWriteArrayList

class GameEngine(
    private val context: Context,
    private val screenWidth: Int,
    private val screenHeight: Int
) {
    private val starfield = Starfield(screenWidth, screenHeight)
    val jet = Jet(context, screenWidth, screenHeight)
    private val bullets = CopyOnWriteArrayList<Bullet>()
    private val aliens = CopyOnWriteArrayList<Alien>()

    private var lastAlienSpawnTime = 0L
    private var alienSpawnDelay = Constants.INITIAL_ALIEN_SPAWN_DELAY

    // --- CONTINUOUS FIRING LOGIC ---
    private var isFiring = false
    private var lastShotTime = 0L
    private val fireRateDelay = 250L // Milliseconds between shots.

    // --- NEW: AMMO & RECHARGE LOGIC ---
    private val maxAmmo = 20
    private var currentAmmo = maxAmmo
    private val ammoRechargeDelay = 100L // Time in ms to recharge 1 ammo.
    private var lastAmmoRechargeTime = 0L

    var score = 0
    var isGameOver = false

    // --- PAINTS for UI Text ---
    private val scorePaint = Paint().apply {
        color = Color.WHITE
        textSize = 60f
        textAlign = Paint.Align.LEFT
    }
    // NEW Paint for ammo text
    private val ammoPaint = Paint().apply {
        color = Color.CYAN // A different color to stand out
        textSize = 60f
        textAlign = Paint.Align.RIGHT // Align to the right of the screen
    }
    private val gameOverPaint = Paint().apply {
        color = Color.RED
        textSize = 120f
        textAlign = Paint.Align.CENTER
    }

    fun update() {
        starfield.update()
        if (isGameOver) return

        jet.update()
        spawnAliens()

        // Check if we should fire a bullet in this frame.
        handleShooting()

        // --- NEW: Handle ammo recharge every frame ---
        rechargeAmmo()

        bullets.forEach { it.update() }
        bullets.removeAll { !it.isActive }

        aliens.forEach { alien ->
            alien.update()
            if (alien.isActive && jet.getBounds().intersect(alien.getBounds())) {
                isGameOver = true
            }
        }
        aliens.removeAll { !it.isActive || it.getBounds().top > screenHeight }

        checkCollisions()
    }

    fun draw(canvas: Canvas) {
        starfield.draw(canvas)
        jet.draw(canvas)
        bullets.forEach { it.draw(canvas) }
        aliens.forEach { it.draw(canvas) }

        // Draw Score on the top-left
        canvas.drawText("Score: $score", 40f, 80f, scorePaint)

        // --- NEW: Draw Ammo on the top-right ---
        canvas.drawText("Ammo: $currentAmmo", screenWidth - 40f, 80f, ammoPaint)

        if (isGameOver) {
            val centerX = screenWidth / 2f
            val centerY = screenHeight / 2f
            canvas.drawText("GAME OVER", centerX, centerY, gameOverPaint)
        }
    }

    fun handleTouch(x: Float, isTouching: Boolean) {
        if (!isGameOver) {
            jet.targetX = x
            isFiring = isTouching
        } else {
            isFiring = false
        }
    }

    private fun shoot() {
        val newBullet = jet.shoot()
        bullets.add(newBullet)
        lastShotTime = System.currentTimeMillis()
        currentAmmo-- // --- NEW: Decrease ammo on shot ---
    }

    // MODIFIED to check for ammo
    private fun handleShooting() {
        if (isFiring && currentAmmo > 0) { // --- NEW: check currentAmmo > 0 ---
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastShotTime > fireRateDelay) {
                shoot()
            }
        }
    }

    // --- NEW: Method to handle ammo recharge ---
    private fun rechargeAmmo() {
        // Don't recharge if player is actively firing
        if (isFiring) {
            // Reset the recharge timer while firing to prevent recharge-while-shooting
            lastAmmoRechargeTime = System.currentTimeMillis()
            return
        }

        if (currentAmmo < maxAmmo) {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastAmmoRechargeTime > ammoRechargeDelay) {
                currentAmmo++
                lastAmmoRechargeTime = currentTime
            }
        }
    }

    private fun spawnAliens() {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastAlienSpawnTime > alienSpawnDelay) {
            lastAlienSpawnTime = currentTime
            val x = (0..(screenWidth - Constants.ALIEN_WIDTH.toInt())).random().toFloat()
            val alienDrawables = listOf(R.drawable.alien1, R.drawable.alien2, R.drawable.alien3)
            val randomAlienDrawable = alienDrawables.random()
            aliens.add(Alien(context, x, 0f, randomAlienDrawable))
            alienSpawnDelay = (alienSpawnDelay * 0.99).toLong().coerceAtLeast(Constants.MIN_ALIEN_SPAWN_DELAY)
        }
    }

    private fun checkCollisions() {
        for (bullet in bullets) {
            if (!bullet.isActive) continue
            for (alien in aliens) {
                if (!alien.isActive) continue
                if (bullet.getBounds().intersect(alien.getBounds())) {
                    alien.hit()
                    bullet.deactivate()
                    score += Constants.POINTS_PER_ALIEN
                    break
                }
            }
        }
    }

    fun reset() {
        jet.reset()
        bullets.clear()
        aliens.clear()
        score = 0
        isGameOver = false
        isFiring = false
        currentAmmo = maxAmmo // --- NEW: Reset ammo ---
        lastAlienSpawnTime = 0L
        alienSpawnDelay = Constants.INITIAL_ALIEN_SPAWN_DELAY
    }
}