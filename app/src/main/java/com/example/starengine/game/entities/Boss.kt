package com.example.starengine.game.entities

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.RectF
import com.example.starengine.R
import com.example.starengine.utils.Constants

data class Boss(
    var x: Float,
    var y: Float,
    var health: Int,
    var maxHealth: Int,
    val bitmap: Bitmap,
    val bulletSpeedMultiplier: Float
) {
    val width: Int get() = bitmap.width
    val height: Int get() = bitmap.height

    fun update() {
        if (y < 150f) { // Allow boss to move further down
            y += 2f
        }
    }

    fun draw(canvas: Canvas) {
        canvas.drawBitmap(bitmap, x, y, null)

        // Draw health bar
        val healthBarWidth = width * (health.toFloat() / maxHealth)
        val healthBarRect = RectF(x, y - 20, x + healthBarWidth, y - 10)
        canvas.drawRect(x, y - 20, x + width, y - 10, Constants.healthBarBackgroundPaint)
        canvas.drawRect(healthBarRect, Constants.healthBarPaint)
    }

    companion object {
        fun create(resources: Resources, screenWidth: Int, healthMultiplier: Float, bulletSpeedMultiplier: Float): Boss {
            val originalBitmap = BitmapFactory.decodeResource(resources, R.drawable.bossship)
            val scaledBitmap = Bitmap.createScaledBitmap(
                originalBitmap,
                (screenWidth * 0.8).toInt(),
                (Constants.SCREEN_HEIGHT / 4).toInt(),
                true
            )
            val initialHealth = (1000 * healthMultiplier).toInt()
            val x = (screenWidth / 2f) - (scaledBitmap.width / 2f)
            val y = -scaledBitmap.height.toFloat()
            return Boss(x, y, initialHealth, initialHealth, scaledBitmap, bulletSpeedMultiplier)
        }
    }
}