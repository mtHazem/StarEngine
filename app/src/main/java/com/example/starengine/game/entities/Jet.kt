package com.example.starengine.game.entities

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.RectF

class Jet(
    var x: Float,
    var y: Float,
    val bitmap: Bitmap,
    var hasDoubleShot: Boolean = false
) {
    val width = bitmap.width
    val height = bitmap.height

    private val speed = 12f

    fun update(moveLeft: Boolean, moveRight: Boolean, screenWidth: Int) {
        if (moveLeft) x -= speed
        if (moveRight) x += speed

        if (x < 0) x = 0f
        if (x + width > screenWidth) x = (screenWidth - width).toFloat()
    }

    fun draw(canvas: Canvas) {
        canvas.drawBitmap(bitmap, x, y, null)
    }

    fun shoot(): List<Bullet> {
        val bullets = mutableListOf<Bullet>()
        if (hasDoubleShot) {
            val bulletX1 = x + width / 4f - 5f
            val bulletX2 = x + width * 3 / 4f - 5f
            val bulletY = y
            bullets.add(Bullet(bulletX1, bulletY))
            bullets.add(Bullet(bulletX2, bulletY))
        } else {
            val bulletX = x + width / 2f - 5f
            val bulletY = y
            bullets.add(Bullet(bulletX, bulletY))
        }
        return bullets
    }

    fun getCollisionRect(): RectF =
        RectF(x, y, x + width, y + height)
}
