package com.example.starengine.database.dao

import androidx.room.*
import com.example.starengine.database.entities.Score
import kotlinx.coroutines.flow.Flow

@Dao
interface ScoreDao {
    @Query("SELECT * FROM scores ORDER BY points DESC LIMIT 5")
    fun getTop5Scores(): Flow<List<Score>>

    @Query("SELECT * FROM scores ORDER BY points DESC LIMIT 5")
    suspend fun getTop5ScoresList(): List<Score>

    @Query("SELECT * FROM scores")
    suspend fun getAllScores(): List<Score>

    @Insert
    suspend fun insertScore(score: Score)

    @Query("DELETE FROM scores")
    suspend fun deleteAllScores()
}

