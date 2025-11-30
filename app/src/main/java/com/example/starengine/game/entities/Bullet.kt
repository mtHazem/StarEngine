package com.example.starengine.game.entities

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import com.example.starengine.utils.Constants

// This constructor only needs the starting x and y coordinates.
class Bullet(x: Float, y: Float) {

    private val bounds: RectF = RectF(
        x,
        y,
        x + Constants.BULLET_WIDTH,
        y + Constants.BULLET_HEIGHT
    )

    private val paint = Paint().apply {
        color = Color.YELLOW
    }

    var isActive = true
        private set

    fun update() {
        // Move the bullet up the screen
        bounds.top -= Constants.BULLET_SPEED
        bounds.bottom = bounds.top + Constants.BULLET_HEIGHT

        // Deactivate if it goes off the top of the screen
        if (bounds.bottom < 0) {
            isActive = false
        }
    }

    fun draw(canvas: Canvas) {
        if (!isActive) return
        canvas.drawRect(bounds, paint)
    }

    fun getBounds(): RectF {
        return bounds
    }

    fun deactivate() {
        isActive = false
    }
}
