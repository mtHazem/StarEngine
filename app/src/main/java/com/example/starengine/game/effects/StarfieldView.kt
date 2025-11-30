package com.example.starengine.game.effects

import android.content.Context
import android.graphics.Canvas
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.example.starengine.utils.Constants
import kotlinx.coroutines.*

class StarfieldView(context: Context) : SurfaceView(context), SurfaceHolder.Callback {

    private lateinit var starfield: Starfield
    private var drawingJob: Job? = null

    init {
        holder.addCallback(this)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        // Initialize starfield here with correct dimensions
        starfield = Starfield(width, height)
        resume()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        // Not needed for this simple view
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        pause()
    }

    fun pause() {
        drawingJob?.cancel()
        drawingJob = null
    }

    fun resume() {
        if (drawingJob == null) {
            drawingJob = CoroutineScope(Dispatchers.Default).launch {
                while (isActive) {
                    if (holder.surface.isValid) {
                        val canvas = holder.lockCanvas()
                        if (canvas != null) {
                            starfield.update()
                            starfield.draw(canvas)
                            holder.unlockCanvasAndPost(canvas)
                        }
                    }
                    delay(Constants.FRAME_TIME_MS)
                }
            }
        }
    }
}