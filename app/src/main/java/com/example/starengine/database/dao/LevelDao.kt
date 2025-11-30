package com.example.starengine.database.dao

import androidx.room.*
import com.example.starengine.database.entities.Level
import kotlinx.coroutines.flow.Flow

@Dao
interface LevelDao {
    @Query("SELECT * FROM levels WHERE levelNumber = :levelNumber")
    suspend fun getLevel(levelNumber: Int): Level?

    @Query("SELECT * FROM levels")
    fun getAllLevels(): Flow<List<Level>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLevel(level: Level)

    @Query("DELETE FROM levels")
    suspend fun deleteAllLevels()
}

