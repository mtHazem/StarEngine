package com.example.starengine.game

import android.content.Context
import android.graphics.Canvas
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.example.starengine.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class GameView(context: Context) : SurfaceView(context), SurfaceHolder.Callback {

    // --- MODIFIED: Changed from 'private' to 'internal' ---
    // This allows GameActivity to access the engine to check the score and game over state.
    internal lateinit var gameEngine: GameEngine
    private var gameJob: Job? = null

    init {
        holder.addCallback(this)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        if (!this::gameEngine.isInitialized) {
            gameEngine = GameEngine(context, width, height)
        }
        startGameLoop()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        // Not needed for this game
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        stopGameLoop()
    }

    private fun startGameLoop() {
        stopGameLoop() // Ensure only one loop runs at a time
        gameJob = CoroutineScope(Dispatchers.Default).launch {
            while (isActive) {
                val startTime = System.currentTimeMillis()

                gameEngine.update()
                drawGame()

                val timeTaken = System.currentTimeMillis() - startTime
                val sleepTime = Constants.FRAME_TIME_MS - timeTaken
                if (sleepTime > 0) {
                    delay(sleepTime)
                }
            }
        }
    }

    private fun stopGameLoop() {
        gameJob?.cancel()
        gameJob = null
    }

    private fun drawGame() {
        if (holder.surface.isValid) {
            val canvas: Canvas? = holder.lockCanvas()
            if (canvas != null) {
                try {
                    synchronized(holder) {
                        gameEngine.draw(canvas)
                    }
                } finally {
                    holder.unlockCanvasAndPost(canvas)
                }
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val isTouching = event.action == MotionEvent.ACTION_DOWN || event.action == MotionEvent.ACTION_MOVE

        // Pass the touch coordinate and the touching state to the engine
        gameEngine.handleTouch(event.x, isTouching)

        // When the finger is lifted, ensure firing stops
        if (event.action == MotionEvent.ACTION_UP) {
            gameEngine.handleTouch(event.x, false)
        }

        return true
    }

    fun pause() {
        stopGameLoop()
    }

    fun resume() {
        // Only start the loop if the surface is already valid (e.g., returning to the app)
        if (holder.surface.isValid) {
            startGameLoop()
        }
    }
}
