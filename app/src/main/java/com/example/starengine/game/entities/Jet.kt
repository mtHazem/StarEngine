package com.example.starengine.game.entities

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.RectF
import com.example.starengine.R
import com.example.starengine.utils.Constants

class Jet(context: Context, private val screenWidth: Int, private val screenHeight: Int) {

    private var bitmap: Bitmap
    private var bounds: RectF
    var targetX: Float

    // A factor for smoothing the movement (Lerp). 0.0 to 1.0. Higher is faster.
    private val moveFactor = 0.2f // You can tweak this value! Try 0.1f for smoother, 0.5f for faster.

    init {
        bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.jet)
        bitmap = Bitmap.createScaledBitmap(bitmap, Constants.JET_WIDTH.toInt(), Constants.JET_HEIGHT.toInt(), false)

        val startX = (screenWidth / 2f) - (Constants.JET_WIDTH / 2f)
        // --- JET POSITION CHANGE ---
        // Increased the offset from 250f to 400f to move it higher.
        val startY = screenHeight - Constants.JET_HEIGHT - 400f

        bounds = RectF(startX, startY, startX + Constants.JET_WIDTH, startY + Constants.JET_HEIGHT)
        targetX = bounds.left
    }

    fun update() {
        // --- SMOOTHER MOVEMENT LOGIC ---
        // This is a much better way to handle smooth movement.
        // It moves the jet a fraction of the distance to the target each frame.
        val distance = targetX - bounds.left
        bounds.left += distance * moveFactor
        bounds.right = bounds.left + Constants.JET_WIDTH

        // Keep the jet within the screen bounds
        if (bounds.left < 0) {
            bounds.left = 0f
            bounds.right = Constants.JET_WIDTH
        }
        if (bounds.right > screenWidth) {
            bounds.right = screenWidth.toFloat()
            bounds.left = screenWidth - Constants.JET_WIDTH
        }
    }

    fun draw(canvas: Canvas) {
        canvas.drawBitmap(bitmap, bounds.left, bounds.top, null)
    }

    fun shoot(): Bullet {
        val bulletX = bounds.centerX() - (Constants.BULLET_WIDTH / 2)
        val bulletY = bounds.top
        return Bullet(bulletX, bulletY)
    }

    fun getBounds(): RectF {
        return bounds
    }

    fun reset() {
        val startX = (screenWidth / 2f) - (Constants.JET_WIDTH / 2f)
        bounds.left = startX
        bounds.right = startX + Constants.JET_WIDTH
        targetX = bounds.left
    }
}