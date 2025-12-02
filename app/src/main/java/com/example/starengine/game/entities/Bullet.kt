package com.example.starengine.game.entities

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import com.example.starengine.utils.Constants

class Bullet(private var x: Float, private var y: Float) {

    private val radius = 10f

    private val innerPaint = Paint().apply {
        color = Color.WHITE
    }

    private val outerPaint = Paint().apply {
        color = Color.CYAN
    }

    var isActive = true
        private set

    fun update() {
        y -= Constants.BULLET_SPEED
        if (y < 0) {
            isActive = false
        }
    }

    fun draw(canvas: Canvas) {
        if (isActive) {
            canvas.drawCircle(x, y, radius, outerPaint)
            canvas.drawCircle(x, y, radius / 2, innerPaint)
        }
    }

    fun getBounds(): RectF = RectF(x - radius, y - radius, x + radius, y + radius)

    fun deactivate() {
        isActive = false
    }
}
