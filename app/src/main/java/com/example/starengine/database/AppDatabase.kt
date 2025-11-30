package com.example.starengine.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.starengine.database.dao.LevelDao
import com.example.starengine.database.dao.ScoreDao
import com.example.starengine.database.dao.UpgradeDao
import com.example.starengine.database.entities.Level
import com.example.starengine.database.entities.Score
import com.example.starengine.database.entities.Upgrade
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [Score::class, Upgrade::class, Level::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun scoreDao(): ScoreDao
    abstract fun upgradeDao(): UpgradeDao
    abstract fun levelDao(): LevelDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "star_engine_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                
                // Initialize default data
                initializeDefaultData(instance)
                
                instance
            }
        }

        private fun initializeDefaultData(database: AppDatabase) {
            CoroutineScope(Dispatchers.IO).launch {
                // Initialize default upgrade if not exists
                val existingUpgrade = database.upgradeDao().getUpgradeSync()
                if (existingUpgrade == null) {
                    database.upgradeDao().insertUpgrade(
                        Upgrade(
                            id = 1,
                            speed = 1.0f,
                            fireRate = 1.0f,
                            power = 1,
                            shipWidth = 1.0f
                        )
                    )
                }

                // Initialize default levels - check if level 1 exists
                val level1 = database.levelDao().getLevel(1)
                if (level1 == null) {
                    // Create 10 default levels with increasing difficulty
                    for (i in 1..10) {
                        database.levelDao().insertLevel(
                            Level(
                                levelNumber = i,
                                difficultySpeed = 1.0f + (i - 1) * 0.2f,
                                alienRate = 0.5f + (i - 1) * 0.1f
                            )
                        )
                    }
                }
            }
        }
    }
}

