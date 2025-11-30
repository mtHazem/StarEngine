package com.example.starengine.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starengine.database.entities.Score
import com.example.starengine.databinding.ItemScoreBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ScoreAdapter(private var scores: List<Score>) : RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder>() {

    class ScoreViewHolder(val binding: ItemScoreBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        val binding = ItemScoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScoreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) {
        val currentScore = scores[position]

        // Display rank (position + 1)
        holder.binding.tvRank.text = "${position + 1}"

        // Using the correct IDs from item_score.xml: tvScore and tvDate
        holder.binding.tvScore.text = "Score: ${currentScore.points}"

        val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
        val dateString = sdf.format(Date(currentScore.date))

        holder.binding.tvDate.text = dateString
    }

    override fun getItemCount(): Int {
        return scores.size
    }

    fun updateScores(newScores: List<Score>) {
        this.scores = newScores
        notifyDataSetChanged()
    }
}
