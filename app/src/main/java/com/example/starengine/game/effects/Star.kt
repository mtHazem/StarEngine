package com.example.starengine.game.effects

import kotlin.random.Random

// Represents a single star in our starfield
class Star(private val screenWidth: Int, private val screenHeight: Int) {
    var x: Float = 0f
    var y: Float = 0f
    var speed: Float = 0f

    init {
        // Initialize with random position and speed
        randomize(true)
    }

    // Move the star down the screen
    fun update() {
        y += speed
        // If the star goes off-screen, reset it to the top
        if (y > screenHeight) {
            randomize(false)
        }
    }

    // Place the star at a random X and a specified Y
    private fun randomize(atRandomY: Boolean) {
        x = Random.nextFloat() * screenWidth
        y = if (atRandomY) Random.nextFloat() * screenHeight else -20f // Start just off-screen
        // Different speeds for a parallax effect
        speed = when (Random.nextInt(3)) {
            0 -> 1f // Slowest
            1 -> 2f // Medium
            else -> 3f // Fastest
        }
    }
}