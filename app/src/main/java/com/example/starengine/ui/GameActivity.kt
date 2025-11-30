package com.example.starengine.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.starengine.database.AppDatabase
import com.example.starengine.database.entities.Score
import com.example.starengine.game.GameView
import kotlinx.coroutines.launch

class GameActivity : AppCompatActivity() {

    private lateinit var gameView: GameView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameView = GameView(this)
        setContentView(gameView)
    }

    override fun onPause() {
        super.onPause()
        gameView.pause()
        // Save the score when the activity is paused (e.g., back button)
        saveScoreIfGameOver()
    }

    override fun onResume() {
        super.onResume()
        gameView.resume()
    }

    private fun saveScoreIfGameOver() {
        // Check if the game engine exists and if the game is actually over
        if (this::gameView.isInitialized && gameView.gameEngine.isGameOver) {
            val finalScore = gameView.gameEngine.score

            // Don't save scores of 0
            if (finalScore > 0) {
                // Launch a coroutine to perform the database operation
                lifecycleScope.launch {
                    val scoreEntity = Score(points = finalScore, date = System.currentTimeMillis())
                    val database = AppDatabase.getDatabase(this@GameActivity)

                    // The most likely correct method name is `insertScore`
                    database.scoreDao().insertScore(scoreEntity)
                }
            }
        }
    }
}
