package com.example.starengine.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.starengine.MainActivity
import com.example.starengine.database.AppDatabase
import com.example.starengine.database.entities.Score
import com.example.starengine.databinding.ActivityGameOverBinding
import com.example.starengine.ui.GameActivity
import com.example.starengine.game.effects.StarfieldView
import kotlinx.coroutines.launch

class GameOverActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameOverBinding
    private lateinit var starfieldView: StarfieldView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameOverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        starfieldView = StarfieldView(this)
        binding.starfieldContainerGameOver.addView(starfieldView)

        val scoreValue = intent.getIntExtra("score", 0)
        binding.scoreTextView.text = "Score: $scoreValue"

        if (scoreValue > 0) {
            lifecycleScope.launch {
                val score = Score(points = scoreValue, date = System.currentTimeMillis())
                AppDatabase.getDatabase(applicationContext).scoreDao().insertScore(score)
            }
        }

        binding.tryAgainButton.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        binding.homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        starfieldView.resume()
    }

    override fun onPause() {
        super.onPause()
        starfieldView.pause()
    }
}