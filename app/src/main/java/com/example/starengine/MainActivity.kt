package com.example.starengine.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.starengine.R
import com.example.starengine.databinding.ActivityMainBinding
import com.example.starengine.game.effects.StarfieldView
import com.example.starengine.ui.GameActivity
import com.example.starengine.ui.HighScoresActivity
import com.example.starengine.ui.UpgradesActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // Declare binding variable
    private lateinit var starfieldView: StarfieldView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate the layout using View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize SharedPreferences for storing points
        sharedPreferences = getSharedPreferences("game_prefs", MODE_PRIVATE)

        // --- Setup Starfield Background ---
        starfieldView = StarfieldView(this)
        binding.starfieldContainer.addView(starfieldView)

        // --- Animations ---
        val pulseAnimation = AnimationUtils.loadAnimation(this, R.anim.button_pulse)
        binding.startGameButton.startAnimation(pulseAnimation)

        // --- Click Listeners ---
        binding.startGameButton.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }

        binding.upgradesButton.setOnClickListener {
            val intent = Intent(this, UpgradesActivity::class.java)
            startActivity(intent)
        }

        binding.highScoresButton.setOnClickListener {
            val intent = Intent(this, HighScoresActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loadAndDisplayPoints() {
        // Load points from SharedPreferences, defaulting to 0
        val currentPoints = sharedPreferences.getInt("user_points", 0)
        binding.pointsBalanceTextView.text = "Points: $currentPoints"
    }

    override fun onResume() {
        super.onResume()
        starfieldView.resume()
        // Refresh points balance every time the activity is shown
        loadAndDisplayPoints()
    }

    override fun onPause() {
        super.onPause()
        starfieldView.pause()
    }
}
