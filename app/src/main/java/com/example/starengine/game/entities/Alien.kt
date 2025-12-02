package com.example.starengine.game.entities

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.RectF
import androidx.annotation.DrawableRes
import com.example.starengine.utils.Constants

class Alien(context: Context, x: Float, y: Float, @DrawableRes drawableId: Int) {

    private val bitmap: Bitmap
    private val bounds: RectF

    var isActive = true
        private set

    init {
        val originalBitmap = BitmapFactory.decodeResource(context.resources, drawableId)
            ?: throw IllegalStateException("Failed to load alien bitmap with id: $drawableId")

        bitmap = Bitmap.createScaledBitmap(
            originalBitmap,
            Constants.ALIEN_WIDTH.toInt(),
            Constants.ALIEN_HEIGHT.toInt(),
            false
        )

        bounds = RectF(x, y, x + Constants.ALIEN_WIDTH, y + Constants.ALIEN_HEIGHT)
    }

    fun update() {
        bounds.top += Constants.ALIEN_SPEED
        bounds.bottom = bounds.top + Constants.ALIEN_HEIGHT
    }

    fun draw(canvas: Canvas) {
        if (isActive) {
            canvas.drawBitmap(bitmap, bounds.left, bounds.top, null)
        }
    }

    fun getBounds(): RectF = bounds

    fun hit() {
        isActive = false
    }
}
