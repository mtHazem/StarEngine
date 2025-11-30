package com.example.starengine.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starengine.database.AppDatabase
import com.example.starengine.databinding.ActivityHighScoresBinding
import com.example.starengine.ui.ScoreAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HighScoresActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHighScoresBinding
    private lateinit var scoreAdapter: ScoreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHighScoresBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the adapter with an empty list first
        scoreAdapter = ScoreAdapter(emptyList())

        // Setup the RecyclerView
        binding.scoresRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@HighScoresActivity)
            adapter = scoreAdapter
        }

        // Fetch and display scores from the database
        loadScores()
    }

    private fun loadScores() {
        lifecycleScope.launch {
            // Get database instance and DAO on IO thread
            val scores = withContext(Dispatchers.IO) {
                val db = AppDatabase.getDatabase(this@HighScoresActivity)
                db.scoreDao().getAllScores()
            }

            // Update the UI on the main thread (already on main thread from lifecycleScope)
            if (scores.isEmpty()) {
                // If there are no scores, show the 'tvNoScores' TextView and hide the RecyclerView
                binding.scoresRecyclerView.visibility = View.GONE
                binding.tvNoScores.visibility = View.VISIBLE
            } else {
                // If there are scores, show the RecyclerView and update its data
                binding.scoresRecyclerView.visibility = View.VISIBLE
                binding.tvNoScores.visibility = View.GONE
                scoreAdapter.updateScores(scores)
            }
        }
    }
}
