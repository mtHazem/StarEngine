package com.example.starengine.game.entities

import android.graphics.RectF

data class BossBullet(
    var x: Float,
    var y: Float,
    val speed: Float,
    var angle: Float,
    val size: Float = 25f
) {
    var isActive = true

    fun update() {
        val rad = Math.toRadians(angle.toDouble())
        x += (kotlin.math.cos(rad) * speed).toFloat()
        y += (kotlin.math.sin(rad) * speed).toFloat()
    }

    fun getBounds(): RectF {
        val r = size / 2f
        return RectF(x - r, y - r, x + r, y + r)
    }
}
