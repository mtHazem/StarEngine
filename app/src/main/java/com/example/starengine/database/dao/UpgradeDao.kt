package com.example.starengine.database.dao

import androidx.room.*
import com.example.starengine.database.entities.Upgrade
import kotlinx.coroutines.flow.Flow

@Dao
interface UpgradeDao {
    @Query("SELECT * FROM upgrades WHERE id = 1")
    fun getUpgrade(): Flow<Upgrade?>

    @Query("SELECT * FROM upgrades WHERE id = 1")
    suspend fun getUpgradeSync(): Upgrade?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpgrade(upgrade: Upgrade)

    @Update
    suspend fun updateUpgrade(upgrade: Upgrade)
}

