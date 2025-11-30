package com.example.starengine.game.effects

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

// Manages the collection of stars for the background effect
class Starfield(screenWidth: Int, screenHeight: Int, numStars: Int = 200) {

    private val stars = List(numStars) { Star(screenWidth, screenHeight) }
    private val paint = Paint().apply {
        color = Color.WHITE
        strokeWidth = 3f // Makes the stars visible dots
    }

    fun update() {
        stars.forEach { it.update() }
    }

    fun draw(canvas: Canvas) {
        // Set a dark, "deep space" background color instead of pure black
        canvas.drawColor(Color.rgb(10, 10, 25))

        // Draw each star as a point
        stars.forEach { star ->
            // Use different paint alphas for a twinkling/depth effect
            paint.alpha = when (star.speed) {
                1f -> 150 // Dim, distant stars
                2f -> 200 // Medium brightness
                else -> 255 // Bright, close stars
            }
            canvas.drawPoint(star.x, star.y, paint)
        }
    }
}