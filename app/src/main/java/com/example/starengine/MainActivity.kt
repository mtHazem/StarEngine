package com.example.starengine

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.starengine.databinding.ActivityMainBinding
import com.example.starengine.game.effects.StarfieldView
import com.example.starengine.ui.GameActivity
import com.example.starengine.ui.HighScoresActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // Declare binding variable
    private lateinit var starfieldView: StarfieldView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate the layout using View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        binding.highScoresButton.setOnClickListener {
            val intent = Intent(this, HighScoresActivity::class.java)
            startActivity(intent)
        }

        binding.exitButton.setOnClickListener {
            finish()
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
