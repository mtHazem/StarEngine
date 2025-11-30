package com.example.starengine.game.entities

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.RectF
import androidx.annotation.DrawableRes
import com.example.starengine.utils.Constants

// It's crucial that the constructor accepts a Context and a drawableId
class Alien(context: Context, x: Float, y: Float, @DrawableRes drawableId: Int) {

    private var bitmap: Bitmap
    private var bounds: RectF

    var isActive = true
        private set

    init {
        // This is where a crash would happen if the drawableId is wrong
        // or if the context is not passed correctly.
        val originalBitmap = BitmapFactory.decodeResource(context.resources, drawableId)
            ?: throw IllegalStateException("Failed to load alien bitmap with id: $drawableId")
        bitmap = Bitmap.createScaledBitmap(
            originalBitmap,
            Constants.ALIEN_WIDTH.toInt(),
            Constants.ALIEN_HEIGHT.toInt(),
            false
        )

        // Aliens spawn from the top of the screen (y=0).
        bounds = RectF(x, y, x + Constants.ALIEN_WIDTH, y + Constants.ALIEN_HEIGHT)
    }

    fun update() {
        // Move the alien down the screen.
        bounds.top += Constants.ALIEN_SPEED
        bounds.bottom = bounds.top + Constants.ALIEN_HEIGHT
    }

    fun draw(canvas: Canvas) {
        // Only draw the alien if it is active.
        if (!isActive) return
        canvas.drawBitmap(bitmap, bounds.left, bounds.top, null)
    }

    fun getBounds(): RectF {
        return bounds
    }

    fun hit() {
        // This is called when a bullet collides with the alien.
        isActive = false
    }
}
